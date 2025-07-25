// package patterns.decorator;

interface Beverage {
    float getCost();
    String getDescription();
}

interface Coffee extends Beverage {
    boolean isHot();
}

interface Tea extends Beverage {
    abstract String getPowderType();
}

interface Condiments extends Beverage {
    Beverage getBeverage();
}

class Latte implements Coffee {
    boolean isHot;
    int cost;
    String description;
    
    public Latte() {
        this.isHot = true;
        this.cost = 10;
        this.description = "Latte coffee";
    }

    public Latte(boolean isHot, int cost, String description) {
        this.isHot = isHot;
        this.cost = cost;
        this.description = description;
    }

    @Override
    public boolean isHot() {
        return this.isHot;
    }

    @Override
    public float getCost() {
        return this.cost;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}

class Frappe implements  Coffee {
    
    boolean isHot;
    int cost;
    String description;

    public Frappe(boolean isHot, int cost, String description) {
        this.isHot = isHot;
        this.cost = cost;
        this.description = description;
    }

    public Frappe() {
    }
    @Override
    public boolean isHot() {
        return this.isHot;
    }

    @Override
    public float getCost() {
        return this.cost;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

}

class Chai implements Tea {
    int cost;
    String description, powderType;

    public Chai() {
        this.cost = 12;
        this.description = "This is a cup of tea";
        this.powderType = "golden";
    }

    public Chai(int cost, String description, String powderType) {
        this.cost = cost;
        this.description = description;
        this.powderType = powderType;
    }

    @Override
    public String getPowderType() {
        return this.powderType;
    }

    @Override
    public float getCost() {
        return this.cost;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}

class Mocha implements Condiments {
    Beverage beverage;
    float cost;
    
    public Mocha(Beverage beverage) {
        this.cost = (float)0.5;
        this.beverage = beverage;
    }

    @Override
    public Beverage getBeverage() {
        return this.beverage;
    }

    @Override
    public float getCost() {
        return this.cost + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return "mocha, " + beverage.getDescription();
    }

}

class Whip implements Condiments {
    Beverage beverage;
    float cost;
    
    public Whip(Beverage beverage) {
        this.cost = (float)0.5;
        this.beverage = beverage;
    }

    @Override
    public Beverage getBeverage() {
        return this.beverage;
    }

    @Override
    public float getCost() {
        return this.cost + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return "Whip, " + beverage.getDescription();
    }

}

public class Decorator_pattern {
    public static void main(String[] args) {
        Beverage drink = new Latte();
        System.out.println(drink.getCost() + "\t" + drink.getDescription()); 
        drink = new Mocha(drink);
        System.out.println(drink.getCost() + "\t" + drink.getDescription());
        drink = new Whip(drink);
        System.out.println(drink.getCost() + "\t" + drink.getDescription()); 
        drink = new Mocha(drink);
        System.out.println(drink.getCost() + "\t" + drink.getDescription()); 

        Beverage drink1 = new Frappe();
        System.out.println(drink1.getCost() + "\t" + drink1.getDescription()); 

        Beverage drink2 = new Chai();
        System.out.println(drink2.getCost() + "\t" + drink2.getDescription()); 
    }
}