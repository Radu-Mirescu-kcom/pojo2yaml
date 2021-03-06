//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.10.05 at 10:33:31 AM EEST 
//


package org.atoc.rars.stubs.generated.model.booking.response;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for B element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="B"&gt;
 *   &lt;complexType&gt;
 *     &lt;complexContent&gt;
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="{}J" maxOccurs="unbounded"/&gt;
 *         &lt;/sequence&gt;
 *         &lt;attribute name="b" use="required" type="{}bookingReferenceType" /&gt;
 *         &lt;attribute name="p" type="{}nameType" /&gt;
 *         &lt;attribute name="t" type="{}ticketNumberType" /&gt;
 *         &lt;attribute name="r" type="{}assistanceReferenceType" /&gt;
 *         &lt;attribute name="c" type="{}contactNumberType" /&gt;
 *         &lt;attribute name="g" type="{}longRemarksType" /&gt;
 *         &lt;attribute name="o" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" /&gt;
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
    "journey"
})
@XmlRootElement(name = "B")
public class Booking {

    @XmlElement(name = "J", required = true)
    protected List<Journey> journey;
    @XmlAttribute(name = "b", required = true)
    protected String referenceNumber;
    @XmlAttribute(name = "p")
    protected String passengerName;
    @XmlAttribute(name = "t")
    protected String ticketNumber;
    @XmlAttribute(name = "r")
    protected String assistanceReference;
    @XmlAttribute(name = "c")
    protected String contactNumber;
    @XmlAttribute(name = "g")
    protected String generalRemarks;
    @XmlAttribute(name = "o", required = true)
    protected boolean group;

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
     * Gets the value of the referenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the value of the referenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferenceNumber(String value) {
        this.referenceNumber = value;
    }

    /**
     * Gets the value of the passengerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassengerName() {
        return passengerName;
    }

    /**
     * Sets the value of the passengerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassengerName(String value) {
        this.passengerName = value;
    }

    /**
     * Gets the value of the ticketNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTicketNumber() {
        return ticketNumber;
    }

    /**
     * Sets the value of the ticketNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTicketNumber(String value) {
        this.ticketNumber = value;
    }

    /**
     * Gets the value of the assistanceReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAssistanceReference() {
        return assistanceReference;
    }

    /**
     * Sets the value of the assistanceReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAssistanceReference(String value) {
        this.assistanceReference = value;
    }

    /**
     * Gets the value of the contactNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * Sets the value of the contactNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContactNumber(String value) {
        this.contactNumber = value;
    }

    /**
     * Gets the value of the generalRemarks property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeneralRemarks() {
        return generalRemarks;
    }

    /**
     * Sets the value of the generalRemarks property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeneralRemarks(String value) {
        this.generalRemarks = value;
    }

    /**
     * Gets the value of the group property.
     * 
     */
    public boolean isGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     */
    public void setGroup(boolean value) {
        this.group = value;
    }

}
