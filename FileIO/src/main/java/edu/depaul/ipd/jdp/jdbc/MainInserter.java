package edu.depaul.ipd.jdp.jdbc;

import edu.depaul.ipd.jdp.filehandling.FileFromClassPathMain;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainInserter {
    public static void main(String[] args) throws IOException {
        InputStream stream = FileFromClassPathMain.class.getClassLoader()
            .getResourceAsStream("data/account.data");
        InputStreamReader isr = new InputStreamReader(stream);
        BufferedReader br = new BufferedReader(isr);
        
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
            String[] row = line.split(";");
            
            Account a = new Account();
            a.setAccountNumber(Integer.parseInt(row[0]));
            a.setName(row[1]);
            a.setInitialBalance(Float.parseFloat(row[2]));

            AccountInserter inserter = new AccountInserter();
            System.out.println("  Insert was successful: " + inserter.add(a));
        }
    }
}
