package utilitaires;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class InOut {
	// Retourne le nombre de villes du fichier <nomFichier>
	public static int nbVillesFichier(String nomFichier){
		
		int nbVilles = 0 ;
	    try {
	        File fichier = new File(nomFichier);
	        Scanner scanner = new Scanner(fichier).useLocale(Locale.US);
	        
	        nbVilles = scanner.nextInt();
	        scanner.close();
	      } catch (FileNotFoundException e) {
	        System.out.println("Fichier "+nomFichier+" non trouvé");
	        e.printStackTrace();
	      }
        return nbVilles;
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
		
		//ï¿½crit la solution obtenue dans un fichier
		public static void EcrireSolutionDansFichier(Solution solution, String nomFichier) {
	        try {
	        	BufferedWriter writer = new BufferedWriter(new FileWriter(nomFichier));
	            //on ï¿½crit le nombre de ville
	            writer.write(Integer.toString(solution.getParcours().size()));
	            //la longueur du parcours
	            writer.newLine();
	            writer.write(Double.toString(solution.getLongueur()));
	            //et les coordonnï¿½es des villes du parcours
	            for(Ville ville : solution.getParcours()) {
	            	writer.newLine();
	            	writer.write(ville.toString());
	            }
	            writer.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
}
