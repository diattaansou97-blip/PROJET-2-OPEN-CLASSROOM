import com.hemebiotech.analytics.ISymptomReader;
import com.hemebiotech.analytics.ISymptomWriter;
import com.hemebiotech.analytics.ReadSymptomDataFromFile;
import com.hemebiotech.analytics.WriteSymptomDataToFile;
import com.hemebiotech.analytics.AnalyticsCounter;

import java.util.List;
import java.util.Map;


public class Main {

    public static void main(String[] args) {
        // 1️⃣ Créer les objets pour lire et écrire
        ISymptomReader reader = new ReadSymptomDataFromFile("C:\\\\\\\\Users\\\\\\\\diatt\\\\\\\\eclipse-workspace\\\\\\\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\\\\\\\Project02Eclipse\\\\\\\\src\\\\\\\\com\\\\\\\\hemebiotech\\\\\\\\analytics\\\\\\\\symptoms.txt"); // chemin relatif
        ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

        // 2️⃣ Créer AnalyticsCounter
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        // 3️⃣ Exécuter les étapes
        List<String> symptoms = counter.getSymptoms();
        Map<String, Integer> counts = counter.countSymptoms(symptoms);
        Map<String, Integer> sortedCounts = counter.sortSymptoms(counts);
        counter.writeSymptoms(sortedCounts);

        // Affichage optionnel dans la console
        sortedCounts.forEach((symptom, count) -> System.out.println(symptom + ": " + count));
    }
}
