import java.util.ArrayList;

import Algorithmes.Heuristique;
import recuitSimulé.Recuit;
import utilitaires.InOut;
import utilitaires.Solution;
import utilitaires.Ville;

public class Main {

	public static void main(String[] args) {
		InOut i = new InOut();
		ArrayList<Ville> villes = i.LireVillesDeFichier("jeu-essai/1000.in3");
		Recuit rec = new Recuit();

	
		rec.recuitSimulé(villes, 7, 0.000001, 1000000000);
		
		Solution solution = Heuristique.ParAjoutDuPlusProche(villes);
		solution = Locales.Descente(solution.getParcours());
		i.EcrireSolutionDansFichier(solution, "jeu-essai/1000.out3");
		
		
		
	}
	
	
}
