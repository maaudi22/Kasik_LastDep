public class Main extends Helper{
    public static void main(String[] args) {
    Account acc = new Account(0.0);
    acc.setBalance(Menue.EnterBalcance());

    Menue.showMenue(acc);
    }
}

