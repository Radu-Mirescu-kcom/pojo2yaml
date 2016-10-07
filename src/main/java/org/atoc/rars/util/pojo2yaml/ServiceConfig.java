package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by radu on 05.10.2016.
 */
public class ServiceConfig {
    @Getter
    private String outputYaml;
    String inputPackage;
    List<PackageConfig> subPackages;

    public ServiceConfig(@JsonProperty("authorizationArea") String outputYaml,
                         @JsonProperty("package") String inputPackage,
                         @JsonProperty("subpackages") List<PackageConfig> subPackages) {
        this.outputYaml = outputYaml;
        this.inputPackage = inputPackage;
        this.subPackages = subPackages;
    }

    public ServiceWorker buildWorker() throws IOException {
        FileOutputHandler fileOutputHandler = new FileOutputHandler(outputYaml);
        return new ServiceWorker(this,fileOutputHandler);
    }
}
