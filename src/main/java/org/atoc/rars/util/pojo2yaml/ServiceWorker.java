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
    private OutputHandler outputHandler;

    public ServiceWorker(List<String> packages,String rootPackage,OutputHandler oHandler) {
        this.packages = packages;
        this.rootPackage = rootPackage;
        this.outputHandler = oHandler;
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
            Set<Class<? extends Enum>> enums = reflections.getSubTypesOf(Enum.class);
            enums.stream().forEach( en -> {
                EnumWorker enumWorker = new EnumWorker(en,rootPackage);
                enumWorker.process(outputHandler);
            });

            Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
            classes.stream().forEach( cl -> {
                if( isWeirdCase(cl) ) {
                    System.out.println(String.format("skip UNKNOWN: %s ...",cl.getCanonicalName()));
                } else {
                    ClassWorker classWorker = new ClassWorker(cl,rootPackage);
                    classWorker.process(outputHandler);
                }
            });
            System.out.println("-- done");
        });
        outputHandler.close();
    }
}
