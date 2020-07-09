/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; // The ArrayList library
import java.util.List;
import java.util.Scanner;

/**
 * This class is the controller to read a text file contains the menu.
 *
 * @author Jing Zhao
 */
public class ReadFileController {
    /**
     * The scanner.
     */
    private Scanner input;

    /**
     * The list of food names.
     */
    private List<String> foodName = new ArrayList<>();

    /**
     * The list of food prices.
     */
    private List<Double> foodPrice = new ArrayList<>();

    /**
     * Read the menu from a text file.
     *
     * @param filename
     *      the file name.
     * @throws FileNotFoundException
     */
    public void readMenu(String filename) throws FileNotFoundException {
        try {
            input = new Scanner(new File(filename));

            while (input.hasNextLine()) {
                String str = input.nextLine();
                String[] parts = str.split("\\|");
                foodName.add(parts[0].replaceAll("[^A-Za-z]+", "").trim());
                foodPrice.add(Double.parseDouble(parts[1].trim()));

            }

        } catch (FileNotFoundException e) {
            System.out.println("could not find the file");
        }

    }

    /**
     * Getter for food names.
     *
     * @return
     *      the food names.
     */
    public List<String> getfoodName() {
        return foodName;
    }

    /**
     * Getter for food prices.
     *
     * @return
     *      the food prices.
     */
    public List<Double> getfoodPrice() {
        return foodPrice;
    }

}
