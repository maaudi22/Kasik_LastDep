import java.util.Scanner;
import java.util.Random;

public class Slots extends Game {
    static char a = 'A';
    static char b = 'B';
    static char c = 'C';
    double slotBalance;

    public Slots(double slotBalance){
        this.slotBalance = slotBalance;
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

        boolean gameGoes = true;
        while (gameGoes){
            clear();
            System.out.println(colorBlue + " --- SLOTS --- " + colorDefault);

            showBalanceOptional(this.slotBalance);
            showInterface();
            doAction();
            gameGoes = false;
        }
    }

    @Override
    void showInterface() {
        showInstruction();
        System.out.println("| - | - | - |");
        System.out.println("| " + a + " | " + b + " | " + c + " |");
        System.out.println("| - | - | - |\n");
        System.out.println(colorYellow + "Gewinn: "  + " $" + colorDefault); //TODO
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
        Double eingabe = scan.nextDouble();
        if(eingabe == 0){
            endSlots();
        }
        else{
            a = generateRandomNumber();
            b = generateRandomNumber();
            c = generateRandomNumber();

            if(a == b && b == c){ //Wenn alle 3 sind gleich
                if(a == '7'){
                    this.slotBalance += eingabe * 100;
                } else if(a == 'A'){
                    this.slotBalance += eingabe * 50;
                } else if(a == '#'){
                    this.slotBalance += eingabe * 20;
                } else if(a == '!'){
                    this.slotBalance += eingabe * 10;
                } else if(a == '0'){
                    this.slotBalance += eingabe * 10;
                }
            }
            if ((a == b && a != c) || (a == c && a != b) || (b == c && b != a)){ //Wenn 2 von 3 sind gleich
                if(a == '7' || b == '7' || c == '7'){
                    this.slotBalance += eingabe * 10;
                } else if(a == 'A' || b == 'A' || c == 'A'){
                    this.slotBalance += eingabe * 5;
                } else if(a == '#' || b == '#' || c == '#'){
                    this.slotBalance += eingabe * 1.5;
                }

            }
            else { //Wenn alle 3 unterschiedlich sind
                this.slotBalance -= eingabe;
            }
        }
    }

    static void endSlots(){
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
