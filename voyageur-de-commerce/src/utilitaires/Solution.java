package utilitaires;
import java.util.ArrayList;

//repr�sente une solution
public class Solution {
	//liste des villes dans l'ordre du parcours
	private ArrayList<Ville> parcours;
	
	//longueur totale du parcours
	public double getLongueur() {
		double longueur = 0;
		int nombreDeVilles = getParcours().size();
		//pour chaque ville on ajoute la distance entre cette ville et la précedente à la longueur du parcours
		for(int i = 1; i < nombreDeVilles; i++) {
			longueur += Ville.CalculerDistance(getParcours().get(i), getParcours().get(i-1));
		}
		//on ajoute la distance entre la dernière et la première ville du parcours
		longueur += Ville.CalculerDistance(getParcours().get(nombreDeVilles - 1), getParcours().get(0));
		return longueur;
	};
	
	public Solution(ArrayList<Ville> parcours){
		this.setParcours(parcours);
	}

	public ArrayList<Ville> getParcours() {
		return parcours;
	}

	public void setParcours(ArrayList<Ville> parcours) {
		this.parcours = parcours;
	}
}
