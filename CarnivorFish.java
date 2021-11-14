package Javaquarium;

public abstract class CarnivorFish extends Fish {



    public CarnivorFish(String name, Sexe sexe) {
        super(name, sexe);
    }

    public CarnivorFish(String name, Sexe sexe, int age) {
        super(name, sexe, age);
    }




    @Override
    public boolean eat(Fish e) {
        System.out.println(this.getName() + "(" + this.getClass() + ") eat " + e.getName() + "(" + e.getClass() + ")");
        if (this.isDead || e.getClass().equals(this.getClass())) {
            return false;
        }

        e.hurt(4);
        this.pv += 5;
        return true;
    };
    public abstract Fish giveBirth();


}
/*
System.out.println(this.getName() + "(" + this.getSpecie() + ") eat " + e.getName() + "(" + e.getSpecie() + ")");
        if (this.isDead || Objects.equals(getSpecie(), e.getSpecie())) {
        return false;
        }

        e.hurt(4);
        this.pv += 5;
        return true;

 */

/*
new CarnivorFish(this.getName() + " Jr", Sexe.getRandom());
 */