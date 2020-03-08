package recuitSimulé;
import java.util.ArrayList;
import java.util.Collections;

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
          setCity(cityIndex, GestionVoyage.getVille(cityIndex));
        }
        // Randomly reorder the voyage
        Collections.shuffle(voyage);
    }

    // Gets a city from the voyage
    public Ville getCity(int voyagePosition) {
        return (Ville)voyage.get(voyagePosition);
    }

    // Sets a city in a certain position within a voyage
    public void setCity(int voyagePosition, Ville city) {
        voyage.set(voyagePosition, city);
        // If the voyages been altered we need to reset the fitness and distance
        distance = 0;
    }
    
    // Gets the total distance of the voyage
    public int getDistance(){
        if (distance == 0) {
            int voyageDistance = 0;
            // Loop through our voyage's cities
            for (int cityIndex=0; cityIndex < voyageSize(); cityIndex++) {
                // Get city we're traveling from
            	Ville fromCity = getCity(cityIndex);
                // City we're traveling to
            	Ville destinationCity;
                // Check we're not on our voyage's last city, if we are set our
                // voyage's final destination city to our starting city
                if(cityIndex+1 < voyageSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // Get the distance between the two cities
                voyageDistance += Ville.CalculerDistance(fromCity, destinationCity);
            }
            distance = voyageDistance;
        }
        return distance;
    }

    // Get number of cities on our voyage
    public int voyageSize() {
        return voyage.size();
    }
    
    @Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < voyageSize(); i++) {
            geneString += getCity(i)+"|";
        }
        return geneString;
    }
}