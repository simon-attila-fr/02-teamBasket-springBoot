package com.example.teambasket.bo;

import java.util.Objects;

public class Joueur {
    private int idJoueur;
    private String nomJoueur;
    private String prenomJoueur;
    private String emailJoueur;
    private int nbEquipe;

    public Joueur() {}

    public Joueur(
            int idJoueur,
            String nomJoueur,
            String prenomJoueur,
            String emailJoueur,
            int nbEquipe
    ) {
        this.idJoueur = idJoueur;
        this.nomJoueur = nomJoueur;
        this.prenomJoueur = prenomJoueur;
        this.emailJoueur = emailJoueur;
        this.nbEquipe = nbEquipe;
    }

//    ID
    public int getIdJoueur() {
        return idJoueur;
    }

    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

//    NOM
    public String getNomJoueur() {
        return nomJoueur;
    }

    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

//    PRENOM
    public String getPrenomJoueur() {
        return prenomJoueur;
    }

    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

//    EMAIL
    public String getEmailJoueur() {
        return emailJoueur;
    }

    public void setEmailJoueur(String emailJoueur) {
        this.emailJoueur = emailJoueur;
    }

//    NBEQUIPE
    public int getNbEquipe() {
        return nbEquipe;
    }

    public void setNbEquipe(int nbEquipe) {
        this.nbEquipe = nbEquipe;
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "idJoueur=" +
                idJoueur +
                ", nomJoueur='=" +
                nomJoueur +
                ", prenomJoueur='=" +
                prenomJoueur +
                ", emailJoueur='=" +
                emailJoueur +
                ", nbEquipe=" + nbEquipe +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Joueur joueur)) return false;
        return Objects.equals(idJoueur, joueur.idJoueur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJoueur);
    }
}
