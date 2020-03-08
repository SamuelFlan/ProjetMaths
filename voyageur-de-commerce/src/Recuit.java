import java.util.ArrayList;

public class Recuit {

    public static double simulateAnnealing(ArrayList<Ville> villes, double startingTemperature, int numberOfIterations, double coolingRate) {
       // Vérification des données:
    	//  0 < coolingRate < 1
    	if ((coolingRate > 1) || (coolingRate < 0)) { System.err.println("Erreur: le taux de refroidissement doit être compris entre 0 et 1!"); }
    	//     	
    	System.out.println("Starting SA with temperature: " + startingTemperature + ", # of iterations: " + numberOfIterations + " and colling rate: " + coolingRate);
        double t = startingTemperature;
        
        // On crée un voyage
        Voyage_recuit travel = new Voyage_recuit(villes);
        
        // On calcule une distance initiale au hasard
        travel.generateInitialTravel();
        double bestDistance = travel.getDistance();
        System.out.println("Initial distance of travel: " + bestDistance);
        Voyage_recuit bestSolution = travel;
        Voyage_recuit currentSolution = bestSolution;

        for (int i = 0; i < numberOfIterations; i++) {
            if (t > 0.1) {
                currentSolution.swapCities();
                double currentDistance = currentSolution.getDistance();
                if (currentDistance < bestDistance) {
                    bestDistance = currentDistance;
                } else if (Math.exp((bestDistance - currentDistance) / t) < Math.random()) {
                    currentSolution.revertSwap();
                }
                t *= coolingRate;
            } else {
                continue;
            }
            if (i % 100 == 0) {
                System.out.println("Iteration #" + i);
            }
        }
        return bestDistance;
    }

}