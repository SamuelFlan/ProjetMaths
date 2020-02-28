import java.util.ArrayList;

public class Heuristique {
	
	//Première méthode: Construction itérative par ajout du plus proche
	public static Solution ParAjoutDuPlusProche(ArrayList<Ville> villes) {
		ArrayList<Ville> parcours = new ArrayList<>();
		parcours.add(villes.get(0));
		villes.remove(0);
		double longueur = 0;
		int nombreDeVilles = villes.size();
		for(int i = 1; i < nombreDeVilles+1; i++) {
			//on trouve la ville la plus proche de la dernière ville du parcours
			Ville villeLaPlusProche = TrouverVilleLaPlusProche(villes, parcours.get(i-1));
			//on la retire de la liste des villes
			villes.remove(villeLaPlusProche);
			//on ajoute la distance entre les deux villes à la longueur
			//System.out.println(CalculerDistance(villeLaPlusProche, parcours.get(i-1)));
			longueur += CalculerDistance(villeLaPlusProche, parcours.get(i-1));
			//on l'ajoute au parcours
			parcours.add(villeLaPlusProche);
		}
		//on ajoute la longueur entre la dernière et la première ville du parcours
		longueur += CalculerDistance(parcours.get(parcours.size() - 1), parcours.get(0));
		return new Solution(parcours, longueur);
	}
	
	//Trouve la ville la plus proche de la ville passée en paramètre dans une liste
	public static Ville TrouverVilleLaPlusProche(ArrayList<Ville> villes, Ville ville) {
		ArrayList<Ville> villesTriees = new ArrayList(villes);
		//On trie les villes par distance par rapport à la ville passée en paramètre
		villesTriees.sort((a,b) -> {
			return CalculerDistance(a, ville) < CalculerDistance(b, ville) ? -1 : 1;
		});
		//on retourne la première
		return villesTriees.get(0);
	}
	
	//retourne la distance euclidienne entre deux villes
	public static double CalculerDistance(Ville a, Ville b) {
		return Math.sqrt(Math.pow((b.x-a.x),2)+Math.pow((b.y-a.y),2));
	}
}
