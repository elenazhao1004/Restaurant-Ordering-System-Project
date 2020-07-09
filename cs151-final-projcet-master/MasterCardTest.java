package cs151hw4ry;

import static org.junit.Assert.*;

import org.junit.Test;

public class MasterCardTest {

    @Test
    public void testIsMasterCard_True() {
        assertTrue(MasterCard.isMasterCard("5112345678901234"));
    }

    @Test
    public void testIsMasterCard_False() {
        assertFalse(MasterCard.isMasterCard("5612345678901234"));
    }

}
