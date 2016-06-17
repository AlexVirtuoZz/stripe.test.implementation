package entities;

import com.stripe.exception.*;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;

import java.util.Map;

/**
 * A class to create and execute payments
 */
public class PaymentCreator {
    /**
     * idempotencyOptions - idempotencyOptions object to provide idempotency
     * paymentOptionsCreator - an object to set payment details
     */
    private IdempotencyOptions idempotencyOptions;
    private PaymentOptionsCreator paymentOptionsCreator;

    /**
     * Payment Creator constructor
     * @param idempotencyOptions is payment creator's idempotency options
     * @param paymentOptionsCreator is payment options creator
     */
    public PaymentCreator(IdempotencyOptions idempotencyOptions, PaymentOptionsCreator paymentOptionsCreator) {
        if (idempotencyOptions == null || paymentOptionsCreator == null)
            throw new IllegalArgumentException("Payment or idempotency options is null");
        this.idempotencyOptions = idempotencyOptions;
        this.paymentOptionsCreator = paymentOptionsCreator;
    }

    /**
     * Main method to execute payments
     * To execute payment it take payment's options and idempotency options
     * Payment is executed with create method
     * @see Charge#create(Map, RequestOptions)
     * @exception AuthenticationException if api key is incorrect or other request problems
     * @exception InvalidRequestException if idempotent key is incorrect or is already used
     * @exception APIConnectionException if problems occur while connecting server
     * @exception CardException if problems occur with card data
     * @exception APIException if API is currently unavailable
     */
    public void pay() {
        try {

            Charge.create(paymentOptionsCreator.setPaymentOptions(), idempotencyOptions.getOptions());

        } catch (AuthenticationException e) {
            System.out.println("Failed to authenticate\n");
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        } catch (InvalidRequestException e) {
            System.out.println("Problems occur while requesting\n");
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        } catch (APIConnectionException e) {
            System.out.println("Problems occur while connection. Check your internet connection\n");
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        } catch (CardException e) {
            System.out.println("Problems with card data\n");
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        } catch (APIException e) {
            System.out.println("API is unavailable now. Try once again later\n");
            System.out.println("Message is: " + e.getMessage());
            e.printStackTrace();
        }

    }

}
