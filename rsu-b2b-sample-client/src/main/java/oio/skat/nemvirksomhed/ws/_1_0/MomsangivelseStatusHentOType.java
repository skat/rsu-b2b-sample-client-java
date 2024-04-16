
package oio.skat.nemvirksomhed.ws._1_0;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerSvarType;
import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;


/**
 * <p>Java class for MomsangivelseStatusHent_OType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MomsangivelseStatusHent_OType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysningerSvar"/&gt;
 *         &lt;element name="Momsangivelsesstatus" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseStatusTekst"/&gt;
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
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseAfgiftTilsvarRestBeloeb"/&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato"/&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
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
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="MomsangivelseStatusHent_O")
@XmlType(name = "MomsangivelseStatusHent_O", propOrder = {
    "hovedOplysningerSvar",
    "momsangivelsesstatus",
    "betalingsoplysninger",
    "pdFkvittering"
})
public class MomsangivelseStatusHentOType {

    @XmlElement(name = "HovedOplysningerSvar", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerSvarType hovedOplysningerSvar;
    @XmlElement(name = "Momsangivelsesstatus")
    protected Momsangivelsesstatus momsangivelsesstatus;
    @XmlElement(name = "Betalingsoplysninger")
    protected Betalingsoplysninger betalingsoplysninger;
    @XmlElement(name = "PDFkvittering")
    protected PDFkvittering pdFkvittering;

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
     * Gets the value of the momsangivelsesstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Momsangivelsesstatus }
     *     
     */
    public Momsangivelsesstatus getMomsangivelsesstatus() {
        return momsangivelsesstatus;
    }

    /**
     * Sets the value of the momsangivelsesstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Momsangivelsesstatus }
     *     
     */
    public void setMomsangivelsesstatus(Momsangivelsesstatus value) {
        this.momsangivelsesstatus = value;
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
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseAfgiftTilsvarRestBeloeb"/&gt;
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
        "momsAngivelseAfgiftTilsvarRestBeloeb",
        "angivelseFristKalenderBetalingDato"
    })
    public static class Betalingsoplysninger {

        @XmlElement(name = "OCRLinie", required = true)
        protected OCRLinieType ocrLinie;
        @XmlElement(name = "MomsAngivelseAfgiftTilsvarRestBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
        protected BigInteger momsAngivelseAfgiftTilsvarRestBeloeb;
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
         * Gets the value of the momsAngivelseAfgiftTilsvarRestBeloeb property.
         * 
         * @return
         *     possible object is
         *     {@link BigInteger }
         *     
         */
        public BigInteger getMomsAngivelseAfgiftTilsvarRestBeloeb() {
            return momsAngivelseAfgiftTilsvarRestBeloeb;
        }

        /**
         * Sets the value of the momsAngivelseAfgiftTilsvarRestBeloeb property.
         * 
         * @param value
         *     allowed object is
         *     {@link BigInteger }
         *     
         */
        public void setMomsAngivelseAfgiftTilsvarRestBeloeb(BigInteger value) {
            this.momsAngivelseAfgiftTilsvarRestBeloeb = value;
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
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseStatusTekst"/&gt;
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
        "angivelseStatusTekst"
    })
    public static class Momsangivelsesstatus {

        @XmlElement(name = "AngivelseStatusTekst", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
        protected String angivelseStatusTekst;

        /**
         * Gets the value of the angivelseStatusTekst property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAngivelseStatusTekst() {
            return angivelseStatusTekst;
        }

        /**
         * Sets the value of the angivelseStatusTekst property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAngivelseStatusTekst(String value) {
            this.angivelseStatusTekst = value;
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
