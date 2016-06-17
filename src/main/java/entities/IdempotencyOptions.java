package entities;

import com.stripe.net.RequestOptions;

/**
 * A class to create idempotency settings
 */
public class IdempotencyOptions {
    /**
     * All necessary parameters
     * idempotentKey - a key to perform an idempotent request
     * options - build options with specified key
     */
    private String idempotentKey;
    private RequestOptions options;

    //Setters and getters

    public void setIdempotentKey(String idempotentKey) {
        this.idempotentKey = idempotentKey;
    }

    public RequestOptions getOptions() {
        return options;
    }

    /**
     * IdempotencyOptions constructor
     * Set idempotentKey
     * build options with specified key
     * @see RequestOptions#builder()
     * @see RequestOptions.RequestOptionsBuilder#build()
     * @param idempotentKey  is specified idempotentKey
     */
    public IdempotencyOptions(String idempotentKey){
        if (idempotentKey == null)
            return;

        this.idempotentKey = idempotentKey;
        options = RequestOptions.builder()
                .setIdempotencyKey(this.idempotentKey)
                .build();
    }

}
