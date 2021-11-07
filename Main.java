package Javaquarium;

public class Main {
	public static void main(String[] args) {
		Poisson p1 = new Poisson("Zoos");
		Poisson p2 = new Poisson("Calbra", Sexe.FEMELLE);
		Poisson p3 = new Poisson("Chaos",  Sexe.FEMELLE, 30);
		Poisson p4 = new Poisson("Papi",  Sexe.FEMELLE, 17);
		Algue a1 = new Algue(5);
		Algue a2 = new Algue(67, 2);
		Aquarium aquarium = new Aquarium();
		aquarium.ajouteAlgue(a1);
		aquarium.ajouteAlgue(a2);
		aquarium.ajoutePoisson(p1);
		aquarium.ajoutePoisson(p2);
		aquarium.ajoutePoisson(p3);
		aquarium.ajoutePoisson(p4);
		aquarium.update();
	}
}