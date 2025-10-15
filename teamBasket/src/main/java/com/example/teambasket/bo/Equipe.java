package com.example.teambasket.bo;

import java.util.Objects;

public class Equipe {

    private int noEquipe;
    private String nomEquipe;

    public Equipe() {

    }

    public Equipe(int noEquipe, String nomEquipe) {
        this.noEquipe = noEquipe;
        this.nomEquipe = nomEquipe;
    }

    public int getNoEquipe() {
        return noEquipe;
    }

    public void setNoEquipe(int noEquipe) {
        this.noEquipe = noEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Equipe equipe)) return false;
        return Objects.equals(nomEquipe, equipe.nomEquipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomEquipe);
    }

    @Override // Pourquoi Override ? Parce que c'est un objet système ==> chaque classe l'hérite.
    // Sans override, ça retournerait la référence d'objet.
    public String toString() {
        return "Equipe{" +
                "noEquipe=" +
                noEquipe +
                ", nomEquipe=" +
                nomEquipe +
                '}';
    }

}
