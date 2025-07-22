import java.util.ArrayList;
import java.util.List;

interface DisplayInterface {
    void display();
}

interface ObserverInterface {
    void update();
}

interface SubjectInterface {
    void registerObserver(ObserverInterface obs);
    void removeObservers(ObserverInterface obs);
    void updateObservers();

    float getTemperature();
    void setTemperature(float temperature);

    float getHumidity();
    void setHumidity(float humidity);
}

class WeatherStation implements SubjectInterface {
    private final List<ObserverInterface> observers;
    float temperature, humidity;

    public WeatherStation(float temperature, float humidity) {
        this.observers = new ArrayList<>();
        this.temperature = temperature;
        this.humidity = humidity;
    } 
    
    @Override
    public void registerObserver(ObserverInterface obs) {
        System.out.println("Registered new observer");
        observers.add(obs);
    }

    @Override
    public void removeObservers(ObserverInterface obs) {
        observers.remove(obs);
    }

    @Override
    public void updateObservers() {
        System.out.println("Updating observers");
        for(ObserverInterface o: observers) o.update();
    }

    @Override
    public float getTemperature() {
        return this.temperature;
    }

    @Override
    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public float getHumidity() {
        return this.humidity;
    }

    @Override
    public void setHumidity(float humidity) {
        
        this.humidity = humidity;
    }

}


class CurrentConditionsDisplay implements  ObserverInterface, DisplayInterface {
    SubjectInterface station;
    float temperature, humidity;

    public CurrentConditionsDisplay(WeatherStation station) {
        this.station = station;
        station.registerObserver(this); // Self-registration
        System.out.println("Created and registered new display");
    }

    @Override
    public void update() {
        this.temperature = station.getTemperature();
        this.humidity = station.getHumidity();
        System.out.println("Default display updated information");
    }

    @Override
    public void display() {
        String res = "Current Wather report: \nTemperature: " + this.temperature + " Humidity: " + this.humidity;
        System.out.println("Default Display Display");
        System.out.print(res);
    }

}


public class Observer_pattern {

    public static void main(String[] args) {
        WeatherStation station = new WeatherStation(0, 0);
        // However many objects may register then wait for updates from the station
        CurrentConditionsDisplay observer = new CurrentConditionsDisplay(station); 
        CurrentConditionsDisplay observer2 = new CurrentConditionsDisplay(station); 
    

        station.setHumidity(100);
        station.setTemperature(1);

        station.updateObservers();

        observer.display();
        observer2.display();
    }
}