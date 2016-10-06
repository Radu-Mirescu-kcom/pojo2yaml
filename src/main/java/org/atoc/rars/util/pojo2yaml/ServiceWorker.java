package org.atoc.rars.util.pojo2yaml;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.List;
import java.util.Set;

/**
 * Created by radu on 06.10.2016.
 */
public class ServiceWorker {
    private List<String> packages;

    public ServiceWorker(List<String> packages) {
        this.packages = packages;
    }

    public void process(ConfigurationBuilder rootCBuilder) {
        packages.stream().forEach( pkg -> {
            System.out.println(String.format("-- processing %s",pkg));
            Reflections reflections = new Reflections(
                rootCBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(pkg)))
            );
            Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
            classes.stream().forEach( cl -> {
                System.out.println(String.format("processing CLASS: %s",cl.getCanonicalName()));
            });
            System.out.println("-- done");
        });
    }
}
