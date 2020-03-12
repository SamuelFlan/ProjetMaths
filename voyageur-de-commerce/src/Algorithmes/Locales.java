package Algorithmes;
import java.util.ArrayList;
import java.util.Collections;

import utilitaires.Solution;
import utilitaires.Ville;

//métodes locales (utilise les tournées voisine)
public class Locales {
	//algorithme de descente locale
	public static Solution Descente(ArrayList<Ville> parcours) {
		//on créer une solution temporaire
		Solution solution = new Solution(parcours);
		//pour chaque ville on inverse cette ville avec une autre ville dans le parcours
		for(Ville b : parcours) {
			for(Ville a : parcours) {
				if(a!=b) {
					ArrayList<Ville> parcoursVoisin = new ArrayList<>(parcours);
					//(inverse les deux villes dans le parcours)
					Collections.swap(parcoursVoisin, parcours.indexOf(a), parcours.indexOf(b));
					//si la solution est mieux on la garde
					Solution nouvelleSolution = new Solution(parcoursVoisin);
					if(nouvelleSolution.getLongueur()<solution.getLongueur()) {
						solution = nouvelleSolution;
					}
				}
			}
		}
		return solution;
	}
}
