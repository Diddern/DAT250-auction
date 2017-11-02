
package client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for auction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="auction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="isActive" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="min_price" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="product_name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="unix_end_time" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "auction", propOrder = {
    "description",
    "id",
    "isActive",
    "minPrice",
    "productName",
    "unixEndTime"
})
public class Auction {

    protected String description;
    protected Long id;
    protected boolean isActive;
    @XmlElement(name = "min_price")
    protected Long minPrice;
    @XmlElement(name = "product_name")
    protected String productName;
    @XmlElement(name = "unix_end_time")
    protected Long unixEndTime;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setId(Long value) {
        this.id = value;
    }

    /**
     * Gets the value of the isActive property.
     * 
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Sets the value of the isActive property.
     * 
     */
    public void setIsActive(boolean value) {
        this.isActive = value;
    }

    /**
     * Gets the value of the minPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMinPrice() {
        return minPrice;
    }

    /**
     * Sets the value of the minPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMinPrice(Long value) {
        this.minPrice = value;
    }

    /**
     * Gets the value of the productName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Sets the value of the productName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductName(String value) {
        this.productName = value;
    }

    /**
     * Gets the value of the unixEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUnixEndTime() {
        return unixEndTime;
    }

    /**
     * Sets the value of the unixEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUnixEndTime(Long value) {
        this.unixEndTime = value;
    }

}
