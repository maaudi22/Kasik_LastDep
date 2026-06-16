import java.sql.SQLOutput;
import java.util.Scanner;

public class Helper {
    static String colorGreen = "\u001B[32m";
    static String colorBlue = "\u001B[34m";
    static String colorYellow = "\u001B[33m";
    static String colorRed = "\u001B[31m";
    static String colorGrey = "\u001B[90m";
    static String colorDefault = "\u001B[0m";

    public static void clear(){
        for(int i = 0; i < 50; i++){
            System.out.println("\n");
        }
    }

    static void showLogo(){
        System.out.println(colorYellow +
                " _        _    ____ _____ ____  _____ ____  \n" +
                        "| |      / \\  / ___|_   _|  _ \\| ____|  _ \\ \n" +
                        "| |     / _ \\ \\___ \\ | | | | | |  _| | |_) |\n" +
                        "| |___ / ___ \\ ___) || | | |_| | |___|  __/ \n" +
                        "|_____/_/   \\_\\____/ |_| |____/|_____|_|    " + colorDefault);
    }

    public static void showBalanceOptional(double balance){
            System.out.println("Guthaben: " + colorGreen + balance + "$" + colorDefault);
    }
}
