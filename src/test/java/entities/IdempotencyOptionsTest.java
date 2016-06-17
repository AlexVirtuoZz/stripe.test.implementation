package entities;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * A class to test IdempotencyOptions main functions
 */
public class IdempotencyOptionsTest {
    /**
     * Test if null key won't create options object
     */
    @Test
    public void testNullConstructor(){
        IdempotencyOptions test = new IdempotencyOptions(null);
        assertNull(test.getOptions());
    }

}
