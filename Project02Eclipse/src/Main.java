import com.hemebiotech.analytics.ISymptomReader;
import com.hemebiotech.analytics.ISymptomWriter;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.WriteSymptomDataToFile;
import com.hemebiotech.analytics.AnalyticsCounter;

import java.util.List;
import java.util.Map;

/**
 * Classe principale qui lance l'application d'analyse des symptômes.
 * 
 * Elle crée les objets nécessaires pour lire les symptômes, compter leurs occurrences,
 * trier les résultats et écrire le tout dans un fichier de sortie.
 */
public class Main {

    /**
     * Point d'entrée de l'application.
     *
     * @param args arguments passés depuis la ligne de commande (non utilisés ici)
     */
    public static void main(String[] args) {
        // 1️⃣ Créer les objets pour lire et écrire les données
        ISymptomReader reader = new ReadSymptomDataFromFile(
            "C:\\Users\\diatt\\eclipse-workspace\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt"
        ); // chemin absolu vers le fichier de symptômes
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // 2️⃣ Créer l'objet AnalyticsCounter avec injection de dépendances
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // 3️⃣ Exécuter les étapes de traitement
        List<String> symptoms = counter.getSymptoms(); // lecture des symptômes
        Map<String, Integer> counts = counter.countSymptoms(symptoms); // comptage
        Map<String, Integer> sortedCounts = counter.sortSymptoms(counts); // tri alphabétique
        counter.writeSymptoms(sortedCounts); // écriture dans le fichier

        // 4️⃣ Affichage optionnel dans la console
        sortedCounts.forEach((symptom, count) -> System.out.println(symptom + ": " + count));
    }
}
