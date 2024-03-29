package Javaquarium;

public class Algue {
	protected int age;
	protected int pv = 10;
	protected boolean isDead = false;
	public Algue() {}
	public Algue(int age) {
		this.age = age;
	}

	public int getAge() {
		return this.age;
	}

	public int getPV() {
		return this.pv;
	}
 
	protected void old(int year) {
		this.age += year;
	}

	protected void hurt(int degat) {
		if (this.pv - degat < 0) {
			this.isDead = true;
		} else {
			this.pv -= degat;
		}
	}

	protected void heal(int vie) {
		if (! this.isDead) {
			this.pv += Math.max(vie, 0);
		}
	}
	
	protected void setAge(int age) {
		this.age = age;
	}

	protected void setPV(int pv) {
		this.pv = pv;
	}

	public boolean canDivise() {
		return this.pv >= 10;
	}

	public Algue divise() {
		if (canDivise()) {
			Algue children = new Algue();
			children.setPV(Math.round(this.pv / 2F));
			this.pv = Math.round(this.pv / 2F);
			return children;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		return String.format("(pv: %d, age: %d)", this.pv, this.age);
	}
}