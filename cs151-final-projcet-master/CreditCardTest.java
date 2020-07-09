package cs151hw4ry;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

class TestCreditCard extends CreditCard {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public TestCreditCard(String creditCardNum) {
        super(creditCardNum);
    }
    
    public void setCreditCardType(String creditCardType) {
        this.creditCardTpye = creditCardType;
    }
}

public class CreditCardTest {

    @Test
    public void testEqual() {
        TestCreditCard instance = new TestCreditCard("123");
        assertTrue(instance.equals(new TestCreditCard("123")));
    }

    @Test
    public void testEqualSelf() {
        TestCreditCard instance = new TestCreditCard("123");
        assertTrue(instance.equals(instance));
    }

    @Test
    public void testNotEqual() {
        TestCreditCard instance = new TestCreditCard("123");
        assertFalse(instance.equals(new TestCreditCard("1234")));
    }

    @Test
    public void testNotEqualNull() {
        TestCreditCard instance = new TestCreditCard("123");
        assertFalse(instance.equals(null));
    }

    @Test
    public void testNotEqualCreditCardNumNull() {
        TestCreditCard instance = new TestCreditCard(null);
        assertFalse(instance.equals(new TestCreditCard("123")));
        instance = new TestCreditCard("123");
        assertFalse(instance.equals(new TestCreditCard(null)));
    }

    @Test
    public void testSerialization() throws Exception {
        TestCreditCard instance = new TestCreditCard("123");
        instance.setCreditCardType("type1");
        
        //Saving of object in a file 
        FileOutputStream fout = new FileOutputStream(filename); 
        ObjectOutputStream out = new ObjectOutputStream(fout); 
        out.writeObject(instance); 
        out.close(); 
        fout.close(); 
        
        // Reading the object from a file 
        FileInputStream fin = new FileInputStream(filename); 
        ObjectInputStream in = new ObjectInputStream(fin); 
        TestCreditCard result = (TestCreditCard)in.readObject(); 
        in.close(); 
        fin.close(); 
        
        assertEquals(instance.getCreditCardNum(), result.getCreditCardNum());
        assertEquals(instance.getType(), result.getType());
    }
    
    private static String filename = "serialization_test.txt";

}
