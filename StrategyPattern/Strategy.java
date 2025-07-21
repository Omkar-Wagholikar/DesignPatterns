interface Flyable {
    public void fly();
}

interface Quackable {
    public void quack();
}

abstract class Bird {
    protected String species;
    public String getSpecies() {
        return this.species;
    };
    public void setSpecies(String species) {
        this.species = species;
    }
}

class NaturalQuack implements Quackable{
    @Override
    public void quack() {
        System.out.println("Natural Quack");
    }
}
class RecodedQuack implements Quackable{
    @Override
    public void quack() {
        System.out.println("Recorded Quack");
    }
}
class NoQuack implements Quackable{
    @Override
    public void quack() {
        System.out.println("No Quack");
    }
}

class NaturalFly implements  Flyable{
    @Override
    public void fly() {
        System.out.println("Natural Fly");
    }
};

class NoFly implements Flyable{ 
    @Override
    public void  fly() {
        System.out.println("No Fly");
    }
};

abstract class Duck extends Bird{
    Flyable flyableConfig;
    Quackable quackConfig;
    String name;

    Duck(Flyable flyableConfig, Quackable quackConfig, String name) {
        this.flyableConfig = flyableConfig;
        this.quackConfig = quackConfig;
        this.name = name;
        super.setSpecies("Duck");
    }

    public void info() {
        System.out.println(name);
        this.flyableConfig.fly();
        this.quackConfig.quack();
    }
}


class MallardDuck extends Duck {

    public MallardDuck() {
        super(new NaturalFly(), new NaturalQuack(),"I am a Mallard Duck");
    }
        
}

class RubberDuck extends Duck {

    public RubberDuck() {
        super(
            new NoFly(),
            new RecodedQuack(),
        "I am a Rubber Duck"
        );
    }
        
}

class DecoyDuck extends Duck {

    public DecoyDuck() {
        super(
            new NoFly(),
            new NoQuack(),
        "I am a Decoy Duck"
        );
        
    }
        
}

public class Strategy {
    public static void main(String[] args) {
        Duck duck = new MallardDuck();
        duck.info();
        duck = new RubberDuck();
        duck.info();
        duck = new DecoyDuck();
        duck.info();
        System.out.println(duck.getSpecies());
    }    
}