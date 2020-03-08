package utilitaires;
//repr�sente une ville
public class Ville {
	//position de la ville
	double x, y;

	public Ville(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return x+" "+y;
	}
	
	public double getX() { return x; }
	public double getY() { return y; }
	
	//retourne la distance euclidienne entre deux villes
	public static double CalculerDistance(Ville a, Ville b) {
		return Math.sqrt(Math.pow((b.x-a.x),2)+Math.pow((b.y-a.y),2));
	}
}
