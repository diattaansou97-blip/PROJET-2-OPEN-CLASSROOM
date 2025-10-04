package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implémentation de ISymptomWriter qui écrit les symptômes et leur
 * nombre d'occurrences dans un fichier texte.
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    /** Chemin du fichier de sortie */
    private final String filePath;

    /**
     * Constructeur.
     *
     * @param filePath chemin du fichier dans lequel écrire les symptômes
     */
    public WriteSymptomDataToFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Écrit les symptômes et leur nombre d'occurrences dans le fichier de sortie.
     *
     * @param symptoms Map contenant le nom du symptôme comme clé
     *                 et le nombre d'occurrences comme valeur
     */
    @Override
    public void writeSymptoms(Map<String, Integer> symptoms) {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + System.lineSeparator());
            }
        } catch (IOException e) {
            System.err.println("Erreur écriture fichier : " + e.getMessage());
        }
    }
}
