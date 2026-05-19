import java.util.Scanner;
import java.util.Random;

public class Slots extends Game {
    static char a = 'A';
    static char b = 'B';
    static char c = 'C';
    double slotBalance;
    double gewinn = 0;
    boolean gameGoes = false;
    boolean rundeVerloren = false;

    public Slots(double slotBalance){
        this.slotBalance = slotBalance;
        this.gameGoes = false;
    }

    public static void startSlots(double startBalance){
        Slots slot = new Slots(startBalance);
        slot.startGame();
    }

    @Override
    public void startGame() {
        clear();
        showBalanceOptional(this.slotBalance);
        showInterface();

        gameGoes = true;
        while (gameGoes){
            clear();
            System.out.println(colorBlue + " --- SLOTS --- " + colorDefault);

            showBalanceOptional(this.slotBalance);
            showInterface();
            doAction();
        }
    }

    @Override
    void showInterface() {
        showInstruction();
        System.out.println("| - | - | - |");
        System.out.println("| " + a + " | " + b + " | " + c + " |");
        System.out.println("| - | - | - |\n");

        if(rundeVerloren){
            System.out.println(colorRed + "Verloren: " + colorDefault + " - " + colorRed +  gewinn + " $" + colorDefault);
            rundeVerloren = false;
        } else {
            System.out.println(colorYellow + "Gewinn: "  + colorGreen +  gewinn + " $" + colorDefault);
        }
    }

    @Override
    void showInstruction() {
        System.out.println(colorGrey + "777 - x100 / x10\n" +
                "AAA - x50 / x5\n" +
                "### - x20 / x1,5\n" +
                "!!! - x10\n" +
                "OOO - x10\n" + "0 - zurück zu Menü" + colorDefault
        );
    }

    public void doAction(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Einsatz: ");
        Double einsatz = scan.nextDouble();
        if(einsatz == 0){
            endSlots();
        }
        else{
            a = generateRandomNumber();
            b = generateRandomNumber();
            c = generateRandomNumber();

            if(a == b && b == c){ //Wenn alle 3 sind gleich
                if(a == '7'){
                    this.gewinn = einsatz * 100;
                } else if(a == 'A'){
                    this.gewinn = einsatz * 50;
                } else if(a == '#'){
                    this.gewinn = einsatz * 20;
                } else if(a == '!'){
                    this.gewinn = einsatz * 10;
                } else if(a == '0'){
                    this.gewinn = einsatz * 10;
                }
            }
            if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)){ //Wenn 2 von 3 sind gleich
                if(a == '7' || b == '7' || c == '7'){
                    this.gewinn = einsatz * 10;
                } else if(a == 'A' || b == 'A' || c == 'A'){
                    this.gewinn = einsatz * 5;
                } else if(a == '#' || b == '#' || c == '#'){
                    this.gewinn = einsatz * 1.5;
                }

            }
            else { //Wenn alle 3 unterschiedlich sind - Verlust
                this.slotBalance -= einsatz;

            }
        }
    }

     private void endSlots(){
        gameGoes = false;
            //TODO
    }

    static char generateRandomNumber() {
        Random random = new Random();
        int zahl =  random.nextInt(5) + 1; // Generates a number between 1 and 5
        switch (zahl) {
            case 1: return '7';
            case 2: return 'A';
            case 3: return '#';
            case 4: return '!';
            case 5: return '0';
            default: return '-';
        }
    }
}
