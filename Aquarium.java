package Javaquarium;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Aquarium {
	public List<Poisson> poisson;
	public List<Algue> algue;

	public Aquarium() {
		this.poisson = new ArrayList<Poisson>();
		this.algue = new ArrayList<Algue>();
	}

	public void ajouteAlgue(Algue a) {
		this.algue.add(a);
	}

	public void ajoutePoisson(Poisson p) {
		this.poisson.add(p);
	}
	public void checkPoisson() {
		for(int i = 0; i < this.poisson.size(); i++) {
			if (this.poisson.get(i).estMort) {
				this.poisson.remove(i);
			}
		}
	}

	public void checkAlgue() {
		for(int i = 0; i < this.algue.size(); i++) {
			if (this.algue.get(i).estMort) {
				this.algue.remove(i);
			}
		}
	}
	public void showPoisson() {
		for (Poisson e : this.poisson) {
			System.out.println("\t- " + e.nom + "(age: " + e.age + ", pv: " + e.pv + ", sexe: " + e.sexe + " )");
		}
	}

	public void showAlgue() {

		System.out.println("le nombre d'algue: " + this.algue.size());
	}

	public void removePoisson(int index) {
		this.poisson.remove(index);
	}

	public void updateAlgue() {
		for (Algue a: this.algue) {
			a.soigner(1);
		}
	}

	public void updatePoisson() {
		for (Poisson p: this.poisson) {
			p.enlevePV(1);
		}
	}

	public void show() {
		System.out.println("==== poisson ====");
		showPoisson();
		System.out.println("==== algue ====");
		showAlgue();
	}

	public void update() {
		this.checkAlgue();
		this.checkPoisson();
		Random r = new Random();
		int index = r.nextInt(this.poisson.size());
		this.removePoisson(index);
		this.updateAlgue();
		this.updatePoisson();
		this.show();

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