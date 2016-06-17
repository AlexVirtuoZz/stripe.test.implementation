import com.stripe.Stripe;
import entities.IdempotencyOptions;
import entities.PaymentCreator;
import entities.PaymentOptionsCreator;

/**
 * Main class to run application
 * String.apiKey is declared initialized
 * IdempotencyOptions and PaymentOptionsCreator are declared and initialized with appropriate keys
 * PaymentCreator is declared and initialized with appropriate objects
 * PaymentCreator is executed with its pay method
 * @see PaymentCreator#pay()
 */
public class Main {
    public static void main(String[] args) {
        /**
         * apiKey - key to define specified account
         */
        Stripe.apiKey = "sk_test_Pdd4HqPtfVbsjchdx1fjZnSz"; //Insert api key here

        //Initializing IdempotencyOptions and PaymentCreator objects
        IdempotencyOptions idempotencyOptions = new IdempotencyOptions("kt9Ah6HsaEuOgpmj"); // Insert idempotent key here
        PaymentOptionsCreator options = new PaymentOptionsCreator("tok_18N8c3Gsh0tgu0ik6KcGO0JA"); //Insert source (token) here

        //Set options amount and description
        options.setAmount(50000).setDescription("Alexander Bovkun payment");

        //Initialize and execute PaymentCreator object
        PaymentCreator paymentCreator = new PaymentCreator(idempotencyOptions, options);
        paymentCreator.pay();

    }
}
