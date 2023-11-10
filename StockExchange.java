import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StockExchange {
    public static void main(String[] args) {
        String fileName = "CompanyData.txt";
        CompanyList companyList = new CompanyList();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(","); // Split the line using a comma as the delimiter

                if (parts.length == 6) {
                    int companyNumber = Integer.parseInt(parts[0]);
                    String companyName = parts[1];
                    String companyService = parts[2];
                    int currentRanking = Integer.parseInt(parts[3]);
                    String companySymbol = parts[4];
                    String[] sharePricesStr = parts[5].split(" ");
                    int[] sharePrices = new int[sharePricesStr.length];

                    for (int i = 0; i < sharePricesStr.length; i++) {
                        sharePrices[i] = Integer.parseInt(sharePricesStr[i]);
                    }

                    PRACompany company = new PRACompany(companyNumber, companyName, companyService, currentRanking, companySymbol, sharePrices);

                    // Adding each company to the list

                    companyList.addCompany(company);
                    
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Manager manager = new Manager("pravek");
        System.out.println("Please enter Password to continue");
        String Password = System.console().readLine();
        System.out.println(manager.Authenticate(Password));
        if (manager.isAuthenticated()) {
           System.out.println("Welcome " + manager.getUsername());
           System.out.println(companyList.ListAllCompaniesAsTable());
           for(PRACompany company : companyList.getCompanies()) {
            System.out.println(company.getFullDetails());
            System.out.println(company.getShortDetails());
            System.out.println("\n----------------------------------------------------------------------------------------------------\n");
           }
        System.out.println(companyList.CountCompanies());
        System.out.println(companyList.HigestShareValueCompany());
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"))) {
    writer.write(companyList.ListAllCompaniesAsTable());
    
    for (PRACompany company : companyList.getCompanies()) {
        writer.newLine();
        writer.write(company.getFullDetails());
        writer.newLine();
        writer.write(company.getShortDetails());
        writer.newLine();
        writer.write("----------------------------------------------------------------------------------------------------");
        writer.newLine();
    }

    writer.newLine();
    writer.write("Number of Companies: " + companyList.CountCompanies());
    writer.newLine();
    writer.write("Company with Highest Share Value: " + companyList.HigestShareValueCompany());
} catch (IOException e) {
    e.printStackTrace();
}


    }   
    else 
        System.out.println("Login Failed");
    }
} 

