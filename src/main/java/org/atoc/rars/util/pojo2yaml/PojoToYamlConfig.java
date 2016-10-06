package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.io.IOException;
import java.util.*;

/**
 * Created by radu on 05.10.2016.
 */
public class PojoToYamlConfig {
    @Getter
    private Map<String,ServiceConfig> servicesInfo = new HashMap<String,ServiceConfig>();
    private String basePackage;

    public PojoToYamlConfig(@JsonProperty("services") Map<String,ServiceConfig> services,
                            @JsonProperty("basePackage") String basePackage) {
        this.servicesInfo = services;
        this.basePackage = basePackage;
    }

    public void process(String serviceName) throws IOException {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());
        ConfigurationBuilder rootCBuilder = new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false /* don't exclude Object.class */),
                new ResourcesScanner())
            .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])));

        this.servicesInfo.get(serviceName).buildWorker(basePackage).process(rootCBuilder);
    }
}
