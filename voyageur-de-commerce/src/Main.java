import java.util.ArrayList;

import Algorithmes.Heuristique;
import Algorithmes.Locales;
import recuitSimul�.Recuit;
import utilitaires.InOut;
import utilitaires.Solution;
import utilitaires.Ville;

public class Main {

	public static void main(String[] args) {
		
		// Lecture des arguments en java
		String algo = args[0]; // type d'algo utilis�
	    String fich = args[1]; // fichier d'entr�e
	    
	    // Lecture des villes
	    InOut i = new InOut();
		ArrayList<Ville> villes = i.LireVillesDeFichier(fich);
		
		// Solution
		Solution sol = null;
	    
	    switch (algo.charAt(0)) {
	    		case 'r': // Recuit simul�
	    			Recuit rec = new Recuit();
	    			// Nombre it�rations
	    			String intValue = fich.replaceAll("[^0-9]", "");
	    			int nbIt = Integer.parseInt(intValue);
	    			if(args.length == 2) // Pas d'args suppl�mentaires 
	    			{ sol = rec.recuitSimul�(villes, 1000, 0.00001); }
	    			else // Arguments suppl�mentaires
	    			{
	    				int temp = Integer.parseInt(args[2]);
	    				double refr = Double.parseDouble(args[3]);
	    				sol = rec.recuitSimul�(villes, temp, refr);
	    			}
	    			
	    			break;
	    		case 'h': // Heuristique
	    			sol = Heuristique.ParAjoutDuPlusProche(villes);
	    			break;
	    		case 'l':
	    			sol = Locales.Descente(villes);
	    			break;
	    }
	    
	    // Ecrire dns fichier
	    String solS = fich.substring(0, fich.length() - 3) + "out3";
	    i.EcrireSolutionDansFichier(sol, solS);
	    
	}
}
