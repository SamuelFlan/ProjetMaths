package recuitSimul�;
import java.util.ArrayList;
import java.util.Collections;

import utilitaires.Utility;
import utilitaires.Ville;

public class Voyage {

    // Holds our voyage of cities
    private ArrayList<Ville> voyage = new ArrayList<Ville>();
    // Cache
    private int distance = 0;
    
    // Constructs a blank voyage
    public Voyage(){
        for (int i = 0; i < GestionVoyage.nbVille(); i++) {
            voyage.add(null);
        }
    }
    
    // Constructs a voyage from another voyage
    public Voyage(ArrayList<Ville> voyage){
        this.voyage = (ArrayList) voyage.clone();
    }
    
    // Returns voyage information
    public ArrayList getVoyage(){
        return voyage;
    }

    // Creates a random individual
    public void generateIndividual() {
        // Loop through all our destination cities and add them to our voyage
        for (int cityIndex = 0; cityIndex < GestionVoyage.nbVille(); cityIndex++) {
          setVille(cityIndex, GestionVoyage.getVille(cityIndex));
        }
        // Randomly reorder the voyage
        Collections.shuffle(voyage);
    }

    // Gets a city from the voyage
    public Ville getVille(int voyagePosition) {
        return (Ville)voyage.get(voyagePosition);
    }

    // Sets a city in a certain position within a voyage
    public void setVille(int voyagePosition, Ville city) {
        voyage.set(voyagePosition, city);
        // If the voyages been altered we need to reset the fitness and distance
        distance = 0;
    }
    
 
    // Get number of cities on our voyage
    public int voyageSize() {
        return voyage.size();
    }
    
	public double getLongueur() {
		double longueur = 0;
		int nombreDeVilles = voyage.size();
		//pour chaque ville on ajoute la distance entre cette ville et la précedente à la longueur du parcours
		for(int i = 1; i < nombreDeVilles; i++) {
			longueur += Ville.CalculerDistance(voyage.get(i), voyage.get(i-1));
		}
		//on ajoute la distance entre la dernière et la première ville du parcours
		longueur += Ville.CalculerDistance(voyage.get(nombreDeVilles - 1), voyage.get(0));
		return longueur;
	};
    
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < voyageSize(); i++) {
            geneString += getVille(i)+"|";
        }
        return geneString;
    }
}