package entities;

import java.util.HashMap;
import java.util.Map;

/**
 * A class to define payment options
 */
public class PaymentOptionsCreator {
    /**
     * chargeParams - map containing parameters
     * amount - money quantity for payment
     * currency - transfer currency
     * description - transfer description
     * source - card token
     *
     * To use builder pattern all necessary values are set to default (except source)
     * amount = 0
     * currency is usd
     * description is "Example payment"
     */
    private Map<String, Object> chargeParams = new HashMap<String, Object>();
    private int amount = 0;
    private String currency = "usd";
    private String description = "Example payment";
    private String source;


    //Setters using builder pattern and getters

    public PaymentOptionsCreator(String source){
        if (source == null)
            throw new IllegalArgumentException("PaymentOptionsCreator source is null");
        this.source = source;
    }

    public PaymentOptionsCreator setAmount(int amount) {
        if (amount < 0)
            throw new IllegalArgumentException("Amount must be greater then zero");
        this.amount = amount;
        return this;
    }

    public PaymentOptionsCreator setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public PaymentOptionsCreator setDescription(String description) {
        this.description = description;
        return this;
    }

    public PaymentOptionsCreator setSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * Method to set and return options
     * Put all values into options map
     * @return payment options
     */
    public Map<String, Object> setPaymentOptions() {
        chargeParams.put("amount", this.amount);
        chargeParams.put("currency", this.currency);
        chargeParams.put("source", this.source);
        chargeParams.put("description", this.description);
        return chargeParams;
    }
}
