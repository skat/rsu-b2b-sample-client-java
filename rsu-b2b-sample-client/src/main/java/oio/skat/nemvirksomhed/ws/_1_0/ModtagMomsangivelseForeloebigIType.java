
package oio.skat.nemvirksomhed.ws._1_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import dk.oio.rep.skat_dk.basis.kontekst.xml.schemas._2006._09._01.HovedOplysningerType;


/**
 * <p>Java class for ModtagMomsangivelseForeloebig_IType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ModtagMomsangivelseForeloebig_IType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/}HovedOplysninger"/&gt;
 *         &lt;element name="Angivelse"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:ws:1.0.0}AngiverVirksomhedSENummer"/&gt;
 *                   &lt;element name="Angivelsesoplysninger"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelsePeriodeFraDato"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelsePeriodeTilDato"/&gt;
 *                           &lt;/sequence&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                   &lt;element name="Angivelsesafgifter"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseAfgiftTilsvarBeloeb"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseCO2AfgiftBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUKoebBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUSalgBeloebVarerBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseIkkeEUSalgBeloebVarerBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseElAfgiftBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEksportOmsaetningBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseGasAfgiftBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseKoebsMomsBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseKulAfgiftBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseMomsEUKoebBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseMomsEUYdelserBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseOlieAfgiftBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseSalgsMomsBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseVandAfgiftBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUKoebYdelseBeloeb" minOccurs="0"/&gt;
 *                             &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUSalgYdelseBeloeb" minOccurs="0"/&gt;
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
@XmlRootElement(name="ModtagMomsangivelseForeloebig_I")
@XmlType(name = "ModtagMomsangivelseForeloebig_IType", propOrder = {
    "hovedOplysninger",
    "angivelse"
})
public class ModtagMomsangivelseForeloebigIType {

    @XmlElement(name = "HovedOplysninger", namespace = "http://rep.oio.dk/skat.dk/basis/kontekst/xml/schemas/2006/09/01/", required = true)
    protected HovedOplysningerType hovedOplysninger;
    @XmlElement(name = "Angivelse", required = true)
    protected ModtagMomsangivelseForeloebigIType.Angivelse angivelse;

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
     * Gets the value of the angivelse property.
     * 
     * @return
     *     possible object is
     *     {@link ModtagMomsangivelseForeloebigIType.Angivelse }
     *     
     */
    public ModtagMomsangivelseForeloebigIType.Angivelse getAngivelse() {
        return angivelse;
    }

    /**
     * Sets the value of the angivelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModtagMomsangivelseForeloebigIType.Angivelse }
     *     
     */
    public void setAngivelse(ModtagMomsangivelseForeloebigIType.Angivelse value) {
        this.angivelse = value;
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
     *         &lt;element ref="{urn:oio:skat:nemvirksomhed:ws:1.0.0}AngiverVirksomhedSENummer"/&gt;
     *         &lt;element name="Angivelsesoplysninger"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelsePeriodeFraDato"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelsePeriodeTilDato"/&gt;
     *                 &lt;/sequence&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *         &lt;element name="Angivelsesafgifter"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseAfgiftTilsvarBeloeb"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseCO2AfgiftBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUKoebBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUSalgBeloebVarerBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseIkkeEUSalgBeloebVarerBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseElAfgiftBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEksportOmsaetningBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseGasAfgiftBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseKoebsMomsBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseKulAfgiftBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseMomsEUKoebBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseMomsEUYdelserBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseOlieAfgiftBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseSalgsMomsBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseVandAfgiftBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUKoebYdelseBeloeb" minOccurs="0"/&gt;
     *                   &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUSalgYdelseBeloeb" minOccurs="0"/&gt;
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
        "angiverVirksomhedSENummer",
        "angivelsesoplysninger",
        "angivelsesafgifter"
    })
    public static class Angivelse {

        @XmlElement(name = "AngiverVirksomhedSENummer", required = true)
        protected AngiverVirksomhedSENummerType angiverVirksomhedSENummer;
        @XmlElement(name = "Angivelsesoplysninger", required = true)
        protected ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesoplysninger angivelsesoplysninger;
        @XmlElement(name = "Angivelsesafgifter", required = true)
        protected ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesafgifter angivelsesafgifter;

        /**
         * Gets the value of the angiverVirksomhedSENummer property.
         * 
         * @return
         *     possible object is
         *     {@link AngiverVirksomhedSENummerType }
         *     
         */
        public AngiverVirksomhedSENummerType getAngiverVirksomhedSENummer() {
            return angiverVirksomhedSENummer;
        }

        /**
         * Sets the value of the angiverVirksomhedSENummer property.
         * 
         * @param value
         *     allowed object is
         *     {@link AngiverVirksomhedSENummerType }
         *     
         */
        public void setAngiverVirksomhedSENummer(AngiverVirksomhedSENummerType value) {
            this.angiverVirksomhedSENummer = value;
        }

        /**
         * Gets the value of the angivelsesoplysninger property.
         * 
         * @return
         *     possible object is
         *     {@link ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesoplysninger }
         *     
         */
        public ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesoplysninger getAngivelsesoplysninger() {
            return angivelsesoplysninger;
        }

        /**
         * Sets the value of the angivelsesoplysninger property.
         * 
         * @param value
         *     allowed object is
         *     {@link ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesoplysninger }
         *     
         */
        public void setAngivelsesoplysninger(ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesoplysninger value) {
            this.angivelsesoplysninger = value;
        }

        /**
         * Gets the value of the angivelsesafgifter property.
         * 
         * @return
         *     possible object is
         *     {@link ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesafgifter }
         *     
         */
        public ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesafgifter getAngivelsesafgifter() {
            return angivelsesafgifter;
        }

        /**
         * Sets the value of the angivelsesafgifter property.
         * 
         * @param value
         *     allowed object is
         *     {@link ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesafgifter }
         *     
         */
        public void setAngivelsesafgifter(ModtagMomsangivelseForeloebigIType.Angivelse.Angivelsesafgifter value) {
            this.angivelsesafgifter = value;
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
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseAfgiftTilsvarBeloeb"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseCO2AfgiftBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUKoebBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUSalgBeloebVarerBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseIkkeEUSalgBeloebVarerBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseElAfgiftBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEksportOmsaetningBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseGasAfgiftBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseKoebsMomsBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseKulAfgiftBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseMomsEUKoebBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseMomsEUYdelserBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseOlieAfgiftBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseSalgsMomsBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseVandAfgiftBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUKoebYdelseBeloeb" minOccurs="0"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}MomsAngivelseEUSalgYdelseBeloeb" minOccurs="0"/&gt;
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
            "momsAngivelseAfgiftTilsvarBeloeb",
            "momsAngivelseCO2AfgiftBeloeb",
            "momsAngivelseEUKoebBeloeb",
            "momsAngivelseEUSalgBeloebVarerBeloeb",
            "momsAngivelseIkkeEUSalgBeloebVarerBeloeb",
            "momsAngivelseElAfgiftBeloeb",
            "momsAngivelseEksportOmsaetningBeloeb",
            "momsAngivelseGasAfgiftBeloeb",
            "momsAngivelseKoebsMomsBeloeb",
            "momsAngivelseKulAfgiftBeloeb",
            "momsAngivelseMomsEUKoebBeloeb",
            "momsAngivelseMomsEUYdelserBeloeb",
            "momsAngivelseOlieAfgiftBeloeb",
            "momsAngivelseSalgsMomsBeloeb",
            "momsAngivelseVandAfgiftBeloeb",
            "momsAngivelseEUKoebYdelseBeloeb",
            "momsAngivelseEUSalgYdelseBeloeb"
        })
        public static class Angivelsesafgifter {

            @XmlElement(name = "MomsAngivelseAfgiftTilsvarBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
            protected BigInteger momsAngivelseAfgiftTilsvarBeloeb;
            @XmlElement(name = "MomsAngivelseCO2AfgiftBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseCO2AfgiftBeloeb;
            @XmlElement(name = "MomsAngivelseEUKoebBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseEUKoebBeloeb;
            @XmlElement(name = "MomsAngivelseEUSalgBeloebVarerBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseEUSalgBeloebVarerBeloeb;
            @XmlElement(name = "MomsAngivelseIkkeEUSalgBeloebVarerBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseIkkeEUSalgBeloebVarerBeloeb;
            @XmlElement(name = "MomsAngivelseElAfgiftBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseElAfgiftBeloeb;
            @XmlElement(name = "MomsAngivelseEksportOmsaetningBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseEksportOmsaetningBeloeb;
            @XmlElement(name = "MomsAngivelseGasAfgiftBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseGasAfgiftBeloeb;
            @XmlElement(name = "MomsAngivelseKoebsMomsBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseKoebsMomsBeloeb;
            @XmlElement(name = "MomsAngivelseKulAfgiftBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseKulAfgiftBeloeb;
            @XmlElement(name = "MomsAngivelseMomsEUKoebBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseMomsEUKoebBeloeb;
            @XmlElement(name = "MomsAngivelseMomsEUYdelserBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseMomsEUYdelserBeloeb;
            @XmlElement(name = "MomsAngivelseOlieAfgiftBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseOlieAfgiftBeloeb;
            @XmlElement(name = "MomsAngivelseSalgsMomsBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseSalgsMomsBeloeb;
            @XmlElement(name = "MomsAngivelseVandAfgiftBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseVandAfgiftBeloeb;
            @XmlElement(name = "MomsAngivelseEUKoebYdelseBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseEUKoebYdelseBeloeb;
            @XmlElement(name = "MomsAngivelseEUSalgYdelseBeloeb", namespace = "urn:oio:skat:nemvirksomhed:1.0.0")
            protected BigInteger momsAngivelseEUSalgYdelseBeloeb;

            /**
             * Gets the value of the momsAngivelseAfgiftTilsvarBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseAfgiftTilsvarBeloeb() {
                return momsAngivelseAfgiftTilsvarBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseAfgiftTilsvarBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseAfgiftTilsvarBeloeb(BigInteger value) {
                this.momsAngivelseAfgiftTilsvarBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseCO2AfgiftBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseCO2AfgiftBeloeb() {
                return momsAngivelseCO2AfgiftBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseCO2AfgiftBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseCO2AfgiftBeloeb(BigInteger value) {
                this.momsAngivelseCO2AfgiftBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseEUKoebBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseEUKoebBeloeb() {
                return momsAngivelseEUKoebBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseEUKoebBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseEUKoebBeloeb(BigInteger value) {
                this.momsAngivelseEUKoebBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseEUSalgBeloebVarerBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseEUSalgBeloebVarerBeloeb() {
                return momsAngivelseEUSalgBeloebVarerBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseEUSalgBeloebVarerBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseEUSalgBeloebVarerBeloeb(BigInteger value) {
                this.momsAngivelseEUSalgBeloebVarerBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseIkkeEUSalgBeloebVarerBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseIkkeEUSalgBeloebVarerBeloeb() {
                return momsAngivelseIkkeEUSalgBeloebVarerBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseIkkeEUSalgBeloebVarerBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseIkkeEUSalgBeloebVarerBeloeb(BigInteger value) {
                this.momsAngivelseIkkeEUSalgBeloebVarerBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseElAfgiftBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseElAfgiftBeloeb() {
                return momsAngivelseElAfgiftBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseElAfgiftBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseElAfgiftBeloeb(BigInteger value) {
                this.momsAngivelseElAfgiftBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseEksportOmsaetningBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseEksportOmsaetningBeloeb() {
                return momsAngivelseEksportOmsaetningBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseEksportOmsaetningBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseEksportOmsaetningBeloeb(BigInteger value) {
                this.momsAngivelseEksportOmsaetningBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseGasAfgiftBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseGasAfgiftBeloeb() {
                return momsAngivelseGasAfgiftBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseGasAfgiftBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseGasAfgiftBeloeb(BigInteger value) {
                this.momsAngivelseGasAfgiftBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseKoebsMomsBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseKoebsMomsBeloeb() {
                return momsAngivelseKoebsMomsBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseKoebsMomsBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseKoebsMomsBeloeb(BigInteger value) {
                this.momsAngivelseKoebsMomsBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseKulAfgiftBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseKulAfgiftBeloeb() {
                return momsAngivelseKulAfgiftBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseKulAfgiftBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseKulAfgiftBeloeb(BigInteger value) {
                this.momsAngivelseKulAfgiftBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseMomsEUKoebBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseMomsEUKoebBeloeb() {
                return momsAngivelseMomsEUKoebBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseMomsEUKoebBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseMomsEUKoebBeloeb(BigInteger value) {
                this.momsAngivelseMomsEUKoebBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseMomsEUYdelserBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseMomsEUYdelserBeloeb() {
                return momsAngivelseMomsEUYdelserBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseMomsEUYdelserBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseMomsEUYdelserBeloeb(BigInteger value) {
                this.momsAngivelseMomsEUYdelserBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseOlieAfgiftBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseOlieAfgiftBeloeb() {
                return momsAngivelseOlieAfgiftBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseOlieAfgiftBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseOlieAfgiftBeloeb(BigInteger value) {
                this.momsAngivelseOlieAfgiftBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseSalgsMomsBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseSalgsMomsBeloeb() {
                return momsAngivelseSalgsMomsBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseSalgsMomsBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseSalgsMomsBeloeb(BigInteger value) {
                this.momsAngivelseSalgsMomsBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseVandAfgiftBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseVandAfgiftBeloeb() {
                return momsAngivelseVandAfgiftBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseVandAfgiftBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseVandAfgiftBeloeb(BigInteger value) {
                this.momsAngivelseVandAfgiftBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseEUKoebYdelseBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseEUKoebYdelseBeloeb() {
                return momsAngivelseEUKoebYdelseBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseEUKoebYdelseBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseEUKoebYdelseBeloeb(BigInteger value) {
                this.momsAngivelseEUKoebYdelseBeloeb = value;
            }

            /**
             * Gets the value of the momsAngivelseEUSalgYdelseBeloeb property.
             * 
             * @return
             *     possible object is
             *     {@link BigInteger }
             *     
             */
            public BigInteger getMomsAngivelseEUSalgYdelseBeloeb() {
                return momsAngivelseEUSalgYdelseBeloeb;
            }

            /**
             * Sets the value of the momsAngivelseEUSalgYdelseBeloeb property.
             * 
             * @param value
             *     allowed object is
             *     {@link BigInteger }
             *     
             */
            public void setMomsAngivelseEUSalgYdelseBeloeb(BigInteger value) {
                this.momsAngivelseEUSalgYdelseBeloeb = value;
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
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelsePeriodeFraDato"/&gt;
         *         &lt;element ref="{urn:oio:skat:nemvirksomhed:1.0.0}AngivelsePeriodeTilDato"/&gt;
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
            "angivelsePeriodeFraDato",
            "angivelsePeriodeTilDato"
        })
        public static class Angivelsesoplysninger {

            @XmlElement(name = "AngivelsePeriodeFraDato", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar angivelsePeriodeFraDato;
            @XmlElement(name = "AngivelsePeriodeTilDato", namespace = "urn:oio:skat:nemvirksomhed:1.0.0", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar angivelsePeriodeTilDato;

            /**
             * Gets the value of the angivelsePeriodeFraDato property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getAngivelsePeriodeFraDato() {
                return angivelsePeriodeFraDato;
            }

            /**
             * Sets the value of the angivelsePeriodeFraDato property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setAngivelsePeriodeFraDato(XMLGregorianCalendar value) {
                this.angivelsePeriodeFraDato = value;
            }

            /**
             * Gets the value of the angivelsePeriodeTilDato property.
             * 
             * @return
             *     possible object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public XMLGregorianCalendar getAngivelsePeriodeTilDato() {
                return angivelsePeriodeTilDato;
            }

            /**
             * Sets the value of the angivelsePeriodeTilDato property.
             * 
             * @param value
             *     allowed object is
             *     {@link XMLGregorianCalendar }
             *     
             */
            public void setAngivelsePeriodeTilDato(XMLGregorianCalendar value) {
                this.angivelsePeriodeTilDato = value;
            }

        }

    }

}
