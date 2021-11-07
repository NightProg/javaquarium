package Javaquarium;

public abstract class Fish {
    protected String name;
    private Specie specie;
    protected Sexe sexe = Sexe.MALE;
    protected int pv = 10;
    protected int age = 1;
    public boolean isDead = false;

    public Fish(String name, Specie specie) {
        this.name = name;
        this.specie = specie;
    }

    public Fish(String name, Specie specie, Sexe sexe) {
        this.name = name;
        this.sexe = sexe;
        this.specie = specie;
    }

    public Fish(String name, Specie specie, Sexe sexe, int age) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
        this.specie = specie;
    }

    public int getAge() {
        return this.age;
    }

    public Specie getSpecie() {
        return this.specie;
    }

    public int getPV() {
        return this.pv;
    }

    public String getName() {
        return this.name;
    }

    public Sexe getSexe() {
        return this.sexe;
    }



    public void hurt(int n) {
        if (this.pv - n < 0) {
            this.pv = 0;
            this.isDead = true;
        } else {
            this.pv = this.pv - n;
        }
    }

    public void old(int year) {
        this.age += year;
    }

    public void soigner(int pv) {
        this.pv += pv;
    }

    public abstract boolean eat(Fish fish);

    public abstract boolean eat(Algue algue);

    public boolean wantHaveChild(Fish fish) {
        return (this.pv > 5 && this.specie == fish.getSpecie() && this.sexe != fish.getSexe());
    }

    abstract Fish giveBirth();
}







