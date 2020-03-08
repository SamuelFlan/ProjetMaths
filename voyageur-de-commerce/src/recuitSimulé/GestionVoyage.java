package recuitSimulé;
import java.util.ArrayList;

import utilitaires.Ville;

public class GestionVoyage {

    // Holds our cities
    private static ArrayList<Ville> destinations = new ArrayList<Ville>();

    // Adds a destination city
    public static void addVille(Ville city) {
        destinations.add(city);
    }
    
    // Get a city
    public static Ville getVille(int index){
        return (Ville)destinations.get(index);
    }
    
    // Get the number of destination cities
    public static int nbVille(){
        return destinations.size();
    }
    
}