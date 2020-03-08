package recuitSimulé;
import java.util.ArrayList;

import utilitaires.Ville;

public class Recuit {

    // Calculate the acceptance probability
    public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
        // If the new solution is better, accept it
        if (newEnergy < energy) {
            return 1.0;
        }
        // If the new solution is worse, calculate an acceptance probability
        return Math.exp((energy - newEnergy) / temperature);
    }

    public static void recuitSimulé(ArrayList<Ville> voy, double temp, double refroidissement, int i) {

    	Voyage currentSolution = new Voyage(voy);
    	
        // Initialize intial solution
        currentSolution.generateIndividual();
        
        System.out.println("Initial solution distance: " + currentSolution.getDistance());

        // Set as current best
        Voyage best = new Voyage(currentSolution.getVoyage());
        
        // Loop until system has cooled
        for (int n = 0; n < i; n++) {
        	if (temp > 1) {
        		{
                    // Create new neighbor tour
                    Voyage newSolution = new Voyage(currentSolution.getVoyage());

                    // Get a random positions in the tour
                    int tourPos1 = (int) (newSolution.voyageSize() * Math.random());
                    int tourPos2 = (int) (newSolution.voyageSize() * Math.random());

                    // Get the cities at selected positions in the tour
                    Ville citySwap1 = newSolution.getCity(tourPos1);
                    Ville citySwap2 = newSolution.getCity(tourPos2);

                    // Swap them
                    newSolution.setCity(tourPos2, citySwap1);
                    newSolution.setCity(tourPos1, citySwap2);
                    
                    // Get energy of solutions
                    int currentEnergy = currentSolution.getDistance();
                    int neighbourEnergy = newSolution.getDistance();

                    // Decide if we should accept the neighbour
                    if (acceptanceProbability(currentEnergy, neighbourEnergy, temp) > Math.random()) {
                        currentSolution = new Voyage(newSolution.getVoyage());
                    }

                    // Keep track of the best solution found
                    if (currentSolution.getDistance() < best.getDistance()) {
                        best = new Voyage(currentSolution.getVoyage());
                    }
                    
                    // Cool system
                    temp *= 1-refroidissement;
                }
        	}
        }

        System.out.println("Final solution distance: " + best.getDistance());
        System.out.println("Voyage: " + best);
    }
}