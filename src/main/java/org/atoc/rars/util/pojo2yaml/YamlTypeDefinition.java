package org.atoc.rars.util.pojo2yaml;

/**
 * Created by radu on 06.10.2016.
 */
public class YamlTypeDefinition {
    private String name;

    public YamlTypeDefinition(String name) {
        this.name = name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  %s:\n",name));
        return sb.toString();
    }
}
