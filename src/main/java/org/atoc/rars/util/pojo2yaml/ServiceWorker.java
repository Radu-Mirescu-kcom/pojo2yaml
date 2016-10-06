package org.atoc.rars.util.pojo2yaml;

import org.reflections.Reflections;

import java.util.Set;

/**
 * Created by radu on 06.10.2016.
 */
public class ServiceWorker {
    private String packageName;

    public ServiceWorker(String packageName) {
        this.packageName = packageName;
    }

    public void process() {
        System.out.println(String.format("-- processing %s",packageName));
        Reflections reflections = new Reflections(packageName);
        Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
        classes.stream().forEach( cl -> {
            System.out.println(String.format("processing CLASS: %s",cl.getCanonicalName()));
        });
        System.out.println("-- done");
    }
}
