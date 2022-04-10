package lab08;

import java.security.SecureRandom;

public class Horse extends Animal{
    public Horse() {
        this.speed = randomSpeedValue();
    }

    @Override
    public int randomSpeedValue() {
        return new SecureRandom().nextInt(75);
    }
}
