package recuitSimulé;
import java.util.ArrayList;

import utilitaires.Solution;
import utilitaires.Utility;

import utilitaires.Ville;

public class Recuit {

	// Calculate the acceptance probability
	public static double acceptanceProbability(int energy, int newEnergy, double temperature) {
		// If the new solution is better, accept it
		if (newEnergy < energy) { return 1.0; }
		// If the new solution is worse, calculate an acceptance probability
		return Math.exp((energy - newEnergy) / temperature);
	}

	public static Solution recuitSimulé(ArrayList<Ville> voy, double temp, double refroidissement, boolean b) {
		Solution s;
		Voyage currentSolution = new Voyage(voy);

		// Initialize intial solution
		currentSolution.generateIndividual(b);

		System.out.println("Initial solution distance: " + currentSolution.getLongueur());

		// Set as current best
		Voyage best = new Voyage(currentSolution.getVoyage());

		// Loop until system has cooled
		
			while (temp > 1) {
				{

					Voyage newSolution = new Voyage(currentSolution.getVoyage());

					// Get random positions in the tour
					int tourPos1 = Utility.randomInt(0 , newSolution.voyageSize());
					int tourPos2 = Utility.randomInt(0 , newSolution.voyageSize());

					//to make sure that tourPos1 and tourPos2 are different
					while(tourPos1 == tourPos2) {tourPos2 = Utility.randomInt(0 , newSolution.voyageSize());}

					// Get the cities at selected positions in the tour
					Ville citySwap1 = newSolution.getVille(tourPos1);
					Ville citySwap2 = newSolution.getVille(tourPos2);

					// Swap them
					newSolution.setVille(tourPos2, citySwap1);
					newSolution.setVille(tourPos1, citySwap2);

					// Get energy of solutions
					double currentDistance   = currentSolution.getLongueur();
					double neighbourDistance = newSolution.getLongueur();

					// Decide if we should accept the neighbour
					double rand = Utility.randomDouble();
					if (Utility.acceptanceProbability(currentDistance, neighbourDistance, temp) > rand) {
						currentSolution = new Voyage(newSolution.getVoyage());
					}

					// Keep track of the best solution found
					if (currentSolution.getLongueur() < best.getLongueur()) {
						best = new Voyage(currentSolution.getVoyage());
					}

					// Cool system
					temp *= 1 - refroidissement;
				}

				
				
			
		}
		
		s = new Solution(best.getVoyage());
		
		System.out.println("Final solution distance: " + best.getLongueur());
		System.out.println("Tour: " + best);
		
		return s;
		
	}
	
}