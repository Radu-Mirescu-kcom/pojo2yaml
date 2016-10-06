package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

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

    public void process() {
        List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
        classLoadersList.add(ClasspathHelper.contextClassLoader());
        classLoadersList.add(ClasspathHelper.staticClassLoader());
        ConfigurationBuilder rootCBuilder = new ConfigurationBuilder()
            .setScanners(new SubTypesScanner(false /* don't exclude Object.class */),
                new ResourcesScanner())
            .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])));

        this.servicesInfo.values().stream().forEach( sc -> {
            ServiceWorker sw = sc.buildWorker(basePackage);
            sw.process(rootCBuilder);
        });
    }
}
