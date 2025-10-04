package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    public static void main(String[] args) {
        String inputFile = "C:\\Users\\diatt\\eclipse-workspace\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt";
        String outputFile = "result.out";

        Map<String, Integer> symptomCount = new TreeMap<>(); // TreeMap trie automatiquement par clé

        // Lecture du fichier et comptage des symptômes
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim(); // enlever les espaces inutiles
                if (!line.isEmpty()) {
                    symptomCount.put(line, symptomCount.getOrDefault(line, 0) + 1);
                    System.out.println(line + ": " + symptomCount.get(line));
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture fichier : " + e.getMessage());
            return;
        }

        // Écriture des résultats triés
        try (FileWriter writer = new FileWriter(outputFile)) {
            for (Map.Entry<String, Integer> entry : symptomCount.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            System.out.println("Résultats écrits dans " + outputFile + " ✅");
        } catch (IOException e) {
            System.err.println("Erreur écriture fichier : " + e.getMessage());
        }
    }
}
