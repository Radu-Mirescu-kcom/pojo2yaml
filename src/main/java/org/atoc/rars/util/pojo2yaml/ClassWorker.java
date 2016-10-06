package org.atoc.rars.util.pojo2yaml;

/**
 * Created by radu on 06.10.2016.
 */
public class ClassWorker {
    private Class<? extends Object> clazz;

    public ClassWorker(Class<? extends Object> clazz) {
        this.clazz = clazz;
    }

    public void process() {
        System.out.println(String.format("processing CLASS: %s ...",clazz.getCanonicalName()));
        System.out.println("done");
    }
}
