package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
    /**
     * Écrit les symptômes et leur nombre dans un fichier
     * @param symptoms map symptom → count
     */
    void writeSymptoms(Map<String, Integer> symptoms);
}
