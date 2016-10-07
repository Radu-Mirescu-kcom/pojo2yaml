package org.atoc.rars.util.pojo2yaml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import java.lang.reflect.Field;
import java.util.Optional;

/**
 * Created by radu on 06.10.2016.
 */
public class YamlElementField extends YamlField {
    Optional<XmlElement> xmlElement = Optional.empty();
    Optional<XmlElementRef> xmlElementRef = Optional.empty();

    public YamlElementField(Field field,ClassWorker classWorker,XmlElement xElem) {
        super(field,classWorker);
        xmlElement = Optional.of(xElem);
    }

    public YamlElementField(Field field,ClassWorker classWorker,XmlElementRef xElemRef) {
        super(field,classWorker);
        xmlElementRef = Optional.of(xElemRef);
    }

    @Override
    public boolean isRequired() {
        if( xmlElement.isPresent()) {
            return xmlElement.get().required();
        }
        return xmlElementRef.get().required();
    }
}
