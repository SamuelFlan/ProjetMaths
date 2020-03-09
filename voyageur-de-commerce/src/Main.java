import java.util.ArrayList;

import Algorithmes.Heuristique;
import recuitSimulé.Recuit;
import utilitaires.InOut;
import utilitaires.Solution;
import utilitaires.Ville;

public class Main {

	public static void main(String[] args) {
		
		// Lecture des arguments en java
		String algo = args[0]; // type d'algo utilisé
	    String fich = args[1]; // fichier d'entrée
	    
	    // Lecture des villes
	    InOut i = new InOut();
		ArrayList<Ville> villes = i.LireVillesDeFichier(fich);
		
		// Solution
		Solution sol = null;
	    
	    switch (algo.charAt(0)) {
	    		case 'r': // Recuit simulé
	    			Recuit rec = new Recuit();
	    			// Nombre itérations
	    			String intValue = fich.replaceAll("[^0-9]", "");
	    			int nbIt = Integer.parseInt(intValue);
	    			sol = rec.recuitSimulé(villes, 999999997, 0.00000001, nbIt * 10000000);
	    			break;
	    		case 'h': // Heuristique
	    			sol = Heuristique.ParAjoutDuPlusProche(villes);
	    			sol = Locales.Descente(sol.getParcours());
	    			
	    			
	    			break;
	    }
	    
	    // Ecrire dns fichier
	    String solS = fich.substring(0, fich.length() - 3) + "out3";
	    i.EcrireSolutionDansFichier(sol, solS);
	    
	    
	    
	}
}
