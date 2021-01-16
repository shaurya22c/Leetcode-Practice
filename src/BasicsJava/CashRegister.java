package BasicsJava;
import javax.print.DocFlavor;
import java.io.*;
import java.util.*;


//javadoc comments

public class CashRegister {
    public static class Coin{

        private Double value;
        private String denomination;

        public Coin(Double value, String denomination) {
            this.value = value;
            this.denomination = denomination;
        }

        public Double getValue() {
            return value;
        }

        public void setValue(Double value) {
            this.value = value;
        }

        public String getDenomination() {
            return denomination;
        }

        public void setDenomination(String denomination) {
            this.denomination = denomination;
        }
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader reader= new InputStreamReader(System.in);
        BufferedReader in= new BufferedReader(reader);
        try{
            double purchasePrice= Double.parseDouble(in.readLine());
            double cash= Double.parseDouble(in.readLine());
            System.out.println(CashRegister.calculateChange(purchasePrice, cash));;
        }catch(Exception e){
            System.out.println(e);
        }
    }


    private static String calculateChange(double price, double cash) {
        if (cash < price) { return "ERROR"; }
        if (cash == price) { return "ZERO"; }
        double cashBack = cash - price;

        TreeSet<Coin> coinSet = new TreeSet<>((coin1, coin2) -> coin2.getValue().compareTo(coin1.getValue()));
        coinSet.add(new Coin(50.0, "Fifty Pounds"));
        coinSet.add(new Coin(20.0, "Twenty Pounds"));
        coinSet.add(new Coin(10.0, "Ten Pounds"));
        coinSet.add(new Coin(5.0, "Five Pounds"));
        coinSet.add(new Coin(2.0, "Two Pounds"));
        coinSet.add(new Coin(1.0, "One Pound"));
        coinSet.add(new Coin(0.5, "Fifty Pence"));
        coinSet.add(new Coin(0.2, "Twenty Pence"));
        coinSet.add(new Coin(0.1, "Ten Pence"));
        coinSet.add(new Coin(0.05, "Five Pence"));
        coinSet.add(new Coin(0.02, "Two Pence"));
        coinSet.add(new Coin(0.01, "One Pence"));

        StringBuilder change = new StringBuilder();
        double lastCashBack = cashBack;
        Iterator<Coin> itr = coinSet.iterator();
        Coin c = itr.next();
        if(cashBack<0.01){
            return "ERROR";
        }
        while (cashBack > 0.01) {
            cashBack = (double) Math.round(cashBack * 100) / 100;
//            System.out.println(cashBack);

            if (!itr.hasNext()) {
                return "ERROR";
            }
            while (cashBack < c.getValue()) {
                c = itr.next();
            }
            Double currentKey = c.getValue();
            String currentWord = c.getDenomination();

            if (cashBack >= currentKey) {
                cashBack -= currentKey;
                change.append(currentWord);
            }

            if (cashBack == lastCashBack) {
                return "ERROR";
            }
            lastCashBack = cashBack;
            change.append(",");
        }
        change.setLength(change.length() - 1);
        return change.toString();
    }
}