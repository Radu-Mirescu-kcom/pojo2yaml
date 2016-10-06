package org.atoc.rars.util.pojo2yaml;

import javax.xml.bind.annotation.XmlAttribute;
import java.lang.reflect.Field;
import java.util.Optional;

/**
 * Created by radu on 06.10.2016.
 */
public class YamlField {
    private Field field;
    XmlAttribute xmlAttribute;

    public YamlField(Field field) {
        this.field = field;
    }

    public YamlField(Field field,XmlAttribute xmlAttr) {
        this.field = field;
        this.xmlAttribute = xmlAttr;
    }

    private Optional<String> simpleType() {
        if( field.getType() == String.class ) return Optional.of("string");
        if( field.isEnumConstant() ) return Optional.of("enum");
        return Optional.empty();
    }

    public void outputTo(StringBuilder sb) {
        sb.append(String.format("      %s:%n",name()));
        Optional<String> sType = simpleType();
        if( sType.isPresent() ) {
            sb.append(String.format("        type: %s%n",sType.get()));
        }
    }

    public boolean isRequired() {
        return xmlAttribute.required();
    }

    public String name() {
        return xmlAttribute.name();
    }
}
