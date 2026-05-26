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
            System.out.println(colorBlue +
                    "  ____  _      ___ _____ ____  \n" +
                    " / ___|| |    / _ \\_   _/ ___| \n" +
                    " \\___ \\| |   | | | || | \\___ \\ \n" +
                    "  ___) | |___| |_| || |  ___) |\n" +
                    " |____/|_____|\\___/ |_| |____/" + colorDefault);

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
            System.out.println(colorRed + "Verloren! " + colorDefault);
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

            rundeVerloren = berechneGewinn_verloren(einsatz, a, b, c);

            if(rundeVerloren){
                this.slotBalance -= einsatz;
            }
            else { //Wenn alle 3 unterschiedlich sind - Verlust
                this.slotBalance += this.gewinn;

            }
        }
    }

    /** Berechnet den Gewinn basierend auf den Einsätzen und den Symbolen
     * Gibt true zurück, wenn der Spieler verloren hat, andernfalls false
     * @param einsatz Der Einsatzbetrag
     * @param a Symbol 1
     * @param b Symbol 2
     * @param c Symbol 3
     * @return true falls verloren sonst false
     */
    public boolean berechneGewinn_verloren(double einsatz, char a, char b, char c) { //this.gewinn = einsatz * ...
        if(a == b && a == c) //3 gleiche
        {
            if(a=='7')
            {
                this.gewinn = einsatz * 100;
            }
            if(a=='A')
            {
                this.gewinn = einsatz * 50;
            }
            if(a=='#')
            {
                this.gewinn = einsatz * 20;
            }
            if(a=='!')
            {
                this.gewinn = einsatz * 10;
            }
            if(a=='O')
            {
                this.gewinn = einsatz * 10;
            }
        }//       77-                     7-7
        else if ((a == b && a != c) || (a == c && a != b)) {
            if(a=='7') {
                this.gewinn = einsatz * 10;
            }
            if(a=='A') {
                this.gewinn = einsatz * 5;
            }
            if(a=='#') {
                this.gewinn = einsatz * 1.5;
            }
            else {
                this.gewinn = 0;
                return true;
            }// -77
        } else if ((b == c && b != a)) {
            if(b=='7') {
                this.gewinn = einsatz * 10;
            }
            if(b=='A') {
                this.gewinn = einsatz * 5;
            }
            if(b=='#') {
                this.gewinn = einsatz * 1.5;
            }
            else {
                this.gewinn = 0;
                return true;
            }
        }
        else {
            this.gewinn = 0;
            return true;
        }
        return false;
    }

     private void endSlots(){
        gameGoes = false;
        return;
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
