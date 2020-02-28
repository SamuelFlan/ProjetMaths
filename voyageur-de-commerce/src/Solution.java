import java.util.ArrayList;

//représente une solution
public class Solution {
	//liste des villes dans l'ordre du parcours
	ArrayList<Ville> parcours;
	
	//longueur totale du parcours
	double longueur;
	
	Solution(ArrayList<Ville> parcours, double longueur){
		this.parcours = parcours;
		this.longueur = longueur;
	}
}
