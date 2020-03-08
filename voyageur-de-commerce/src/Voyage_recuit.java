
import java.util.ArrayList;
import java.util.Collections;

public class Voyage_recuit {


    private ArrayList<Ville> travel = new ArrayList<>();
    private ArrayList<Ville> previousTravel = new ArrayList<>();

    public Voyage_recuit(ArrayList<Ville> voy) {
    	travel = voy;
    }
    
    public void generateInitialTravel() {
    	// On mélange au hasard les villes, afin de créer un premier voyage aléatoire
        Collections.shuffle(travel);
    }

    
    public void swapCities() {
        int a = generateRandomIndex();
        int b = generateRandomIndex();
        previousTravel = travel;
        Ville x = travel.get(a);
        Ville y = travel.get(b);
        travel.set(a, y);
        travel.set(b, x);
    }

    public void revertSwap() {
        travel = previousTravel;
    }

    private int generateRandomIndex() {
        return (int) (Math.random() * travel.size());
    }

    public Ville getVille(int index) {
        return travel.get(index);
    }

    public int getDistance() {
        int distance = 0;
        for (int index = 0; index < travel.size(); index++) {
            Ville starting = getVille(index);
            Ville destination;
            if (index + 1 < travel.size()) {
                destination = getVille(index + 1);
            } else {
                destination = getVille(0);
            }
            
            distance += starting.CalculerDistance(starting, destination);
        }
        return distance;
    }

}