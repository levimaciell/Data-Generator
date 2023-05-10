package org.levi.files;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {

            System.out.println("Hello! Welcome!\nPlease, choose an option: ");
            printOptions();

            int option = 0;
            try {
                option = Integer.parseInt(sc.nextLine());

                switch (option) {
                    case 1:
                        System.out.println("Sorry, nothing planned for now :(");
                        break;

                    case 2:
                        System.out.println("Thanks for using this little program :)");
                        exit = true;
                        break;

                    default:
                        System.out.println("Sorry, this is not an valid option :(");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Sorry, but you typed a not numeric value :(");
            }
        }
        
        sc.close();
    }

    private static void printOptions(){
        StringBuffer b = new StringBuffer();
        b.append("[1] Generate data").append("\n");
        b.append("[2] Exit of program").append("\n");
        System.out.println(b.toString());
    }
}
