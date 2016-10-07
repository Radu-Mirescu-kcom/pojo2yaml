package org.atoc.rars.util.pojo2yaml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by radu on 06.10.2016.
 */
public class YamlTypeDefinition {
    private String name;
    private List<YamlField> fields;
    private ClassWorker classWorker;

    public YamlTypeDefinition(String name, ClassWorker classWorker) {
        this.name = name;
        fields = new ArrayList<>();
        this.classWorker = classWorker;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("  %s:%n",name));
        List<YamlField> reqs = fields.stream().filter( f -> f.isRequired()).collect(Collectors.toList());
        if(!reqs.isEmpty()) {
            sb.append("    required:\n");
            for(YamlField req:reqs) {
                sb.append(String.format("      - %s%n",req.name()));
            }
        }
        if(!fields.isEmpty()) {
            sb.append("    properties:\n");
            fields.stream().forEach( f -> f.outputTo(sb));
        }
        sb.append(String.format("    type: object%n",name));
        return sb.toString();
    }

    public void addField(Field f) {
        XmlAttribute xmlAttribute = f.getAnnotation(XmlAttribute.class);
        if( xmlAttribute != null ) {
            fields.add(new YamlField(f,classWorker,xmlAttribute));
            return;
        }
        XmlElement xmlElement = f.getAnnotation(XmlElement.class);
        if(xmlElement != null) {
            fields.add(new YamlElementField(f,classWorker,xmlElement));
            return;
        }
        XmlElementRef xmlElementRef = f.getAnnotation(XmlElementRef.class);
        {
            if(xmlElementRef != null) {
                fields.add(new YamlElementField(f,classWorker,xmlElementRef));
                return;
            }
        }
        throw new RuntimeException(String.format("No XML annotation for the field %s",f));
    }
}
