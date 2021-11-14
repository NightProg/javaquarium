package Javaquarium;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.FileReader;


public class Aquarium {
	private List<Fish> fishes;
	private List<Algue> algues;
	private int tours = 0;
	public static final int FISH_MAX = 100;
	private History history = new History();

	public Aquarium() {
		this.fishes = new ArrayList<>();
		this.algues = new ArrayList<>();
	}

	public static Aquarium from_file(String file) throws IOException {
		Aquarium a = new Aquarium();
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		String s;
		if (fileReader.readLine().equals("fish")) {
			while ((s = fileReader.readLine()) != null) {
				if (s.equals("algue")) {
					break;
				}
				String[] split_s = s.split(",");
				if (split_s.length != 5) {
					continue;
				}

				String name = split_s[0];
				int pv = Integer.parseInt(split_s[1]);
				Sexe sexe = (split_s[2].equals("FEMELLE")) ? Sexe.FEMELLE : Sexe.MALE;
				int age = Integer.parseInt(split_s[3]);
				String className = split_s[4];
				Fish f;
				switch (className) {
					case "class Javaquarium.Sole" : f = new Sole(name, sexe, age);break;
					case "class Javaquarium.Thon" : f = new Thon(name, sexe, age);break;
					case "class Javaquarium.Merou": f = new Merou(name, sexe, age);break;
					case "class Javaquarium.Carpe":  f = new Carpe(name, sexe, age);break;
					case "class Javaquarium.Bar" : f = new Bar(name, sexe, age);break;
					case "class Javaquarium.PoissonClown": f = new PoissonClown(name, sexe, age);break;


					default : throw new IllegalStateException("Unexpected value: " + className);
				}
				f.setPV(pv);
				a.addFish(f);
			}
		}
		return a;
	}

	public void addAlgue(Algue a) {
		this.algues.add(a);
		history.addAction(ActionType.ADD_ALGUE, String.format("aquarium add algue %S at %d",  a.toString(), this.tours), this.tours);
	}

	public void addFish(Fish p) {
		this.fishes.add(p);
		history.addAction(ActionType.ADD_FISH, String.format("aquarium add fish %s at tour %d", p.toString(), this.tours), this.tours);
	}

	public void removeDeadFish() {
		List<Fish> fish_dead = this.fishes.stream().filter(p ->  p.isDead).collect(Collectors.toList());
		for (Fish fish: fish_dead) {
			history.addAction(ActionType.DELETE_FISH, String.format("aquarium delete dead fish %s at tour %d",
					fish.toString(),
					this.tours
			), this.tours);
		}
		this.fishes.removeAll(fish_dead);
	}

	public void removeDeadAlgues() {
		List<Algue> algue_dead = this.algues.stream().filter(p ->  p.isDead).collect(Collectors.toList());
		for (Algue algue: algue_dead) {
			history.addAction(ActionType.DELETE_ALGUE, String.format("aquarium delete dead algue %s at %d",
					algue.toString(),
					this.tours
			), this.tours);
		}
		this.algues.removeAll(algue_dead);
	}

	public void showFish() {
		for (Fish e : this.fishes) {
			System.out.println("\t- " + e.name + "(age: " + e.age + ", pv: " + e.pv + ", sexe: " + e.sexe + " specie: " + e.getClass()  + " )");
		}
	}

	public void showAlgues() {
		for (Algue e : this.algues) {
			System.out.println("\t- (age: " + e.age + ", pv: " + e.pv + " )");
		}
	}

	public void removeFish(Fish fish) {
		this.fishes.remove(fish);
		history.addAction(ActionType.DELETE_FISH, String.format("remove fish %s at tours %d", fish, tours), tours);


	}

	public void diviseAlgue() {
		List<Algue> list_algue = new ArrayList<>();
		for (Algue algue : this.algues) {
			Algue children = algue.divise();
			if (children != null) {
				list_algue.add(children);
				history.addAction(ActionType.DIVISE_ALGUE, String.format("divise algue for two algue: %s and %s at %d", algue.toString(), children.toString(), this.tours), this.tours);
			}
		}
		this.algues.addAll(list_algue);
	}

	public void updateAlgue() {
		for (Algue algue: this.algues) {
			algue.heal(1);
			algue.old(1);
			history.addAction(ActionType.OLD_ALGUE, String.format("old algue %s at %d", algue.toString(), this.tours), this.tours);
			history.addAction(ActionType.HEAL_ALGUE, String.format("heal algue of 1 : %s at %d", algue.toString(), this.tours), this.tours);

		}
	}

	public void updateFish() {
		for (Fish fish: this.fishes) {
			fish.update();
			history.addAction(ActionType.OLD_FISH, String.format("old fish %s at %d", fish.toString(), this.tours), this.tours);
			history.addAction(ActionType.HURT_FISH, String.format("hurt fish of 1 : %s at %d", fish.toString(), this.tours), this.tours);
		}
		this.fishes.removeIf(fish -> fish.age >= 20);
	}

	public boolean checkNumFish() {
		return Aquarium.FISH_MAX > this.fishes.size();
	}

	public void removeExcessFish() {
		if (! checkNumFish()) {
			history.addAction(ActionType.DELETE_FISH, String.format("remove excess fish %s at tours %d", this.fishes.get(this.fishes.size() - 1), tours), tours);
			this.fishes.remove(this.fishes.size() - 1);
			removeExcessFish();
		}
	}

	public void fishBirth() {


		List<Fish> children = new ArrayList<>();
		for (Fish fish : this.fishes) {
			Fish auth = getRandomFish();
			if (fish.wantHaveChild(auth)) {
				Fish s = fish.giveBirth();
				System.out.println(fish.getName() + " + " + auth.getName() + " => " + s.getName());
				history.addAction(ActionType.GIVE_BIRTH, String.format(" fish birth %s at tours %d", s, tours), tours);
				children.add(s);

			}
		}
		this.fishes.addAll(children);
	}



	public void deleteAlgueVeryOld() {
		this.algues.forEach(f -> {
			if (f.getAge() > 15)
				history.addAction(ActionType.DELETE_FISH, String.format("delete fish %s at %d", f.toString(), this.tours), this.tours);
		});
		this.algues = this.algues.stream().filter(e -> e.age < 15).collect(Collectors.toList());
	}

	public void show() {
		System.out.println("==== poisson ====");
		showFish();
		System.out.println("==== algue ====");
		showAlgues();
	}

	public Fish getRandomFish() {
		Random r = new Random();
		int index = r.nextInt(this.fishes.size());
		return (index > 0) ? this.fishes.get(index) : null;
	}

	public Algue getRandomAlgue() {
		Random r = new Random();
		if (this.algues.size() == 0) {
			return null;
		}
		int index = r.nextInt(this.algues.size());
		return this.algues.get(index);
	}

	public void fishEating() {
		for (Fish fish: this.fishes) {
			if (fish.getPV() <= 5) {
				if (fish instanceof CarnivorFish) {
					Fish f = getRandomFish();
					if (f != null) {
						if (fish.eat(f)) {
							history.addAction(ActionType.EAT_FISH, String.format("%s eat fish %s at tours %d", fish, f, tours), tours);
						}
					}
				} else if (fish instanceof HerbivorFish) {
					Algue a = getRandomAlgue();
					if (a != null) {
						history.addAction(ActionType.EAT_ALGUE, String.format("fish %s eat %s at %d", fish, a, this.tours), this.tours);
						fish.eat(a);
					}
				} else {
					throw new RuntimeException("this should not happen");
				}
			}
		}
	}

	public void save(String filename) throws IOException {
		FileWriter file = new FileWriter(filename);
		file.append("fish\n");
		for (Fish fish: this.fishes) {
			file.append(String.join(",", fish.getName(), String.valueOf(fish.getPV()), fish.getSexe().toString(), String.valueOf(fish.getAge()),fish.getClass().toString()));
			file.append("\n");
		}
		file.append("algue\n");
		for (Algue a: this.algues) {
			file.append(String.join(",", String.valueOf(a.getAge()), String.valueOf(a.getPV())));
			file.append("\n");
		}
		file.close();
	}
	public void showHistory() {
		for (Action a : history.getListAction()) {
			System.out.printf("(%s) %s at %d\n", a.getActionType(), a.getMsg(), a.getIndicator());
		}
	}

	public void showHistoryFromIndicator(int tour) {
		for (Action a : history.getActionFromIndicator(tour)) {
			System.out.printf("(%s) %s at %d\n", a.getActionType(), a.getMsg(), a.getIndicator());
		}
	}
	public void update() throws IOException {
		System.out.println("=== tours " + this.tours + " ===");
		this.removeExcessFish();
		this.removeDeadAlgues();
		this.removeDeadFish();
		this.updateAlgue();
		this.updateFish();
		this.fishBirth();

		this.deleteAlgueVeryOld();
		this.diviseAlgue();
		this.fishEating();
		this.show();
		this.tours += 1;
		if (this.tours == 20) {
			this.save("aquarium.csv");
		}


	}

}

