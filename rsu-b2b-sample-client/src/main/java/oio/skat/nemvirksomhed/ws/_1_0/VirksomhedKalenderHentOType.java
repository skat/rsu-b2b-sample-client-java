
package oio.skat.nemvirksomhed.ws._1_0;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerSvarType;


/**
 * <p>Java class for VirksomhedKalenderHent_OType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VirksomhedKalenderHent_OType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysningerSvar"/&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/}VirksomhedSENummerIdentifikator" minOccurs="0"/&gt;
 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}PligtKode" minOccurs="0"/&gt;
 *         &lt;element name="AngivelseFrekvensListe" minOccurs="0"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="AngivelseFrekvens" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensForholdGyldigFraDate"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensForholdGyldigTilDate" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensTypeCode"/&gt;
 *                             &lt;element name="AngivelseBetalingFristDatoListe"&gt;
 *                               &lt;complexType&gt;
 *                                 &lt;complexContent&gt;
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                     &lt;sequence&gt;
 *                                       &lt;element name="AngivelseBetalingFristDato" maxOccurs="unbounded" minOccurs="0"&gt;
 *                                         &lt;complexType&gt;
 *                                           &lt;complexContent&gt;
 *                                             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                                               &lt;sequence&gt;
 *                                                 &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderFristDato"/&gt;
 *                                                 &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderForfaldDato" minOccurs="0"/&gt;
 *                                                 &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato" minOccurs="0"/&gt;
 *                                               &lt;/sequence&gt;
 *                                             &lt;/restriction&gt;
 *                                           &lt;/complexContent&gt;
 *                                         &lt;/complexType&gt;
 *                                       &lt;/element&gt;
 *                                     &lt;/sequence&gt;
 *                                   &lt;/restriction&gt;
 *                                 &lt;/complexContent&gt;
 *                               &lt;/complexType&gt;
 *                             &lt;/element&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
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
@XmlRootElement(name="VirksomhedKalenderHent_O")
@XmlType(name = "VirksomhedKalenderHent_OType", propOrder = {
        "hovedOplysningerSvar",
        "virksomhedSENummerIdentifikator",
        "pligtKode",
        "angivelseFrekvensListe"
})
public class VirksomhedKalenderHentOType {

    @XmlElement(name = "HovedOplysningerSvar", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerSvarType hovedOplysningerSvar;
    @XmlElement(name = "VirksomhedSENummerIdentifikator", namespace = "http://rep.oio.dk/skat.dk/motor/class/virksomhed/xml/schemas/20080401/")
    protected String virksomhedSENummerIdentifikator;
    @XmlElement(name = "PligtKode", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
    protected BigInteger pligtKode;
    @XmlElement(name = "AngivelseFrekvensListe")
    protected VirksomhedKalenderHentOType.AngivelseFrekvensListe angivelseFrekvensListe;

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
     * Gets the value of the pligtKode property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPligtKode() {
        return pligtKode;
    }

    /**
     * Sets the value of the pligtKode property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPligtKode(BigInteger value) {
        this.pligtKode = value;
    }

    /**
     * Gets the value of the angivelseFrekvensListe property.
     *
     * @return
     *     possible object is
     *     {@link VirksomhedKalenderHentOType.AngivelseFrekvensListe }
     *
     */
    public VirksomhedKalenderHentOType.AngivelseFrekvensListe getAngivelseFrekvensListe() {
        return angivelseFrekvensListe;
    }

    /**
     * Sets the value of the angivelseFrekvensListe property.
     *
     * @param value
     *     allowed object is
     *     {@link VirksomhedKalenderHentOType.AngivelseFrekvensListe }
     *
     */
    public void setAngivelseFrekvensListe(VirksomhedKalenderHentOType.AngivelseFrekvensListe value) {
        this.angivelseFrekvensListe = value;
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
     *         &lt;element name="AngivelseFrekvens" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensForholdGyldigFraDate"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensForholdGyldigTilDate" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensTypeCode"/&gt;
     *                   &lt;element name="AngivelseBetalingFristDatoListe"&gt;
     *                     &lt;complexType&gt;
     *                       &lt;complexContent&gt;
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                           &lt;sequence&gt;
     *                             &lt;element name="AngivelseBetalingFristDato" maxOccurs="unbounded" minOccurs="0"&gt;
     *                               &lt;complexType&gt;
     *                                 &lt;complexContent&gt;
     *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                                     &lt;sequence&gt;
     *                                       &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderFristDato"/&gt;
     *                                       &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderForfaldDato" minOccurs="0"/&gt;
     *                                       &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato" minOccurs="0"/&gt;
     *                                     &lt;/sequence&gt;
     *                                   &lt;/restriction&gt;
     *                                 &lt;/complexContent&gt;
     *                               &lt;/complexType&gt;
     *                             &lt;/element&gt;
     *                           &lt;/sequence&gt;
     *                         &lt;/restriction&gt;
     *                       &lt;/complexContent&gt;
     *                     &lt;/complexType&gt;
     *                   &lt;/element&gt;
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
    @XmlType(name = "", propOrder = {
            "angivelseFrekvens"
    })
    public static class AngivelseFrekvensListe {

        @XmlElement(name = "AngivelseFrekvens")
        protected List<VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens> angivelseFrekvens;

        /**
         * Gets the value of the angivelseFrekvens property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the angivelseFrekvens property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getAngivelseFrekvens().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens }
         *
         *
         */
        public List<VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens> getAngivelseFrekvens() {
            if (angivelseFrekvens == null) {
                angivelseFrekvens = new ArrayList<VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens>();
            }
            return this.angivelseFrekvens;
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
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensForholdGyldigFraDate"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensForholdGyldigTilDate" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFrekvensTypeCode"/&gt;
         *         &lt;element name="AngivelseBetalingFristDatoListe"&gt;
         *           &lt;complexType&gt;
         *             &lt;complexContent&gt;
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                 &lt;sequence&gt;
         *                   &lt;element name="AngivelseBetalingFristDato" maxOccurs="unbounded" minOccurs="0"&gt;
         *                     &lt;complexType&gt;
         *                       &lt;complexContent&gt;
         *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *                           &lt;sequence&gt;
         *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderFristDato"/&gt;
         *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderForfaldDato" minOccurs="0"/&gt;
         *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato" minOccurs="0"/&gt;
         *                           &lt;/sequence&gt;
         *                         &lt;/restriction&gt;
         *                       &lt;/complexContent&gt;
         *                     &lt;/complexType&gt;
         *                   &lt;/element&gt;
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
        @XmlType(name = "", propOrder = {
                "angivelseFrekvensForholdGyldigFraDate",
                "angivelseFrekvensForholdGyldigTilDate",
                "angivelseFrekvensTypeCode",
                "angivelseBetalingFristDatoListe"
        })
        public static class AngivelseFrekvens {

            @XmlElement(name = "AngivelseFrekvensForholdGyldigFraDate", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar angivelseFrekvensForholdGyldigFraDate;
            @XmlElement(name = "AngivelseFrekvensForholdGyldigTilDate", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar angivelseFrekvensForholdGyldigTilDate;
            @XmlElement(name = "AngivelseFrekvensTypeCode", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
            protected BigInteger angivelseFrekvensTypeCode;
            @XmlElement(name = "AngivelseBetalingFristDatoListe", required = true)
            protected VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe angivelseBetalingFristDatoListe;

            /**
             * Gets the value of the angivelseFrekvensForholdGyldigFraDate property.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getAngivelseFrekvensForholdGyldigFraDate() {
                return angivelseFrekvensForholdGyldigFraDate;
            }

            /**
             * Sets the value of the angivelseFrekvensForholdGyldigFraDate property.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setAngivelseFrekvensForholdGyldigFraDate(XMLGregorianCalendar value) {
                this.angivelseFrekvensForholdGyldigFraDate = value;
            }

            /**
             * Gets the value of the angivelseFrekvensForholdGyldigTilDate property.
             *
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public XMLGregorianCalendar getAngivelseFrekvensForholdGyldigTilDate() {
                return angivelseFrekvensForholdGyldigTilDate;
            }

            /**
             * Sets the value of the angivelseFrekvensForholdGyldigTilDate property.
             *
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *
             */
            public void setAngivelseFrekvensForholdGyldigTilDate(XMLGregorianCalendar value) {
                this.angivelseFrekvensForholdGyldigTilDate = value;
            }

            /**
             * Gets the value of the angivelseFrekvensTypeCode property.
             *
             * @return
             *     possible object is
             *     {@link BigInteger }
             *
             */
            public BigInteger getAngivelseFrekvensTypeCode() {
                return angivelseFrekvensTypeCode;
            }

            /**
             * Sets the value of the angivelseFrekvensTypeCode property.
             *
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *
             */
            public void setAngivelseFrekvensTypeCode(BigInteger value) {
                this.angivelseFrekvensTypeCode = value;
            }

            /**
             * Gets the value of the angivelseBetalingFristDatoListe property.
             *
             * @return
             *     possible object is
             *     {@link VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe }
             *
             */
            public VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe getAngivelseBetalingFristDatoListe() {
                return angivelseBetalingFristDatoListe;
            }

            /**
             * Sets the value of the angivelseBetalingFristDatoListe property.
             *
             * @param value
             *     allowed object is
             *     {@link VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe }
             *
             */
            public void setAngivelseBetalingFristDatoListe(VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe value) {
                this.angivelseBetalingFristDatoListe = value;
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
             *         &lt;element name="AngivelseBetalingFristDato" maxOccurs="unbounded" minOccurs="0"&gt;
             *           &lt;complexType&gt;
             *             &lt;complexContent&gt;
             *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
             *                 &lt;sequence&gt;
             *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderFristDato"/&gt;
             *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderForfaldDato" minOccurs="0"/&gt;
             *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato" minOccurs="0"/&gt;
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
            @XmlType(name = "", propOrder = {
                    "angivelseBetalingFristDato"
            })
            public static class AngivelseBetalingFristDatoListe {

                @XmlElement(name = "AngivelseBetalingFristDato")
                protected List<VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe.AngivelseBetalingFristDato> angivelseBetalingFristDato;

                /**
                 * Gets the value of the angivelseBetalingFristDato property.
                 *
                 * <p>
                 * This accessor method returns a reference to the live list,
                 * not a snapshot. Therefore any modification you make to the
                 * returned list will be present inside the JAXB object.
                 * This is why there is not a <CODE>set</CODE> method for the angivelseBetalingFristDato property.
                 *
                 * <p>
                 * For example, to add a new item, do as follows:
                 * <pre>
                 *    getAngivelseBetalingFristDato().add(newItem);
                 * </pre>
                 *
                 *
                 * <p>
                 * Objects of the following type(s) are allowed in the list
                 * {@link VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe.AngivelseBetalingFristDato }
                 *
                 *
                 */
                public List<VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe.AngivelseBetalingFristDato> getAngivelseBetalingFristDato() {
                    if (angivelseBetalingFristDato == null) {
                        angivelseBetalingFristDato = new ArrayList<VirksomhedKalenderHentOType.AngivelseFrekvensListe.AngivelseFrekvens.AngivelseBetalingFristDatoListe.AngivelseBetalingFristDato>();
                    }
                    return this.angivelseBetalingFristDato;
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
                 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderFristDato"/&gt;
                 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderForfaldDato" minOccurs="0"/&gt;
                 *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelseFristKalenderBetalingDato" minOccurs="0"/&gt;
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
                        "angivelseFristKalenderFristDato",
                        "angivelseFristKalenderForfaldDato",
                        "angivelseFristKalenderBetalingDato"
                })
                public static class AngivelseBetalingFristDato {

                    @XmlElement(name = "AngivelseFristKalenderFristDato", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar angivelseFristKalenderFristDato;
                    @XmlElement(name = "AngivelseFristKalenderForfaldDato", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar angivelseFristKalenderForfaldDato;
                    @XmlElement(name = "AngivelseFristKalenderBetalingDato", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
                    @XmlSchemaType(name = "date")
                    protected XMLGregorianCalendar angivelseFristKalenderBetalingDato;

                    /**
                     * Gets the value of the angivelseFristKalenderFristDato property.
                     *
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *
                     */
                    public XMLGregorianCalendar getAngivelseFristKalenderFristDato() {
                        return angivelseFristKalenderFristDato;
                    }

                    /**
                     * Sets the value of the angivelseFristKalenderFristDato property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *
                     */
                    public void setAngivelseFristKalenderFristDato(XMLGregorianCalendar value) {
                        this.angivelseFristKalenderFristDato = value;
                    }

                    /**
                     * Gets the value of the angivelseFristKalenderForfaldDato property.
                     *
                     * @return
                     *     possible object is
                     *     {@link XMLGregorianCalendar }
                     *
                     */
                    public XMLGregorianCalendar getAngivelseFristKalenderForfaldDato() {
                        return angivelseFristKalenderForfaldDato;
                    }

                    /**
                     * Sets the value of the angivelseFristKalenderForfaldDato property.
                     *
                     * @param value
                     *     allowed object is
                     *     {@link XMLGregorianCalendar }
                     *
                     */
                    public void setAngivelseFristKalenderForfaldDato(XMLGregorianCalendar value) {
                        this.angivelseFristKalenderForfaldDato = value;
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

            }

        }

    }

}
