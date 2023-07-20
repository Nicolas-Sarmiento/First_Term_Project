package co.edu.uptc.utilities;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputLibrary {
    private Scanner inputLine;

    public InputLibrary(){
        this.inputLine = new Scanner(System.in);
    }
    public int inputInt(String message, String errorMessage){
        boolean isCorrect = false;
        int returnValue = 0;
        while (!isCorrect){
            try {
                System.out.println(message);
                returnValue = inputLine.nextInt();
                isCorrect = true;
            }catch (InputMismatchException e){
                System.out.println(errorMessage);
            }
            inputLine.nextLine();
        }
        return returnValue;
    }
    public int inputInt(String message, String errorMessage, int floor){
        boolean isCorrect = false;
        int returnValue = 0;
        while (!isCorrect){
            try {
                System.out.println(message);
                returnValue = inputLine.nextInt();
                if(returnValue >= floor){
                    isCorrect = true;
                }else {
                    System.out.println(errorMessage);
                }
            }catch (InputMismatchException e){
                System.out.println(errorMessage);
            }
            inputLine.nextLine();
        }
        return returnValue;
    }
    public int inputInt(String message, String errorMessage, int floor, int top){
        boolean isCorrect = false;
        int returnValue = 0;
        while (!isCorrect){
            try {
                System.out.println(message);
                returnValue = inputLine.nextInt();
                if(returnValue >= floor && returnValue <= top){
                    isCorrect = true;
                }else {
                    System.out.println(errorMessage);
                }
            }catch (InputMismatchException e){
                System.out.println(errorMessage);
            }
            inputLine.nextLine();
        }
        return returnValue;
    }

    public String inputString(String message, String errorMessage){
        boolean isCorrect = false;
        String returnValue = "";
        while (!isCorrect){
            try {
                System.out.println(message);
                returnValue = inputLine.nextLine();
                isCorrect = !returnValue.equals("");
            }catch (Exception e){
                System.out.println(errorMessage);
            }
        }
        return returnValue;

    }
}
