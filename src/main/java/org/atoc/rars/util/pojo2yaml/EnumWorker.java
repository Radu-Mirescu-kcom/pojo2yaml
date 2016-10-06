package org.atoc.rars.util.pojo2yaml;

import java.util.Arrays;

/**
 * Created by radu on 06.10.2016.
 */
public class EnumWorker extends ClassWorker {
    public EnumWorker(Class<? extends Enum> innerEnum,String rootPackage) {
        super(innerEnum,rootPackage);
    }

    public void process(OutputHandler outputHandler) {
        System.out.println(String.format("processing ENUM: %s ...",clazz.getCanonicalName()));
        outputHandler.out(String.format("  %s:%n",
            camelize(clazz.getCanonicalName().substring(rootPackageLength)))
        );
        outputHandler.out("    enum:\n");
        Class<? extends Enum> enumClass = (Class<? extends Enum>) clazz;
        Arrays.stream(enumClass.getEnumConstants()).forEach( ec -> {
            outputHandler.out(String.format("      - %s%n", ec.name()));
        });

        System.out.println("done");
    }
}