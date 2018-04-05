
package oio.skat.nemvirksomhed.ws._1_0;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerSvarType;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for ModtagMomsangivelseForeloebig_OType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModtagMomsangivelseForeloebig_OType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysningerSvar"/&gt;
 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}TransaktionIdentifier" minOccurs="0"/&gt;
 *         &lt;element name="Dybtlink" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}UrlIndicator"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="ModtagMomsangivelseForeloebig_O")
@XmlType(name = "ModtagMomsangivelseForeloebig_OType", propOrder = {
    "hovedOplysningerSvar",
    "transaktionIdentifier",
    "dybtlink"
})
public class ModtagMomsangivelseForeloebigOType {

    @XmlElement(name = "HovedOplysningerSvar", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerSvarType hovedOplysningerSvar;
    @XmlElement(name = "TransaktionIdentifier", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
    protected String transaktionIdentifier;
    @XmlElement(name = "Dybtlink")
    protected Dybtlink dybtlink;

    /**
     * Gets the value of the hovedOplysningerSvar property.
     *
     * @return
     *     possible object is
     *     {@link HovedOplysningerSvarType }
     *
     */
    public HovedOplysningerSvarType getHovedOplysningerSvar() {
        return hovedOplysningerSvar;
    }

    /**
     * Sets the value of the hovedOplysningerSvar property.
     *
     * @param value
     *     allowed object is
     *     {@link HovedOplysningerSvarType }
     *
     */
    public void setHovedOplysningerSvar(HovedOplysningerSvarType value) {
        this.hovedOplysningerSvar = value;
    }

    /**
     * Gets the value of the transaktionIdentifier property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTransaktionIdentifier() {
        return transaktionIdentifier;
    }

    /**
     * Sets the value of the transaktionIdentifier property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTransaktionIdentifier(String value) {
        this.transaktionIdentifier = value;
    }

    /**
     * Gets the value of the dybtlink property.
     *
     * @return
     *     possible object is
     *     {@link Dybtlink }
     *
     */
    public Dybtlink getDybtlink() {
        return dybtlink;
    }

    /**
     * Sets the value of the dybtlink property.
     *
     * @param value
     *     allowed object is
     *     {@link Dybtlink }
     *
     */
    public void setDybtlink(Dybtlink value) {
        this.dybtlink = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}UrlIndicator"/&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "urlIndicator"
    })
    public static class Dybtlink {

        @XmlElement(name = "UrlIndicator", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
        protected String urlIndicator;

        /**
         * Gets the value of the urlIndicator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getUrlIndicator() {
            return urlIndicator;
        }

        /**
         * Sets the value of the urlIndicator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setUrlIndicator(String value) {
            this.urlIndicator = value;
        }

    }

}
