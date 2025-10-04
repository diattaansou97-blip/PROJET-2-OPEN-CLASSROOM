package com.hemebiotech.analytics;

import java.util.List;

/**
 * Interface définissant le comportement d'un lecteur de symptômes.
 * Toute implémentation doit fournir une liste brute de symptômes,
 * qui peut contenir des doublons.
 */
public interface ISymptomReader {

    /**
     * Récupère la liste de tous les symptômes à partir d'une source de données.
     * Si aucune donnée n'est disponible, retourne une liste vide.
     *
     * @return Liste brute de symptômes, avec des doublons possibles
     */
    List<String> GetSymptoms();
}
