
package oio.skat.nemvirksomhed.ws._1_0;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerSvarType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for MomsangivelseKvitteringHent_OType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MomsangivelseKvitteringHent_OType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysningerSvar"/&gt;
 *         &lt;element name="PDFkvittering" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}DokumentFilIndholdData"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="Betalingsoplysninger" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:ws:1.0.0}OCRLinie"/&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}BetalingIkkeBetaltBeloeb"/&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato"/&gt;
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
@XmlRootElement(name="MomsangivelseKvitteringHent_O")
@XmlType(name = "MomsangivelseKvitteringHent_OType", propOrder = {
    "hovedOplysningerSvar",
    "pdFkvittering",
    "betalingsoplysninger"
})
public class MomsangivelseKvitteringHentOType {

    @XmlElement(name = "HovedOplysningerSvar", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerSvarType hovedOplysningerSvar;
    @XmlElement(name = "PDFkvittering")
    protected PDFkvittering pdFkvittering;
    @XmlElement(name = "Betalingsoplysninger")
    protected Betalingsoplysninger betalingsoplysninger;

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
     * Gets the value of the pdFkvittering property.
     *
     * @return
     *     possible object is
     *     {@link PDFkvittering }
     *
     */
    public PDFkvittering getPDFkvittering() {
        return pdFkvittering;
    }

    /**
     * Sets the value of the pdFkvittering property.
     *
     * @param value
     *     allowed object is
     *     {@link PDFkvittering }
     *
     */
    public void setPDFkvittering(PDFkvittering value) {
        this.pdFkvittering = value;
    }

    /**
     * Gets the value of the betalingsoplysninger property.
     *
     * @return
     *     possible object is
     *     {@link Betalingsoplysninger }
     *
     */
    public Betalingsoplysninger getBetalingsoplysninger() {
        return betalingsoplysninger;
    }

    /**
     * Sets the value of the betalingsoplysninger property.
     *
     * @param value
     *     allowed object is
     *     {@link Betalingsoplysninger }
     *
     */
    public void setBetalingsoplysninger(Betalingsoplysninger value) {
        this.betalingsoplysninger = value;
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
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:ws:1.0.0}OCRLinie"/&gt;
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}BetalingIkkeBetaltBeloeb"/&gt;
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato"/&gt;
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
        "ocrLinie",
        "betalingIkkeBetaltBeloeb",
        "angivelseFristKalenderBetalingDato"
    })
    public static class Betalingsoplysninger {

        @XmlElement(name = "OCRLinie", required = true)
        protected OCRLinieType ocrLinie;
        @XmlElement(name = "BetalingIkkeBetaltBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
        protected BigInteger betalingIkkeBetaltBeloeb;
        @XmlElement(name = "AngivelseFristKalenderBetalingDato", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar angivelseFristKalenderBetalingDato;

        /**
         * Gets the value of the ocrLinie property.
         * 
         * @return
         *     possible object is
         *     {@link OCRLinieType }
         *     
         */
        public OCRLinieType getOCRLinie() {
            return ocrLinie;
        }

        /**
         * Sets the value of the ocrLinie property.
         * 
         * @param value
         *     allowed object is
         *     {@link OCRLinieType }
         *     
         */
        public void setOCRLinie(OCRLinieType value) {
            this.ocrLinie = value;
        }

        /**
         * Gets the value of the betalingIkkeBetaltBeloeb property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getBetalingIkkeBetaltBeloeb() {
            return betalingIkkeBetaltBeloeb;
        }

        /**
         * Sets the value of the betalingIkkeBetaltBeloeb property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setBetalingIkkeBetaltBeloeb(BigInteger value) {
            this.betalingIkkeBetaltBeloeb = value;
        }

        /**
         * Gets the value of the angivelseFristKalenderBetalingDato property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getAngivelseFristKalenderBetalingDato() {
            return angivelseFristKalenderBetalingDato;
        }

        /**
         * Sets the value of the angivelseFristKalenderBetalingDato property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setAngivelseFristKalenderBetalingDato(XMLGregorianCalendar value) {
            this.angivelseFristKalenderBetalingDato = value;
        }

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
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}DokumentFilIndholdData"/&gt;
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
        "dokumentFilIndholdData"
    })
    public static class PDFkvittering {

        @XmlElement(name = "DokumentFilIndholdData", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
        protected byte[] dokumentFilIndholdData;

        /**
         * Gets the value of the dokumentFilIndholdData property.
         * 
         * @return
         *     possible object is
         *     byte[]
         */
        public byte[] getDokumentFilIndholdData() {
            return dokumentFilIndholdData;
        }

        /**
         * Sets the value of the dokumentFilIndholdData property.
         * 
         * @param value
         *     allowed object is
         *     byte[]
         */
        public void setDokumentFilIndholdData(byte[] value) {
            this.dokumentFilIndholdData = value;
        }

    }

}
