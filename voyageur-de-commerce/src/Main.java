import java.util.ArrayList;

import Algorithmes.Heuristique;
import recuitSimulé.Recuit;
import utilitaires.InOut;
import utilitaires.Solution;
import utilitaires.Ville;

public class Main {

	public static void main(String[] args) {
		InOut i = new InOut();
		ArrayList<Ville> villes = i.LireVillesDeFichier("jeu-essai/20.in3");
		Recuit rec = new Recuit();
		int nbV = i.nbVillesFichier("jeu-essai/20.in3");
		
		rec.recuitSimulé(villes, 7, 0.003, 20);
		//System.out.println("Optimized distance for travel: " +rec.simulateAnnealing(villes, 100000, 2000, 0.003));
		
		Solution solution = Heuristique.ParAjoutDuPlusProche(villes);
		solution = Locales.Descente(solution.getParcours());
		i.EcrireSolutionDansFichier(solution, "jeu-essai/20.out3");
		
		
		
	}
	
	
}
