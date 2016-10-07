package org.atoc.rars.util.pojo2yaml;

import java.util.Arrays;

/**
 * Created by radu on 06.10.2016.
 */
public class EnumWorker extends ClassWorker {
    public EnumWorker(Class<? extends Enum> innerEnum,String rootPackage,PackageConfig pkg) {
        super(innerEnum,rootPackage,pkg);
    }

    public void process(OutputHandler outputHandler) {
        System.out.println(String.format("processing ENUM: %s ...",clazz.getCanonicalName()));
        outputHandler.out(
            String.format("  %s%s:%n", clazz.getSimpleName(), pkgConfig.alias )
        );
        outputHandler.out("    type: string\n");
        outputHandler.out("    enum:\n");
        Class<? extends Enum> enumClass = (Class<? extends Enum>) clazz;
        Arrays.stream(enumClass.getEnumConstants()).forEach( ec -> {
            outputHandler.out(String.format("      - %s%n", ec.name()));
        });

        System.out.println("done");
    }
}