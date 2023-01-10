package com.gosecuri;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Agent> agentsList = new ArrayList<>();
        File dir = new File("../ressources/agents_txt/");
        File[] directoryStream = dir.listFiles();

        if (directoryStream != null) {
            for (File file : directoryStream) {
                List<String> lines = Files.readAllLines(Paths.get(file.getAbsolutePath()));
                int linesCount = (int) lines.stream().count();
                String nom = lines.get(0);
                String prenom = lines.get(1);
                String mission = lines.get(2);
                String password = lines.get(3);
                List<String> materiel = lines.subList(5, linesCount);
                String carteIdentite = ("img/agents_jpg/" + prenom.charAt(0) + nom + ".jpg").toLowerCase();
                agentsList.add(new Agent(nom, prenom, mission, password, materiel, carteIdentite));
            }
        }

        GenerationListeAgents generationListeAgents = new GenerationListeAgents(agentsList);
        generationListeAgents.HTMLIndexGeneration();
        generationListeAgents.HTMLFicheAgentGeneration();
    }
}
