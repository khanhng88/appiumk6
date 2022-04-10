package lab08;

import java.security.SecureRandom;

public class Dog extends Animal{
    public Dog() {
        this.speed = randomSpeedValue();
    }

    @Override
    public int randomSpeedValue() {
        return new SecureRandom().nextInt(60);
    }
}
