package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalyticsCounter {
    private static int headacheCount = 0;   // initialize to 0
    private static int rashCount = 0;       // initialize to 0
    private static int pupilCount = 0;      // initialize to 0
    
    public static void main(String args[]) {
        try {
            // first get input
            BufferedReader reader = new BufferedReader(
                new FileReader("C:\\Users\\diatt\\eclipse-workspace\\Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application\\Project02Eclipse\\src\\com\\hemebiotech\\analytics\\symptoms.txt")
            );

            String line = reader.readLine();

            int i = 0;  // set i to 0
            while (line != null) {
                i++;    // increment i
                System.out.println("symptom from file: " + line);

                if (line.equals("headache")) {
                    headacheCount++;   // on incrémente bien la bonne variable
                    System.out.println("number of headaches: " + headacheCount);
                }
                else if (line.equals("rash")) {   // correction "rush" → "rash"
                    rashCount++;
                }
                else if (line.contains("pupil")) {   // correction "pupils" → plus générique
                    pupilCount++;
                }

                line = reader.readLine();   // get another symptom
            }
            reader.close();

            // next generate output
            FileWriter writer = new FileWriter("result.out");
            writer.write("headache: " + headacheCount + "\n");
            writer.write("rash: " + rashCount + "\n");
            writer.write("dilated pupils: " + pupilCount + "\n");
            writer.close();

            System.out.println("Résultats écrits dans result.out ✅");

        } catch (IOException e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}
