package integration.io.github.jpdev.asaassdk;

import io.github.jpdev.asaassdk.utils.Money;

import java.math.BigDecimal;
import java.util.Random;

public class CustomMockUtils {

    public static BigDecimal randomValue() {
        int value = new Random().nextInt(100) + 1;
        return Money.create(value);
    }
}
