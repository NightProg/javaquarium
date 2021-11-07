package Javaquarium;

public class Algue {
	public int age = 1;
	public int pv = 10;
	public boolean estMort = false;
	public Algue() {}
	public Algue(int age) {
		this.age = age;
	}
	public Algue(int age, int pv) {
		this.age = age;
		this.pv = pv;
	}

	public int getAge() {
		return this.age;
	}

	public int getPV() {
		return this.pv;
	}
 
	public void old(int year) {
		this.age += year;
	}

	public void subir(int degat) {
		if (degat > 0) {
			this.pv -= degat;
		} else {
			this.pv = 0;
			this.estMort = true;
		}
	}

	public void soigner(int vie) {
		if (! this.estMort) {
			this.pv += (vie > 0) ? vie : 0;
		}
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	public void setPV(int pv) {
		this.pv = pv;
	}
}