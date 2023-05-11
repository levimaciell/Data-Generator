package org.levi.files;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {

            System.out.println("Hello! Welcome!\nPlease, choose an option: ");
            printMenuOptions();

            try {

                int option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        generateDataOptionsMenu(sc);
                        break;

                    case 2:
                        System.out.println("Thanks for using this little program :)");
                        exit = true;
                        break;

                    default:
                        System.out.println("Sorry, this is not an valid option :(");
                        break;
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Sorry, but you typed a not numeric value :(");
            }
        }
        
        sc.close();
    }

    private static void printMenuOptions(){
        StringBuffer b = new StringBuffer();
        b.append("----------------------------------\n");
        b.append("----- Main Menu -----\n");
        b.append("----------------------------------\n");
        b.append("[1] Generate data").append("\n");
        b.append("[2] Exit of program").append("\n");
        System.out.println(b.toString());
    }
    private static void printDataOptions(){
        StringBuilder stBuilder = new StringBuilder();
        stBuilder.append("----------------------------------\n");
        stBuilder.append("----- Data Options Menu -----\n");
        stBuilder.append("----------------------------------\n");
        stBuilder.append("[1] Generate Integer Data\n");
        stBuilder.append("[2] Exit\n");
        stBuilder.append("Please, enter an option: ");
        System.out.println(stBuilder.toString());
    }

    private static void generateDataOptionsMenu(Scanner sc){

        boolean exit = false;

        while(!exit){
            printDataOptions();
            try {
                int option = Integer.parseInt(sc.nextLine());

                switch (option){
                    case 1:
                        integerGenerateMenu(sc);
                        break;

                    case 2:
                        System.out.println();
                        exit = true;
                        break;

                    default:
                        System.out.println("Sorry, but this is not a valid option :(");
                }

            }
            catch (NumberFormatException e){
                System.out.println("Please, type an numeric value :(");
            }

        }
    }

    private static void integerGenerateMenu(Scanner sc){
        IntegerGenerator generator = new IntegerGenerator();

        try{
            System.out.println("Give a number of data to be generated: ");
            int numberOfData = Integer.parseInt(sc.nextLine());

            System.out.println("Do you want to set up a limit of numbers to be generated? (s/n)");
            String option = sc.nextLine();

            while(!option.equalsIgnoreCase("s") && !option.equalsIgnoreCase("n")){
                System.out.println("Sorry, but you typed a not valid option. Please try again");
                System.out.println("-----------------------------------------------------------------");
                System.out.println("Do you want to set up a limit of numbers to be generated? (s/n)");
                option = sc.nextLine();
            }

            switch (option){
                case "s":

                    System.out.println("What do you want the limit to be?");

                    int limit;

                    try{
                        limit = Integer.parseInt(sc.nextLine());
                        List<Integer> randomList = generator.generateData(numberOfData,limit);
                        System.out.println("Your list generated: (output this to a txt file later)");

                        for(Integer i : randomList){
                            System.out.println(i);
                        }
                    }
                    catch (NumberFormatException e){
                        System.out.println("You typed something not numeric. Please, try again. ");
                    }

                    break;

                case "n":

                    try{

                        List<Integer> randomListNoLimits = generator.generateData(numberOfData);

                        for(Integer i: randomListNoLimits){
                            System.out.println(i);
                        }

                    }
                    catch (NumberFormatException e){
                        System.out.println("You typed something not numeric. Please, try again. ");
                    }

                    break;
            }
        }
        catch (NumberFormatException e){
            System.out.println("You typed something not numeric. Please, try again. ");
        }





    }
}
