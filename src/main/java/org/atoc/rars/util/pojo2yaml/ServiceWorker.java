package org.atoc.rars.util.pojo2yaml;

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
        System.out.println("-- done");
    }
}
