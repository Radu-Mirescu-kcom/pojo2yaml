package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by radu on 05.10.2016.
 */
public class PojoToYamlConfig {
    @Getter
    private String basePackage;
    @Getter
    private Map<String,ServiceConfig> servicesInfo = new HashMap<String,ServiceConfig>();

    public PojoToYamlConfig(@JsonProperty("services") Map<String,ServiceConfig> services,
                            @JsonProperty("basePackage") String basePackage) {
        this.servicesInfo = services;
        this.basePackage = basePackage;
    }

}
