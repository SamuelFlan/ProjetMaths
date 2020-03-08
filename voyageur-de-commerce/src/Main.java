import java.awt.List;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		InOut i = new InOut();
		ArrayList<Ville> villes = i.LireVillesDeFichier("jeu-essai/100.in3");
		Recuit rec = new Recuit();
		int nbV = i.nbVillesFichier("jeu-essai/20.in3");
		
		
		System.out.println("Optimized distance for travel: " +rec.simulateAnnealing(villes, 100000, 2000, 0.25));
		
		Solution solution = Heuristique.ParAjoutDuPlusProche(villes);
		solution = Locales.Descente(solution.parcours);
		i.EcrireSolutionDansFichier(solution, "jeu-essai/100.out3");
		
		
		
	}
	
	
}
