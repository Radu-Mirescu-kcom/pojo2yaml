package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

/**
 * Created by radu on 05.10.2016.
 */
public class ServiceConfig {
    @Getter
    private String outputYaml;
    @Getter
    private String inputPackage;
    @Getter
    private String entityPrefix;

    public ServiceConfig(@JsonProperty("authorizationArea") String outputYaml,
                         @JsonProperty("entityPrefix") String ep,
                         @JsonProperty("package") String inputPackage) {
        this.outputYaml = outputYaml;
        this.entityPrefix = ep;
        this.inputPackage = inputPackage;
    }

    public ServiceWorker buildWorker(String bp) {
        return new ServiceWorker(String.format("%s.%s",bp,inputPackage));
    }
}
