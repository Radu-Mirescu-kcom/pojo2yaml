package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by radu on 07.10.2016.
 */
public class PackageConfig {
    String name;
    String alias;

    public PackageConfig(@JsonProperty("name") String name, @JsonProperty("alias") String alias) {
        this.name = name;
        this.alias = alias;
    }
}
