package org.atoc.rars.util.pojo2yaml;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;

import static java.lang.System.exit;

/**
 * Created by radu on 05.10.2016.
 */
public class PojoToYaml {
    public static void main(String argv[]) throws IOException {
        PojoToYaml driver = new PojoToYaml();
        PojoToYamlConfig globalConfig = driver.initConfiguration();

        String serviceName;
        if( argv.length == 0 ) {
            System.out.println("Expected <serviceName>!");
            exit(1);
        }
        serviceName = argv[0];

        if( !globalConfig.getServicesInfo().containsKey( serviceName )) {
            System.out.println(String.format("No configured service '%s'!",serviceName));
            exit(1);
        }

        System.out.println("-- ready to process!");
        globalConfig.process(serviceName);
        System.out.println("-- eoj");
    }

    private Optional<Path> getMockAccessRightsPath() {
        try {
            Optional<URL> resourceUrl = Optional.ofNullable(this.getClass().getResource("/pojo2yaml-spec.json"));
            if (resourceUrl.isPresent()) {
                return Optional.ofNullable(Paths.get(resourceUrl.get().toURI()));
            } else {
                throw new RuntimeException("Unable to load config");
            }
        } catch (URISyntaxException use) {
            throw new RuntimeException("Unable to load config");
        }
    }

    public PojoToYamlConfig initConfiguration() {
        Optional<Path> resourcePath = getMockAccessRightsPath();
        try (Stream<String> stream = Files.lines(resourcePath.get())) {
            StringBuilder sb = new StringBuilder();
            stream.forEach(l -> sb.append(l));
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(sb.toString(),
                new TypeReference<PojoToYamlConfig>() {
                }
            );
        } catch (IOException e) {
            throw new RuntimeException("Unable to load config");
        }
    }
}
