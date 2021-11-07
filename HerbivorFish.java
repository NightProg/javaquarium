package Javaquarium;

import java.util.Random;

public class HerbivorFish extends Fish {

    public HerbivorFish(String name, HerbivorSpecie specie) {
        super(name, specie);
    }

    public HerbivorFish(String name, HerbivorSpecie specie, Sexe sexe) {
        super(name, specie, sexe);
    }

    @Override
    public boolean eat(Fish fish) {
        throw new RuntimeException("this should not happen");
    }

    @Override
    public boolean eat(Algue algue) {
        if (algue.isDead) {
            return false;
        }
        algue.hurt(2);
        this.pv += 3;
        return true;
    }

    @Override
    Fish giveBirth() {
        return new HerbivorFish(this.getName() + " Jr", (HerbivorSpecie) this.getSpecie(), Sexe.getRandom());
    }
}
