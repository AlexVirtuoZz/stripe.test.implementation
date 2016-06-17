package entities;

import org.junit.Test;

/**
 * A class to test PaymentOptionsCreator main functions
 */
public class PaymentOptionsCreatorTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullConstructor(){
        new PaymentOptionsCreator(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAmount(){
        new PaymentOptionsCreator("source").setAmount(-10);
    }

}
