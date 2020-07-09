package cs151hw4ry;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class ReadFileControllerTest {

    @Test
    public void test() throws Exception {
        ReadFileController instance = new ReadFileController();
        instance.readMenu("test_menu.txt");
        String[] expectedFood = {"fooda", "foodb", "foodc"};
        Double[] expectedPrice = {1.0, 2.0, 3.0};
        assertArrayEquals(expectedFood, 
                instance.getfoodName().toArray());
        assertArrayEquals(expectedPrice, 
                instance.getfoodPrice().toArray());
        
    }

}
