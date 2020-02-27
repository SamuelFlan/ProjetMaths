import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		ArrayList<Ville> villes = LireVillesDeFichier("jeu-essai/20.in3");
	}
	
	//retourne la liste du fichier <nomFichier>
	public static ArrayList<Ville> LireVillesDeFichier(String nomFichier){
    	ArrayList<Ville> villes = new ArrayList<Ville>();
	    try {
	        File fichier = new File(nomFichier);
	        Scanner scanner = new Scanner(fichier).useLocale(Locale.US);
	        
        	//on saute la premiere ligne (nombre de ville)
        	scanner.nextInt();
	        while (scanner.hasNextDouble()) {
				double x, y;
				x = scanner.nextDouble();
				y = scanner.nextDouble();
				villes.add(new Ville(x, y));
	        }
	        scanner.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("Fichier "+nomFichier+" non trouvé");
	        e.printStackTrace();
	      }
        return villes;
	}
}
