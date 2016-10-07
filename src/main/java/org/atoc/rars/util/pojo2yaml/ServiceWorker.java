package org.atoc.rars.util.pojo2yaml;

import org.reflections.Reflections;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import java.util.Set;

/**
 * Created by radu on 06.10.2016.
 */
public class ServiceWorker {
    private ServiceConfig config;
    private OutputHandler outputHandler;

    public ServiceWorker(ServiceConfig config, OutputHandler oHandler) {
        this.config = config;
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
        config.subPackages.stream().forEach( pkg -> {
            String pkgPath = String.format("%s.%s",config.inputPackage,pkg.name);
            System.out.println(String.format("-- processing %s",pkgPath));
            Reflections reflections = new Reflections(
                rootCBuilder.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(pkgPath)))
            );
            Set<Class<? extends Enum>> enums = reflections.getSubTypesOf(Enum.class);
            enums.stream().forEach( en -> {
                EnumWorker enumWorker = new EnumWorker(en,config.inputPackage,pkg);
                enumWorker.process(outputHandler);
            });

            Set<Class<? extends Object>> classes = reflections.getSubTypesOf(Object.class);
            classes.stream().forEach( cl -> {
                if( isWeirdCase(cl) ) {
                    throw new RuntimeException(String.format("skip UNKNOWN: %s ...",cl.getCanonicalName()));
                } else {
                    ClassWorker classWorker = new ClassWorker(cl,config.inputPackage,pkg);
                    classWorker.process(outputHandler);
                }
            });
            System.out.println("-- done");
        });
        outputHandler.close();
    }
}
