package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads symptom data from a text file.
 * Each line in the file represents one symptom.
 * <p>
 * Example of file format:
 * <pre>
 * headache
 * rash
 * fever
 * </pre>
 * </p>
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private final String filePath;

    /**
     * Creates a new reader to extract symptoms from a file.
     *
     * @param filePath relative or absolute path to the text file containing symptom names, one per line.
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Reads all symptoms from the given file.
     *
     * @return a list of all symptoms found; if no file or empty, returns an empty list.
     */
    @Override
    public List<String> GetSymptoms() {
        List<String> symptoms = new ArrayList<>();

        if (filePath == null || filePath.isEmpty()) {
            System.err.println("Error: File path is null or empty.");
            return symptoms;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptoms.add(line.trim()); // trim() pour enlever les espaces inutiles
            }
        } catch (IOException e) {
            System.err.println("Error reading symptoms from file: " + e.getMessage());
        }

        return symptoms;
    }
}
