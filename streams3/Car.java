package hr.fer.oop.zi19.streams3;

import java.util.Comparator;
import java.util.List;

public class Car {
    String name;
    CarType type;
    int maxSpeed;
    int power;
    double consumption;
    double price;

    public Car(String name, CarType type, int maxSpeed, int power, double consumption, double price) {
        this.name = name;
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.power = power;
        this.consumption = consumption;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public CarType getType() {
        return type;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPower() {
        return power;
    }

    public double getConsumption() {
        return consumption;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", maxSpeed=" + maxSpeed +
                ", power=" + power +
                ", consumption=" + consumption +
                ", price=" + price +
                '}';
    }

    public static void main(String[] args) {
        List<Car> list = CarCatalog.loadCars();

        //print all cars sorted descending by price
        list.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .forEach(c -> System.out.println(c));

        //print average price of petrol cars (if such exist)
            list.stream()
                    .filter(c -> c.getType() == CarType.PETROL)
                    .mapToDouble(c -> c.getPrice()).average()
                    .ifPresent(avg -> System.out.println(avg));
    }
}
