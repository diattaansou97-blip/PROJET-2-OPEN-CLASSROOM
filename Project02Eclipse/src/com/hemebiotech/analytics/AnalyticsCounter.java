package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    // Lire les symptômes
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    // Compter les occurrences
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> counts = new TreeMap<>();
        for (String s : symptoms) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        return counts;
    }

    // Trier les symptômes (TreeMap trie déjà par clé)
    public Map<String, Integer> sortSymptoms(Map<String, Integer> counts) {
        return new TreeMap<>(counts);
    }

    // Écrire dans le fichier
    public void writeSymptoms(Map<String, Integer> counts) {
        writer.writeSymptoms(counts);
    }
}
