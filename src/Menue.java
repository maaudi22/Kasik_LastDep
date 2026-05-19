import java.util.Scanner;

public class Menue {
    static void showMenue(Account acc){
        Helper.clear();
        Scanner scan = new Scanner(System.in);
        Helper.showLogo();
        acc.showBalance();
        System.out.println("(1) Slots\n" +
                "(2) Road\n" +
                "(3) Bomb\n" +
                "(0) Beenden");

        String eingabe = scan.nextLine();
        switch (eingabe){
            case "1": Slots.startSlots(acc.getBalance()); break;
            case "2": break; //TODO
            case "3": break; //TODO
            case "0": break; //TODO
            default: break; //TODO
        }
    }

    static double EnterBalcance(){
        double temp_balance = 0.0;
        Scanner scan = new Scanner(System.in);
        Helper.clear();
        Helper.showLogo();
        System.out.println("Bitte geben Sie Ihr Guthaben ein: ");
        try {
            temp_balance = scan.nextDouble();
        }
        catch (Exception ex){
        } //TODO

        return temp_balance;
    }
}
