package org.atoc.rars.util.pojo2yaml;

import javax.xml.bind.annotation.XmlAttribute;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;

/**
 * Created by radu on 06.10.2016.
 */
public class YamlField {
    protected Field field;
    XmlAttribute xmlAttribute;
    ClassWorker classWorker;

    public YamlField(Field field,ClassWorker classWorker) {
        this.field = field;
        this.classWorker = classWorker;
    }

    public YamlField(Field field,ClassWorker classWorker,XmlAttribute xmlAttr) {
        this(field,classWorker);
        this.xmlAttribute = xmlAttr;
    }

    private boolean isList() {
        Type type = field.getGenericType();
        return type != null && type.getTypeName().startsWith("java.util.List");
    }

    private Optional<String> simpleType(Class<?> clazz) {
        if( clazz == String.class ) {
            return Optional.of("string");
        }
        if( clazz.getName().equals("boolean")) {
            return Optional.of("boolean");
        }
        if( clazz == Boolean.class ) {
            return Optional.of("boolean");
        }
        if( clazz.getCanonicalName().endsWith(".BigDecimal")) {
            return Optional.of("number");
        }
        if( clazz.getCanonicalName().endsWith(".BigInteger")) {
            return Optional.of("number");
        }
        if( field.isEnumConstant() ) {
            return Optional.of("enum");
        }
        return Optional.empty();
    }

    private Optional<String> refType(Class<?> clazz) {
        String fieldCName = clazz.getCanonicalName();
        if( fieldCName.startsWith(classWorker.rootPackage)) {
            return Optional.of(
                String.format("%s%s",classWorker.pkgConfig.alias,clazz.getSimpleName())
            );
        }
        return Optional.empty();
    }

    void outputDirectType(StringBuilder sb,String prefix,Class<?> clazz) {
        Optional<String> sType = simpleType(clazz);
        if( sType.isPresent() ) {
            sb.append(String.format("%stype: %s%n",prefix,sType.get()));
        } else {
            Optional<String> ref = refType(clazz);
            if( ref.isPresent() ) {
                //sb.append(String.format("%stype:%n",prefix));
                sb.append(String.format("%s$ref: \"#/definitions/%s\"%n",prefix,ref.get()));
            } else {
                throw new RuntimeException(String.format("Unable to solve type for: %s",field));
            }
        }
    }

    void outputTo(StringBuilder sb) {
        sb.append(String.format("      %s:%n",name()));

        if( isList() ) {
            sb.append(String.format("        type: array%n"));
            sb.append(String.format("        items:%n"));
            ParameterizedType pType = (ParameterizedType) field.getGenericType();
            outputDirectType(sb, "          ",(Class<?>) pType.getActualTypeArguments()[0]);
        } else {
            outputDirectType(sb, "        ", field.getType());
        }
    }

    public boolean isRequired() {
        return xmlAttribute.required();
    }

    public String name() {
        String toReturn = field.getName();
        if( toReturn.equals("no")) {
            toReturn = "'no'";
        }
        return toReturn;
    }
}
