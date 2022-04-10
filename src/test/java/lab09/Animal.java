package lab09;

import lab08.Dog;
import lab08.Horse;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class Animal {
    private String name;
    private int speed;
    private boolean flyable;

    public int getSpeed() {
        return speed;
    }

    public Animal(AnimalBuilder animalBuilder) {
        this.name = animalBuilder.name;
        this.speed = randomSpeedValue(animalBuilder.speed);
        this.flyable = animalBuilder.flyable;
    }

    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new AnimalBuilder().withName("Lion").withSpeed(100).build());
        animals.add(new AnimalBuilder().withName("Snake").withSpeed(50).build());
        animals.add(new AnimalBuilder().withName("Bird").withSpeed(70).withWings(true).build());
        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
        System.out.println("The winner is " + getWinner(animals));
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", flyable=" + flyable +
                '}';
    }

    private static Animal getWinner(List<Animal> animalList) {
        if(animalList.isEmpty()) {
            throw new IllegalArgumentException("Animal list is empty.");
        }

        if(animalList.size()==1) {
            return animalList.get(0);
        }

        Animal winner = animalList.get(0);
        for (Animal animal : animalList) {
            if(animal.getSpeed()> winner.getSpeed()){
                winner = animal;
            }
        }
        return winner;

    }

    public int randomSpeedValue(int speed) {
        return new SecureRandom().nextInt(speed);
    }

    public static class AnimalBuilder {
        private String name;
        private int speed;
        private boolean flyable;

        public AnimalBuilder() {
        }

        public AnimalBuilder withWings(boolean flyable) {
            this.flyable = flyable;
            return this;
        }

        public AnimalBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AnimalBuilder withSpeed(int speed) {
            this.speed = speed;
            return this;
        }

        public Animal build() {
            Animal animal = new Animal(this);
            return animal;
        }
    }

}

