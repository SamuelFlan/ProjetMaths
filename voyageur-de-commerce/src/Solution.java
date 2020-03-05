import java.util.ArrayList;

//repr�sente une solution
public class Solution {
	//liste des villes dans l'ordre du parcours
	ArrayList<Ville> parcours;
	
	//longueur totale du parcours
	double getLongueur() {
		double longueur = 0;
		int nombreDeVilles = parcours.size();
		//pour chaque ville on ajoute la distance entre cette ville et la précedente à la longueur du parcours
		for(int i = 1; i < nombreDeVilles; i++) {
			longueur += Ville.CalculerDistance(parcours.get(i), parcours.get(i-1));
		}
		//on ajoute la distance entre la dernière et la première ville du parcours
		longueur += Ville.CalculerDistance(parcours.get(nombreDeVilles - 1), parcours.get(0));
		return longueur;
	};
	
	Solution(ArrayList<Ville> parcours){
		this.parcours = parcours;
	}
}
