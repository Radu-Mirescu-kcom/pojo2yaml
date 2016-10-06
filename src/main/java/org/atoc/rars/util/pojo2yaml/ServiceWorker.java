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
    private String rootPackage;

    public ServiceWorker(List<String> packages,String rootPackage) {
        this.packages = packages;
        this.rootPackage = rootPackage;
    }

    private boolean isWeirdCase(Class<? extends Object> cl) {
        if( cl.isSynthetic() ) {
            return true;
        }
        if( cl.isEnum() ) {
            return true;
        }
        if( cl.isLocalClass() ) {
            return true;
        }
        if( cl.isMemberClass() ) {
            return true;
        }
        if( cl.isAnnotation() ) {
            return true;
        }
        if( cl.isArray() ) {
            return true;
        }
        if( cl.isInterface() ) {
            return true;
        }
        if( cl.isAnonymousClass() ) {
            return true;
        }
        if( cl.isSynthetic() ) {
            return true;
        }
        if( cl.isPrimitive() ) {
            return true;
        }
        return false;
    }

    public void process(ConfigurationBuilder rootCBuilder) {
        packages.stream().forEach( pkg -> {
            System.out.println(String.format("-- processing %s",pkg));
            Reflections reflections = new Reflections(
                rootCBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(pkg)))
            );
            Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
            classes.stream().forEach( cl -> {
                if( isWeirdCase(cl) ) {
                    System.out.println(String.format("skip UNKNOWN: %s ...",cl.getCanonicalName()));
                } else {
                    ClassWorker classWorker = new ClassWorker(cl,rootPackage);
                    classWorker.process();
                }
            });
            System.out.println("-- done");
        });
    }
}
