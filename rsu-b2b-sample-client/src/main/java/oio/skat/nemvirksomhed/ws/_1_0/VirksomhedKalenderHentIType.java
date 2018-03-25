
package oio.skat.nemvirksomhed.ws._1_0;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for VirksomhedKalenderHent_IType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VirksomhedKalenderHent_IType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysninger"/&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/}VirksomhedSENummerIdentifikator"/&gt;
 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseTypeNavn"/&gt;
 *         &lt;element name="AngivelseBetalingFristHentFra"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}SoegeDatoFraDate" minOccurs="0"/&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}SoegeDatoTilDate" minOccurs="0"/&gt;
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
@XmlRootElement(name="VirksomhedKalenderHent_I")
@XmlType(name = "VirksomhedKalenderHent_IType", propOrder = {
    "hovedOplysninger",
    "virksomhedSENummerIdentifikator",
    "angivelseTypeNavn",
    "angivelseBetalingFristHentFra"
})
public class VirksomhedKalenderHentIType {

    @XmlElement(name = "HovedOplysninger", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerType hovedOplysninger;
    @XmlElement(name = "VirksomhedSENummerIdentifikator", namespace = "http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/", required = true)
    protected String virksomhedSENummerIdentifikator;
    @XmlElement(name = "AngivelseTypeNavn", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
    protected String angivelseTypeNavn;
    @XmlElement(name = "AngivelseBetalingFristHentFra", required = true)
    protected AngivelseBetalingFristHentFra angivelseBetalingFristHentFra;

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

    /**
     * Gets the value of the angivelseTypeNavn property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAngivelseTypeNavn() {
        return angivelseTypeNavn;
    }

    /**
     * Sets the value of the angivelseTypeNavn property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAngivelseTypeNavn(String value) {
        this.angivelseTypeNavn = value;
    }

    /**
     * Gets the value of the angivelseBetalingFristHentFra property.
     *
     * @return
     *     possible object is
     *     {@link AngivelseBetalingFristHentFra }
     *
     */
    public AngivelseBetalingFristHentFra getAngivelseBetalingFristHentFra() {
        return angivelseBetalingFristHentFra;
    }

    /**
     * Sets the value of the angivelseBetalingFristHentFra property.
     *
     * @param value
     *     allowed object is
     *     {@link AngivelseBetalingFristHentFra }
     *
     */
    public void setAngivelseBetalingFristHentFra(AngivelseBetalingFristHentFra value) {
        this.angivelseBetalingFristHentFra = value;
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
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}SoegeDatoFraDate" minOccurs="0"/&gt;
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}SoegeDatoTilDate" minOccurs="0"/&gt;
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
        "soegeDatoFraDate",
        "soegeDatoTilDate"
    })
    public static class AngivelseBetalingFristHentFra {

        @XmlElement(name = "SoegeDatoFraDate", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar soegeDatoFraDate;
        @XmlElement(name = "SoegeDatoTilDate", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar soegeDatoTilDate;

        /**
         * Gets the value of the soegeDatoFraDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSoegeDatoFraDate() {
            return soegeDatoFraDate;
        }

        /**
         * Sets the value of the soegeDatoFraDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSoegeDatoFraDate(XMLGregorianCalendar value) {
            this.soegeDatoFraDate = value;
        }

        /**
         * Gets the value of the soegeDatoTilDate property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getSoegeDatoTilDate() {
            return soegeDatoTilDate;
        }

        /**
         * Sets the value of the soegeDatoTilDate property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setSoegeDatoTilDate(XMLGregorianCalendar value) {
            this.soegeDatoTilDate = value;
        }

    }

}
