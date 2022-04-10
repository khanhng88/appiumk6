package lab08;

import java.security.SecureRandom;

public class Tiger extends Animal{
    public Tiger() {
        this.speed = randomSpeedValue();
    }

    @Override
    public int randomSpeedValue() {
        return new SecureRandom().nextInt(100);

    }


}
