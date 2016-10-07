//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.05 at 06:00:35 PM EEST 
//


package org.atoc.rars.retailsopi.generated.model.availability.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AR element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="AR"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{}H"/&gt;
 *           &lt;element ref="{}J" maxOccurs="unbounded" minOccurs="0"/&gt;
 *           &lt;element ref="{}E" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;/sequence&gt;
 *       &lt;/restriction&gt;
 *     &lt;/complexContent&gt;
 *   &lt;/complexType&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "header",
    "journey",
    "errorReport"
})
@XmlRootElement(name = "AR")
public class AvailabilityResponse {

    @XmlElement(name = "H", required = true)
    protected Header header;
    @XmlElement(name = "J")
    protected List<Journey> journey;
    @XmlElement(name = "E")
    protected List<ErrorReport> errorReport;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link Header }
     *     
     */
    public Header getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link Header }
     *     
     */
    public void setHeader(Header value) {
        this.header = value;
    }

    /**
     * Gets the value of the journey property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the journey property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getJourney().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Journey }
     * 
     * 
     */
    public List<Journey> getJourney() {
        if (journey == null) {
            journey = new ArrayList<Journey>();
        }
        return this.journey;
    }

    /**
     * Gets the value of the errorReport property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorReport property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorReport().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ErrorReport }
     * 
     * 
     */
    public List<ErrorReport> getErrorReport() {
        if (errorReport == null) {
            errorReport = new ArrayList<ErrorReport>();
        }
        return this.errorReport;
    }

}