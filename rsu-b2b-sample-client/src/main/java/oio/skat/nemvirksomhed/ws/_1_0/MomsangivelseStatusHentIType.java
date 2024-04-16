
package oio.skat.nemvirksomhed.ws._1_0;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerType;
import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for MomsangivelseStatusHent_IType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MomsangivelseStatusHent_IType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysninger"/&gt;
 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}TransaktionIdentifier"/&gt;
 *         &lt;element name="Angiver"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/}VirksomhedSENummerIdentifikator"/&gt;
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
@XmlRootElement(name="MomsangivelseStatusHent_I")
@XmlType(name = "MomsangivelseStatusHent_I", propOrder = {
    "hovedOplysninger",
    "transaktionIdentifier",
    "angiver"
})
public class MomsangivelseStatusHentIType {

    @XmlElement(name = "HovedOplysninger", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerType hovedOplysninger;
    @XmlElement(name = "TransaktionIdentifier", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
    protected String transaktionIdentifier;
    @XmlElement(name = "Angiver", required = true)
    protected Angiver angiver;

    /**
     * Gets the value of the hovedOplysninger property.
     * 
     * @return
     *     possible object is
     *     {@link HovedOplysningerType }
     *     
     */
    public HovedOplysningerType getHovedOplysninger() {
        return hovedOplysninger;
    }

    /**
     * Sets the value of the hovedOplysninger property.
     * 
     * @param value
     *     allowed object is
     *     {@link HovedOplysningerType }
     *     
     */
    public void setHovedOplysninger(HovedOplysningerType value) {
        this.hovedOplysninger = value;
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
     * Gets the value of the angiver property.
     * 
     * @return
     *     possible object is
     *     {@link Angiver }
     *     
     */
    public Angiver getAngiver() {
        return angiver;
    }

    /**
     * Sets the value of the angiver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Angiver }
     *     
     */
    public void setAngiver(Angiver value) {
        this.angiver = value;
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
     *         &lt;element ref="{http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/}VirksomhedSENummerIdentifikator"/&gt;
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
        "virksomhedSENummerIdentifikator"
    })
    public static class Angiver {

        @XmlElement(name = "VirksomhedSENummerIdentifikator", namespace = "http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/", required = true)
        protected String virksomhedSENummerIdentifikator;

        /**
         * Gets the value of the virksomhedSENummerIdentifikator property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getVirksomhedSENummerIdentifikator() {
            return virksomhedSENummerIdentifikator;
        }

        /**
         * Sets the value of the virksomhedSENummerIdentifikator property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setVirksomhedSENummerIdentifikator(String value) {
            this.virksomhedSENummerIdentifikator = value;
        }

    }

}
