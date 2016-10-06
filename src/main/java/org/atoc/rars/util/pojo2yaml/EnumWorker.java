package org.atoc.rars.util.pojo2yaml;

import java.util.Arrays;

/**
 * Created by radu on 06.10.2016.
 */
public class EnumWorker extends ClassWorker {
    public EnumWorker(Class<? extends Enum> innerEnum,String rootPackage) {
        super(innerEnum,rootPackage);
    }

    public void process() {
        System.out.println(String.format("processing ENUM: %s ...",clazz.getCanonicalName()));
        System.out.print(String.format("  %s:%n",
            camelize(clazz.getCanonicalName().substring(rootPackageLength)))
        );
        System.out.print("    enum:\n");
        Class<? extends Enum> enumClass = (Class<? extends Enum>) clazz;
        Arrays.stream(enumClass.getEnumConstants()).forEach( ec -> {
            System.out.print(String.format("      - %s%n", ec.name()));
        });

        System.out.println("done");
    }
}