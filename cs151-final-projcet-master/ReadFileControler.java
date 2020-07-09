/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs151hw4ry;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; // The ArrayList library
import java.util.Iterator; // The Iterator Library
import java.util.Arrays; // The Arrays Library
/**
 *
 * @author Jing Zhao
 */
public class ReadFileControler {
    private Scanner input;
    static ArrayList<String> foodName = new ArrayList<>();
    static ArrayList<Double> foodPrice = new ArrayList<>();
    public void operFileReader() throws FileNotFoundException{
        try{
            input = new Scanner(new File("menu.txt"));

            while(input.hasNextLine()){
                String str = input.nextLine();
                String[] parts = str.split("\\|");
                foodName.add(parts[0].replaceAll("[^A-Za-z]+","").trim());
                foodPrice.add(Double.parseDouble(parts[1].trim()));


            }



        }catch (FileNotFoundException e){
            System.out.println("could not find the file");
        }

    }


    //test for return the foodname and foodprice to the UI
    public static ArrayList getfoodName(){
        return foodName;
    }

    public static ArrayList getfoodPrice(){
        return foodPrice;
    }



    }
