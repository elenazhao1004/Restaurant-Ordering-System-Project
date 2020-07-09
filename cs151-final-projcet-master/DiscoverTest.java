package cs151hw4ry;

import static org.junit.Assert.*;

import org.junit.Test;

public class DiscoverTest {

    @Test
    public void testIsDiscover_True() {
        assertTrue(Discover.isDiscover("6011123456789012"));
    }

    @Test
    public void testIsDiscover_False() {
        assertFalse(Discover.isDiscover("1111123456789012"));
    }

}
