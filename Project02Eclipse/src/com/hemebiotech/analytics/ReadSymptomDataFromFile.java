package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Lit les données des symptômes à partir d'un fichier texte.
 * Chaque ligne du fichier correspond à un symptôme.
 * <p>
 * Exemple de format de fichier :
 * <pre>
 * headache
 * rash
 * fever
 * </pre>
 * </p>
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    /** Chemin vers le fichier contenant les symptômes. */
    private final String filePath;

    /**
     * Crée un lecteur capable d'extraire les symptômes depuis un fichier.
     *
     * @param filePath chemin relatif ou absolu vers le fichier texte contenant les noms de symptômes, un par ligne.
     */
    public ReadSymptomDataFromFile(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Lit tous les symptômes dans le fichier donné.
     *
     * @return une liste de tous les symptômes trouvés ; si le fichier est inexistant ou vide, retourne une liste vide.
     */
    @Override
    public List<String> GetSymptoms() {
        List<String> symptoms = new ArrayList<>();

        if (filePath == null || filePath.isEmpty()) {
            System.err.println("Erreur : le chemin du fichier est vide ou null.");
            return symptoms;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                symptoms.add(line.trim()); // supprime les espaces inutiles
            }
        } catch (IOException e) {
            System.err.println("Erreur lecture fichier de symptômes : " + e.getMessage());
        }

        return symptoms;
    }
}
