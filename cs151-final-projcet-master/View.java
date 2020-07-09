/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * This class is the main view of the application.
 *
 * @author Jing Zhao
 */
public class View extends JFrame {

    /**
     * Constructor.
     *
     * @param food
     *      the food names.
     * @param price
     *      the prices of the food.
     */
    public View(List<String> food, List<Double> price) {
        this.food = food;
        this.price = price;
    }

    /**
     * Add an item to the order.
     *
     * @param item
     *      the item.
     */
    public void addItemToOrder(String item) {
        if (order.getText().equals(defaultText)) {
            order.setText(null);
        }
        order.append(item + "\n");
    }

    /**
     * Clear the order.
     */
    public void clearAll() {
        order.setText(defaultText);
        receipt.clear();
    }

    /**
     * Create the GUI and show it. For thread safety, this method should be
     * invoked from the event-dispatching thread.
     */
    public void createAndShowGUI() {
        // Create and set up the window.
        JFrame frame = new JFrame("Order System");
        JPanel panel = new JPanel();
        JPanel menu = new JPanel();
        final ArrayList<String> foodList = (ArrayList<String>) this.food;
        final ArrayList<Double> priceList = (ArrayList<Double>) this.price;

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setPreferredSize(new Dimension(800, 400));

        // left hand side
        panel.setLayout(new GridLayout(1, 2));

        // calulate the grid base on number of items
        menu.setLayout(new GridLayout(5, 2));

        for (int i = 0; i < food.size(); i++) {
            final int index = i;
            JButton btn = new JButton(foodList.get(index) + ": $" + priceList.get(index));// Buton
                                                                                          // name
                                                                                          // for
                                                                                          // test
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String buttonText = ((JButton) e.getSource()).getText();
                    addItemToOrder(buttonText);// button should create base on
                                               // the information from ReadFile
                                               // class
                    receipt.addItem(foodList.get(index), priceList.get(index));
                    total.setText("Total: $" + receipt.getTotal());
                }
            });

            menu.add(btn);
        }

        panel.add(menu);

        // right hand side
        JPanel rightSide = new JPanel();
        // rightSide.setLayout(new GridBagLayout());

        order = new JTextArea(defaultText, 20, 30);
        order.setEditable(false);
        total = new JTextField("Total: $0.00", 20);
        total.setEditable(false);

        JTextField ccNumber = new JTextField("Enter CC#", 20);

        // group of buttons
        JPanel buttons = new JPanel();
        JButton confirmOrder = new JButton("Place Order");
        JButton cancelOrder = new JButton("Cancel Order");
        cancelOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearAll();
            }

        });
        confirmOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                receipt.setCreditCard(CreditCardFactory.createCard(ccNumber.getText()));
                JOptionPane.showMessageDialog(null, receipt.getReceiptString());
            }

        });

        buttons.add(confirmOrder);
        buttons.add(cancelOrder);

        rightSide.add(order);
        rightSide.add(total);
        rightSide.add(ccNumber);
        rightSide.add(buttons);

        panel.add(rightSide);

        frame.getContentPane().add(panel);

        // Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    private static JTextArea order;
    private static JTextField total;
    private static String defaultText = "Nothing Yet!";
    private List<String> food;
    private List<Double> price;
    private Receipt receipt = new Receipt();
}
