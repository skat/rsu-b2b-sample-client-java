
package oio.skat.nemvirksomhed.ws._1_0;

import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerSvarType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element name="AngivelseBetalingFristDatoListe" minOccurs="0"&gt;
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
@XmlRootElement(name="VirksomhedKalenderHent_O")
@XmlType(name = "VirksomhedKalenderHent_OType", propOrder = {
    "hovedOplysningerSvar",
    "angivelseBetalingFristDatoListe"
})
public class VirksomhedKalenderHentOType {

    @XmlElement(name = "HovedOplysningerSvar", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerSvarType hovedOplysningerSvar;
    @XmlElement(name = "AngivelseBetalingFristDatoListe")
    protected AngivelseBetalingFristDatoListe angivelseBetalingFristDatoListe;

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
     * Gets the value of the angivelseBetalingFristDatoListe property.
     *
     * @return
     *     possible object is
     *     {@link AngivelseBetalingFristDatoListe }
     *
     */
    public AngivelseBetalingFristDatoListe getAngivelseBetalingFristDatoListe() {
        return angivelseBetalingFristDatoListe;
    }

    /**
     * Sets the value of the angivelseBetalingFristDatoListe property.
     *
     * @param value
     *     allowed object is
     *     {@link AngivelseBetalingFristDatoListe }
     *
     */
    public void setAngivelseBetalingFristDatoListe(AngivelseBetalingFristDatoListe value) {
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
        protected List<AngivelseBetalingFristDato> angivelseBetalingFristDato;

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
         * {@link AngivelseBetalingFristDato }
         *
         *
         */
        public List<AngivelseBetalingFristDato> getAngivelseBetalingFristDato() {
            if (angivelseBetalingFristDato == null) {
                angivelseBetalingFristDato = new ArrayList<AngivelseBetalingFristDato>();
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
