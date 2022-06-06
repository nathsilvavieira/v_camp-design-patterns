package e_commerce;

import e_commerce.builders.BeautyProductsBuilder;
import e_commerce.builders.FoodProductsBuilder;
import e_commerce.builders.EletronicProductsBuilder;
import e_commerce.builders.AutoProductsBuilder;
import e_commerce.director.ProductDiretor;
import e_commerce.model.Product;

import javax.sound.midi.Soundbank;
import java.util.Locale;
import java.util.Scanner;


public class Client {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String option = "no";
        System.out.println("Welcome to e-commerce");
        System.out.println("\nHow can we help you? ");
        System.out.println("\nDo you want to purchase? \nPlease entry 'yes' to continue ou 'no' cancel ");
        option = sc.next();

        while(!option.equalsIgnoreCase("no")){

            System.out.println("\nWhich sector do you want to make your purchases?");
            System.out.println("\nFor Beauty inform 'b',\n for Food inform 'f',\n for Eletronic inform 'e' and \n for Auto inform 'a'");
            option = sc.next();

            switch (option.toLowerCase()){
                case "b":
                    System.out.println("Please insert which product do you what to buy?");
                    String product = sc.next();
                    System.out.println("Please inform how many products do you want?");
                    int quantityOfProducts = sc.nextInt();
                    option = "no";
                break;
                default:
                    System.out.println("end");
            }
        }





    }


}
