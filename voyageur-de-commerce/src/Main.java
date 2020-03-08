import java.util.ArrayList;

import Algorithmes.Heuristique;
import recuitSimulé.Recuit;
import utilitaires.InOut;
import utilitaires.Solution;
import utilitaires.Ville;

public class Main {

	public static void main(String[] args) {
		InOut i = new InOut();
		ArrayList<Ville> villes = i.LireVillesDeFichier("jeu-essai/100.in3");
		Recuit rec = new Recuit();

	
		rec.recuitSimulé(villes, 7, 0.003, 10000);
		
		Solution solution = Heuristique.ParAjoutDuPlusProche(villes);
		solution = Locales.Descente(solution.getParcours());
		i.EcrireSolutionDansFichier(solution, "jeu-essai/100.out3");
		
		
		
	}
	
	
}
