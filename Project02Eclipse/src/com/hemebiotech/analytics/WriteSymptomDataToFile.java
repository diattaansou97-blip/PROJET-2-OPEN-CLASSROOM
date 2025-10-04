package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

    private final String filePath; // chemin du fichier où écrire

    // Constructeur : on passe le chemin du fichier
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    // Implémentation de la méthode de l'interface
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filePath)) { // ouverture du fichier en écriture
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) { // pour chaque symptôme
                writer.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) { // si erreur d’écriture
            System.err.println("Erreur écriture fichier : " + e.getMessage());
        }
    }
}
