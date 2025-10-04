package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe principale pour gérer les symptômes :
 * - lecture depuis un ISymptomReader
 * - comptage et tri des symptômes
 * - écriture via un ISymptomWriter
 * 
 * L’injection des dépendances permet de séparer les responsabilités
 * et facilite les tests et la maintenance.
 */
public class AnalyticsCounter {

    private ISymptomReader reader;
    private ISymptomWriter writer;

    /**
     * Constructeur avec injection de dépendances.
     *
     * @param reader lecteur de symptômes
     * @param writer écrivain de symptômes
     */
    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Récupère la liste brute des symptômes.
     *
     * @return liste des symptômes
     */
    public List<String> getSymptoms() {
        return reader.GetSymptoms();
    }

    /**
     * Compte les occurrences de chaque symptôme.
     *
     * @param symptoms liste brute de symptômes
     * @return Map avec le symptôme comme clé et le nombre d’occurrences
     */
    public Map<String, Integer> countSymptoms(List<String> symptoms) {
        Map<String, Integer> counts = new TreeMap<>();
        for (String s : symptoms) {
            counts.put(s, counts.getOrDefault(s, 0) + 1);
        }
        return counts;
    }

    /**
     * Trie les symptômes par ordre alphabétique.
     *
     * @param counts Map de symptômes et occurrences
     * @return Map triée par clé
     */
    public Map<String, Integer> sortSymptoms(Map<String, Integer> counts) {
        return new TreeMap<>(counts);
    }

    /**
     * Écrit les symptômes triés dans le fichier de sortie.
     *
     * @param counts Map de symptômes et occurrences
     */
    public void writeSymptoms(Map<String, Integer> counts) {
        writer.writeSymptoms(counts);
    }
}
