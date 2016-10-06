package org.atoc.rars.util.pojo2yaml;

import javax.xml.bind.annotation.XmlElement;
import java.lang.reflect.Field;

/**
 * Created by radu on 06.10.2016.
 */
public class YamlElementField extends YamlField {
    XmlElement xmlElement;

    public YamlElementField(Field field,ClassWorker classWorker,XmlElement xElem) {
        super(field,classWorker);
        xmlElement = xElem;
    }

    @Override
    public boolean isRequired() {
        return xmlElement.required();
    }

    @Override
    public String name() {
        return xmlElement.name();
    }
}
