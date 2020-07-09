package cs151hw4ry;

import static org.junit.Assert.*;

import org.junit.Test;

public class ReceiptTest {
    
    class MockCreditCard extends CreditCard {
        public MockCreditCard(String creditCardNum) {
            super(creditCardNum);
        }

        public String getType() {
            return "MockCreditCard";
        }
    }

    @Test
    public void testGetTotal() {
        Receipt instance = new Receipt();
        instance.addItem("fooda", 1.0);
        instance.addItem("foodb", 2.0);
        instance.addItem("foodc", 4.0);
        assertEquals(7.0, instance.getTotal(), 0.001);
    }
    
    @Test
    public void testGetReceiptString() {
        Receipt instance = new Receipt();
        instance.addItem("fooda", 1.0);
        instance.addItem("foodb", 2.0);
        instance.addItem("foodc", 4.0);
        instance.setCreditCard(new MockCreditCard("123"));
        assertEquals("fooda 1.0\nfoodb 2.0\nfoodc 4.0\nyour total is: 7.0\nyour payment card is: MockCreditCard\n", 
                instance.getReceiptString());
    }

}
