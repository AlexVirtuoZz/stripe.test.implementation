package entities;

import com.stripe.Stripe;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.InvalidRequestException;
import org.junit.Ignore;
import org.junit.Test;

/**
 * A class to test PaymentCreator main functions
 */
public class PaymentCreatorTest {

    /**
     * Test if null constructor param will fail object creation
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullConstructor(){
        IdempotencyOptions testIdempotencyOptions = null;
        PaymentOptionsCreator testPaymentOptionsCreator = new PaymentOptionsCreator("ANY VALUE");

        new PaymentCreator(testIdempotencyOptions, testPaymentOptionsCreator);
    }

    /**
     * Test if null idempotent key will cause an invalid request exception
     */
    @Ignore
    @Test(expected = InvalidRequestException.class)
    public void testPayRequestException(){
        Stripe.apiKey = "sk_test_Pdd4HqPtfVbsjchdx1fjZnSz";
        IdempotencyOptions testIdempotencyOptions = new IdempotencyOptions(null);
        PaymentOptionsCreator testPaymentOptionsCreator = new PaymentOptionsCreator("tok_18N8c3Gsh0tgu0ik6KcGO0JA");
        new PaymentCreator(testIdempotencyOptions, testPaymentOptionsCreator);
    }

    /**
     * Test if null api key will cause an authentication exception
     */
    @Ignore
    @Test(expected = AuthenticationException.class)
    public void testPayAuthenticationException(){
        Stripe.apiKey = null;
        IdempotencyOptions testIdempotencyOptions = new IdempotencyOptions("ANY VALUE");
        PaymentOptionsCreator testPaymentOptionsCreator = new PaymentOptionsCreator("ANY VALUE");
        new PaymentCreator(testIdempotencyOptions, testPaymentOptionsCreator).pay();

    }

}
