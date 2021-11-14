package Javaquarium;
import java.io.IOException;
import java.lang.Thread;


public class Main {
	public static void main(String[] args) throws IOException {
		Fish p1 = new Merou("Charle", Sexe.MALE);
		Fish p2 = new Thon("Papi", Sexe.FEMELLE);
		Fish p3 = new PoissonClown("CoCo", Sexe.MALE);
		Fish p4 = new Sole("Gii", Sexe.FEMELLE);
		Fish p5 = new Bar("fii", Sexe.MALE);
		Fish p6 = new Carpe("boli", Sexe.FEMELLE);
		Fish p7 = new Merou("CiCi", Sexe.FEMELLE);
		Fish p8 = new Thon("Pilo", Sexe.MALE);
		Fish p9 = new Sole("deff", Sexe.MALE);
		Algue a1 = new Algue(5);
		Algue a2 = new Algue(67);
		Aquarium aquarium = new Aquarium();
		aquarium.addFish(p1);
		aquarium.addFish(p2);
		aquarium.addFish(p3);
		aquarium.addFish(p4);
		aquarium.addFish(p5);
		aquarium.addFish(p6);
		aquarium.addFish(p7);
		aquarium.addFish(p8);
		aquarium.addFish(p9);

		aquarium.addAlgue(a1);
		aquarium.addAlgue(a2);
		aquarium.addAlgue(new Algue());
		aquarium.addAlgue(new Algue());
		aquarium.addAlgue(new Algue());
		aquarium.addAlgue(new Algue());
		aquarium.showHistory();
		/*while (true) {
			try {
				Thread.sleep(1000);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
				System.out.println("### ERROR ###");
			}

		}*/

	}
}