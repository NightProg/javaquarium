package Javaquarium;

import java.util.Objects;

public class CarnivorFish extends Fish {

    public CarnivorFish(String name, CarnivorSpecie specie) {
        super(name, specie);
    }

    public CarnivorFish(String name, CarnivorSpecie specie, Sexe sexe) {
        super(name, specie, sexe);
    }

    public CarnivorFish(String name, CarnivorSpecie specie, Sexe sexe, int age) {
        super(name, specie, sexe, age);
    }

    @Override
    public boolean eat(Fish e) {
        System.out.println(this.getName() + "(" + this.getSpecie() + ") eat " + e.getName() + "(" + e.getSpecie() + ")");
        if (this.isDead || Objects.equals(getSpecie(), e.getSpecie())) {
            return false;
        }

        e.hurt(4);
        this.pv += 5;
        return true;
    }

    @Override
    public boolean eat(Algue algue) {
        throw new RuntimeException("this should not happen");
    }

    @Override
    Fish giveBirth() {
        return new CarnivorFish(this.getName() + " Jr", (CarnivorSpecie) this.getSpecie(), Sexe.getRandom());
    }


}
