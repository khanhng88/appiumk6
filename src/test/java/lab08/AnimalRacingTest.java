package lab08;

import java.util.ArrayList;
import java.util.List;

public class AnimalRacingTest {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Tiger());
        animals.add(new Horse());
        animals.add(new Dog());
        for (Animal animal : animals) {
            System.out.println(animal.getClass().getSimpleName() + " and speed : " + animal.getSpeed());
        }
        Animal winner = getWinner(animals);
        System.out.println("The winner is : " + winner.getClass().getSimpleName() + " with speed : " + winner.getSpeed());

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
}
