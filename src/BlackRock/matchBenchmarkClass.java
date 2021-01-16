package BlackRock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;

public class matchBenchmarkClass {
    public static class Transaction {

        private String transactionType;
        private String companyName;
        private String assetType;
        private Integer shares;

        public String getTransactionType() {
            return transactionType;
        }

        public void setTransactionType(String transactionType) {
            this.transactionType = transactionType;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }
        public String getAssetType() {
            return assetType;
        }

        public void setAssetType(String assetType) {
            this.assetType = assetType;
        }

        public Integer getShares() {
            return shares;
        }

        public void setShares(Integer shares) {
            this.shares = shares;
        }


        @Override
        public String toString() {
            return ""+transactionType+ ","+ ""+companyName+ ","+ ""+assetType+ ","+ ""+shares;
        }

        public Transaction(String transactionType, String companyName, String assetType, Integer shares) {
            this.transactionType = transactionType;
            this.companyName = companyName;
            this.assetType = assetType;
            this.shares = shares;
        }
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            matchBenchmarkClass.matchBenchmark(line);
        }
    }
    public static void matchBenchmark(String input){
        String inputLine = "Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15";
        String[] parts = inputLine.split(":",2);
//        System.out.println(parts[0]);
//        System.out.println(parts[1]);
        String portfolios = parts[0];
        String benchmarks = parts[1];
        String[] portfolioList = portfolios.split("\\|");
        String[] benchmarkList = benchmarks.split("\\|");

        HashMap<String, Integer> benchmarkMap = new HashMap<>();
        for (String currentBenchmark : benchmarkList) {

            String[] benchmarkData = currentBenchmark.split(",");
            benchmarkMap.put(benchmarkData[0] + "-" + benchmarkData[1], Integer.parseInt(benchmarkData[2]));
        }

        ArrayList<Transaction> transactions = new ArrayList<>();

        for (String currentPortfolio : portfolioList) {

            String[] portfolioData = currentPortfolio.split(",");
            String key = portfolioData[0] + "-" + portfolioData[1];
            Integer value = Integer.parseInt(portfolioData[2]);

            if (!benchmarkMap.containsKey(key)) {
                //we need to make same transaction as benchmark
                transactions.add(new Transaction(portfolioData[1], portfolioData[0], "BUY", Integer.parseInt(portfolioData[2])));

            } else {
                //we need to find diff and decide what transaction to do
                Integer targetValue = benchmarkMap.get(key);
                Transaction transaction = new Transaction("", portfolioData[0],portfolioData[1], 0);
                if (targetValue > value) {
                    transaction.setTransactionType("BUY");
                    transaction.setShares(targetValue - value);
                } else if (targetValue < value) {
                    transaction.setTransactionType("SELL");
                    transaction.setShares(value - targetValue);
                } else {
                    //do nothing it is already equally
                    benchmarkMap.remove(key);
                }
                if (!transaction.transactionType.equals("")) {
                    transactions.add(transaction);
                    benchmarkMap.remove(key);
                }
            }
        }
        for (String key: benchmarkMap.keySet()) {
            String[] data = key.split("-");
            transactions.add(new Transaction("BUY", data[0], data[1], benchmarkMap.get(key)));
        }

        transactions.sort((t1, t2) -> {
            int comparision = t1.getCompanyName().compareTo(t2.getCompanyName());
            if (comparision == 0) {
                if (t1.getAssetType().equals("BOND")){
                    return -1;
                } else {
                    return 1;
                }
            }
            return comparision;
        });

        for(Transaction t: transactions) {
            System.out.println(t.toString());
        }
    }
}
//sample input: Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10
/*output:
    SELL,Google,STOCK,5
    BUY,Vodafone,BOND,10
    BUY,Vodafone,STOCK,5
 */

//sample input: Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15
/*output:
    SELL,Google,STOCK,5
    BUY,Vodafone,STOCK,5
 */

