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
		ArrayList<Ville> villes = i.LireVillesDeFichier("jeu-essai/20.in3");
		Solution solution = Heuristique.ParAjoutDuPlusProche(villes);
		i.EcrireSolutionDansFichier(solution, "jeu-essai/20.out3");
	}
	
	
}
