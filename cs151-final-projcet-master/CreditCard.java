/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

import java.io.Serializable;
import java.util.Objects;

/**
 * This is the abstract class of credit cards.
 *
 * @author Jing Zhao
 */
public abstract class CreditCard implements Serializable {
    /**
     * This means the credit card number.
     */
    String creditCardNum;

    /**
     * This means the credit card type.
     */
    String creditCardTpye;

    /**
     * Constructor.
     *
     * @param creditCardNum
     *      the credit card number.
     */
    public CreditCard(String creditCardNum) {
        this.creditCardNum = creditCardNum;
    }

    /**
     * Get the credit card type.
     *
     * @return
     *      the credit card type.
     */
    public String getType() {
        return creditCardTpye;
    }

    /**
     * Get the credit card number.
     *
     * @return
     *      the credit card number.
     */
    public String getCreditCardNum() {
        return creditCardNum;
    }

    /**
     * Check if the this object equals to another object.
     *
     * @param o
     *      the other object.
     * @return
     *      true or false.
     */
    @Override
    public boolean equals(Object o) {

        // If the object is compared with itself then return true
        if (o == this) {
            return true;
        }

        /* Check if o is an instance of CreditCard or not
          "null instanceof [type]" also returns false */
        if (!(o instanceof CreditCard)) {
            return false;
        }

        // typecast o to CreditCard so that we can compare data members
        CreditCard c = (CreditCard) o;

        if (creditCardNum == null && c.creditCardNum == null) {
            return true;
        }

        if (creditCardNum == null || c.creditCardNum == null) {
            return false;
        }

        // Compare the data members and return accordingly
        // Only need to compare credit card number
        return Objects.equals(creditCardNum, c.creditCardNum);
    }

}
