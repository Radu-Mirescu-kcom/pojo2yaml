package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

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
    private List<String> subPackages;

    public ServiceConfig(@JsonProperty("authorizationArea") String outputYaml,
                         @JsonProperty("entityPrefix") String ep,
                         @JsonProperty("package") String inputPackage,
                         @JsonProperty("subpackages") List<String> subPackages) {
        this.outputYaml = outputYaml;
        this.entityPrefix = ep;
        this.inputPackage = inputPackage;
        this.subPackages = subPackages;
    }

    public ServiceWorker buildWorker(String bp) {
        List<String> fullQualifiedPackages = subPackages.stream().map(
            sp -> String.format("%s.%s.%s",bp,inputPackage,sp)
        ).collect(Collectors.toList());
        return new ServiceWorker(fullQualifiedPackages,bp);
    }
}
