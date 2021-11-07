package Javaquarium;
import java.lang.Thread;


public class Main {
	public static void main(String[] args) {
		Fish p1 = new CarnivorFish("Charle", CarnivorSpecie.MEROU, Sexe.MALE);
		Fish p2 = new CarnivorFish("Papi", CarnivorSpecie.TUNA, Sexe.FEMELLE);
		Fish p3 = new CarnivorFish("CoCo", CarnivorSpecie.CLOWN_FISH, Sexe.MALE);
		Fish p4 = new HerbivorFish("Gii", HerbivorSpecie.SOLE,  Sexe.FEMELLE);
		Fish p5 = new HerbivorFish("fii", HerbivorSpecie.BAR,  Sexe.MALE);
		Fish p6 = new HerbivorFish("boli", HerbivorSpecie.CARPE,  Sexe.FEMELLE);
		Fish p7 = new CarnivorFish("CiCi", CarnivorSpecie.MEROU, Sexe.FEMELLE);
		Algue a1 = new Algue(5);
		Algue a2 = new Algue(67);
		Aquarium aquarium = new Aquarium();
		aquarium.addAlgue(a1);
		aquarium.addAlgue(a2);
		aquarium.addFish(p1);
		aquarium.addFish(p2);
		aquarium.addFish(p3);
		aquarium.addFish(p4);
		aquarium.addFish(p5);
		aquarium.addFish(p6);
		aquarium.addFish(p7);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				System.out.println("### ERROR ###");
			}
			aquarium.update();
		}

	}
}