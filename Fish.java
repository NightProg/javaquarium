package Javaquarium;

public abstract class Fish {
    protected String name;
    protected Sexe sexe;
    protected int pv = 10;
    protected int age = 1;
    public boolean isDead = false;



    public Fish(String name, Sexe sexe) {
        this.name = name;
        this.sexe = sexe;
    }

    public Fish(String name, Sexe sexe, int age) {
        this.name = name;
        this.sexe = sexe;
        this.age = age;
    }


    public int getAge() {
        return this.age;
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
    protected void setPV(int pv) {
        this.pv = pv;
    }



    protected void hurt(int n) {
        if (this.pv - n < 0) {
            this.pv = 0;
            this.isDead = true;
        } else {
            this.pv = this.pv - n;
        }
    }

    protected void old(int year) {
        this.age += year;
    }

    protected void heal(int pv) {
        this.pv += pv;
    }



    public boolean wantHaveChild(Fish fish) {
        if (fish == null) {
            return false;
        }
        return (this.pv > 5 && this.getClass().equals(fish.getClass()) && this.sexe != fish.getSexe());
    }

    protected void update() {
        this.hurt(1);
        this.old(1);
    }

    public boolean eat(Fish f) {return true;}
    public boolean eat(Algue a) {return true;}

    @Override
    public String toString() {
        return String.format(
                "(name: %s, pv: %d, age: %d, specie: %s, sexe: %s",
                this.name,
                this.pv,
                this.age,
                this.getClass(),
                this.sexe);
    }


    public abstract Fish giveBirth();



}







