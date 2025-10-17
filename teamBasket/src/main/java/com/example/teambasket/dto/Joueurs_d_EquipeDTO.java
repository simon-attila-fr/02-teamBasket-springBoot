package com.example.teambasket.dto;

public class Joueurs_d_EquipeDTO {
    public String nomEquipe;
    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    private int idJoueur;
    public int getIdJoueur() {
        return idJoueur;
    }
    public void setIdJoueur(int idJoueur) {
        this.idJoueur = idJoueur;
    }

    private String nomJoueur;
    public String getNomJoueur() {
        return nomJoueur;
    }
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    private String prenomJoueur;
    public String getPrenomJoueur() {
        return prenomJoueur;
    }
    public void setPrenomJoueur(String prenomJoueur) {
        this.prenomJoueur = prenomJoueur;
    }

    public String emailJoueur;
    public String getEmailJoueur() {
        return emailJoueur;
    }
    public void setEmailJoueur(String emailJoueur) {
        this.emailJoueur = emailJoueur;
    }
}
