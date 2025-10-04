package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    public static void main(String[] args) {

        // 1. Lire les symptômes depuis le fichier
        ISymptomReader reader = new ReadSymptomDataFromFile("C:\\\\Users\\\\diatt\\\\eclipse-workspace\\\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\Project02Eclipse\\\\src\\\\com\\\\hemebiotech\\\\analytics\\\\symptoms.txt");
        List<String> symptoms = reader.GetSymptoms();

        // 2. Compter les occurrences
        Map<String, Integer> symptomCount = new TreeMap<>(); // trie alphabétique
        for (String s : symptoms) {
            s = s.trim();
            if (!s.isEmpty()) {
                symptomCount.put(s, symptomCount.getOrDefault(s, 0) + 1);
            }
        }

        // 3. Écrire les résultats dans result.out
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
        writer.writeSymptoms(symptomCount);

        // 4. Affichage console (optionnel)
        symptomCount.forEach((symptom, count) -> System.out.println(symptom + ": " + count));
    }
}
