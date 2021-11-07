package Javaquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Aquarium {
	private List<Fish> fish;
	private List<Algue> algues;
	private int tours;

	public Aquarium() {
		this.fish = new ArrayList<>();
		this.algues = new ArrayList<>();
		this.tours = 0;
	}

	public void addAlgue(Algue a) {
		this.algues.add(a);
	}

	public void addFish(Fish p) {
		this.fish.add(p);
	}

	public void removeDeadFish() {
		this.fish = this.fish.stream().filter(p -> ! p.isDead).collect(Collectors.toList());
	}

	public void removeDeadAlgues() {
		this.algues = this.algues.stream().filter(p -> ! p.isDead).collect(Collectors.toList());
	}

	public void showFish() {
		for (Fish e : this.fish) {
			System.out.println("\t- " + e.name + "(age: " + e.age + ", pv: " + e.pv + ", sexe: " + e.sexe + " specie: " + e.getSpecie() +" )");
		}
	}

	public void showAlgues() {
		for (Algue e : this.algues) {
			System.out.println("\t- (age: " + e.age + ", pv: " + e.pv + " )");
		}
	}

	public void removeFish(Fish fish) {
		this.fish.remove(fish);
	}

	public void diviseAlgue() {
		for (int i = 0; i < this.algues.size(); i++) {
			Algue children = this.algues.get(i).divise();
			if (children != null) {
				addAlgue(children);
			}
		}
	}

	public void updateAlgue() {
		for (Algue algue: this.algues) {
			algue.heal(1);
		}
	}

	public void updateFish() {
		for (Fish fish: this.fish) {
			if (fish.age == 20) {
				removeFish(fish);
			}
			fish.hurt(1);
			fish.old(1);
		}
	}

	public void fishBirth() {
		for (Fish fish: this.fish) {
			Fish random_fish = getRandomFish();
			if (fish.wantHaveChild(random_fish)) {
				addFish(fish.giveBirth());
			}
		}
	}

	public void show() {
		System.out.println("==== poisson ====");
		showFish();
		System.out.println("==== algue ====");
		showAlgues();
	}

	public Fish getRandomFish() {
		Random r = new Random();
		int index = r.nextInt(this.fish.size());
		return this.fish.get(index);
	}

	public Algue getRandomAlgue() {
		Random r = new Random();
		int index = r.nextInt(this.algues.size());
		return this.algues.get(index);
	}

	public void fishEating() {
		for (Fish fish: this.fish) {
			if (fish.getPV() <= 5) {
				if (fish instanceof CarnivorFish) {
					fish.eat(getRandomFish());
				} else if (fish instanceof HerbivorFish) {
					fish.eat(getRandomAlgue());
				} else {
					throw new RuntimeException("this should not happen");
				}
			}
		}
	}

	public void update() {
		this.removeDeadAlgues();
		this.removeDeadFish();
		this.updateAlgue();
		this.updateFish();
		this.fishBirth();
		this.diviseAlgue();
		this.fishEating();
		this.show();
		this.tours += 1;


	}

}


/*
match e:
	case 7 : 
*/

/*

enum A {
	a(String),
	b(String),
	c(String)
}

let kk = A::a("hello world");
match kk {
	A(i) => println!(i)
}

*/