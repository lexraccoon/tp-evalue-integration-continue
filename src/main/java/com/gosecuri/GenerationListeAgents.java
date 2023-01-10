package com.gosecuri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GenerationListeAgents {

    private List<Agent> agentsList = new ArrayList<>();

    public GenerationListeAgents(List<Agent> agentsList) throws IOException {
        this.agentsList = agentsList;
    }

    public void HTMLFicheAgentGeneration() throws IOException {
        for (Agent agent : this.agentsList) {
            String url = "fiche" + agent.prenom + agent.nom + ".html";
            File file = new File("../web/" + url);
            BufferedWriter bw = new BufferedWriter(new FileWriter(file));
            bw.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                    "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                    "    <title>Fiche agent</title>\n" +
                    "    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n" +
                    "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n" +
                    "    <link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap\" rel=\"stylesheet\">\n" +
                    "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                    "    <link rel=\"stylesheet\" href=\"fontawesome-5.15.4/css/all.css\">\n" +
                    "    <link rel=\"icon\" href=\"img/ico.ico\" />\n" +
                    "\n" +
                    "</head>\n" +
                    "<body>\n" +
                    "    <div class=\"container\">\n" +
                    "        <img src=\"img/logo.png\" alt=\"\">\n" +
                    "        <div class=\"title\" style=\"display: flex;width: 100%;justify-content: flex-start;\">\n" +
                    "            <a href=\"index.html\"><button><i class=\"fas fa-arrow-left\"></i> Liste des agents</button></a>\n" +
                    "        </div>\n" +
                    "<h1>Fiche "+ agent.prenom + " " + agent.nom + "</h1>\n" +
                    "        <div class=\"fiche-agent\">\n" +
                    "            <div class=\"top\">\n");
            bw.write("<h3 class=\"name\">" + agent.prenom + " " + agent.nom + "</h3>");
            bw.write("<img src=" + agent.carteIdentite + " style=\"width: 40%;\"/>");
            bw.write("</div>\n" +
                    "            <div class=\"bot\">\n" +
                    "                <ul class=\"list-objects\">");
            for (String materiel : agent.materielList) {
                bw.write("<li>" + materiel + " <i class=\"far fa-check-square margin-left: 0.5vw\"></i></li>");
            }
            bw.write("</ul>\n" +
                    "            </div>\n" +
                    "        </div>\n" +
                    "    </div>\n" +
                    "</body>\n" +
                    "</html>");
            bw.close();
            file.createNewFile();
        }
    }

    public void HTMLIndexGeneration() throws IOException {
        File file = new File("../web/index.html");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Accueil</title>\n" +
                "    <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
                "    <link rel=\"icon\" href=\"img/ico.ico\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"container\">\n" +
                "        <img src=\"img/logo.png\" alt=\"\">\n" +
                "        <h1>Liste d'agents</h1>");
        for (Agent agent : this.agentsList) {
            String url = "fiche" + agent.prenom + agent.nom + ".html";
            bw.write("<a class=\"link\" href=\"" + url + "\">" + agent.prenom + " " + agent.nom + "</a><br/>");
        }
        bw.write("</div>\n" +
                "</body>\n" +
                "</html>");
        bw.close();
        file.createNewFile();
    }

}
