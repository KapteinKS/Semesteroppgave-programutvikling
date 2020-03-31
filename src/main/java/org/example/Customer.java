package org.example;

public class Customer {
    private String navn;
    private String adresse;
    private String postnummer;
    private String poststed;
    private String telefonnummer;

    public Customer(String navn, String adresse, String postnummer, String poststed, String telefonnummer) {
        this.navn = navn;
        this.adresse = adresse;
        this.postnummer = postnummer;
        this.poststed = poststed;
        this.telefonnummer = telefonnummer;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPostnummer() {
        return postnummer;
    }

    public void setPostnummer(String postnummer) {
        this.postnummer = postnummer;
    }

    public String getPoststed() {
        return poststed;
    }

    public void setPoststed(String poststed) {
        this.poststed = poststed;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }
}
