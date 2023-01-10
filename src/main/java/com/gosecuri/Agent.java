package com.gosecuri;

import java.util.List;

public class Agent {

    public String nom;
    public String prenom;
    public String mission;
    public String password;
    public List<String> materielList;
    public String carteIdentite;

    public Agent (String nom, String prenom, String mission, String password, List<String> materiel, String carteIdentite) {
        this.nom = nom;
        this.prenom = prenom;
        this.mission = mission;
        this.password = password;
        this.materielList = materiel;
        this.carteIdentite = carteIdentite;
    }

}
