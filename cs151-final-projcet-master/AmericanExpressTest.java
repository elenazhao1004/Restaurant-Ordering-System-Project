package cs151hw4ry;

import static org.junit.Assert.*;

import org.junit.Test;

public class AmericanExpressTest {

    @Test
    public void testIsAmericanExpress_True() {
        assertTrue(AmericanExpress.isAmericanExpress("341234567890123"));
    }

    @Test
    public void testIsAmericanExpress_False() {
        assertFalse(AmericanExpress.isAmericanExpress("441234567890123"));
    }

}
