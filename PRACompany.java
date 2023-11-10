public class PRACompany{    // class name for company as per requirement (initalials for PRAVEK followed by Company)
    private int CompanyNumber;
    private String CompanyName;
    private String CompanyService;
    private int CurrentRanking;
    private String CompanySymbol; //Extra Attribute of my choise as per requirement
    
    private int[] SharePrices; //Attribute for storing Share Prices - Scores

    public PRACompany(int CompanyNumber, String CompanyName, String CompanyService, int CurrentRanking, String CompanySymbol, int[] SharePrices) {
        this.CompanyNumber = CompanyNumber;
        this.CompanyName = CompanyName;
        this.CompanyService = CompanyService;
        this.CurrentRanking = CurrentRanking;
        this.CompanySymbol = CompanySymbol;
        this.SharePrices = SharePrices;
    }

    public PRACompany() {
        this.CompanyNumber = 0;
        this.CompanyName = "";
        this.CompanyService = "";
        this.CurrentRanking = 0;
        this.CompanySymbol = "";
        this.SharePrices = new int[0];
    }

    // Get Methods for all attributes of the class
    public int getCompanyNumber() {return CompanyNumber;}

    public String getCompanyName() {return CompanyName;}

    public String getCompanyService() {return CompanyService;}

    public int getCurrentRanking() {return CurrentRanking;}

    public String getCompanySymbol() {return CompanySymbol;}

    public int[] getSharePrices() {return SharePrices;}

    public String getSharePriceArray() {
        StringBuilder SharePriceString = new StringBuilder();
        for (int price : SharePrices){
            SharePriceString.append(price);
            SharePriceString.append(" ");
        }
        return SharePriceString.toString();
    }
   
    // Set Methods for all attributes of the class
    public void setCompanyNumber(int CompanyNumber) {this.CompanyNumber = CompanyNumber;}

    public void setCompanyName(String CompanyName) {this.CompanyName = CompanyName;}

    public void setCompanyService(String CompanyService) {this.CompanyService = CompanyService;}

    public void setCurrnetRanking(int CurrnetRanking) {this.CurrentRanking = CurrnetRanking;}   

    public void setCompanySymbol(String CompanySymbol) {this.CompanySymbol = CompanySymbol;} 
    
    public void setSharePrices(int[] SharePrices) {this.SharePrices = SharePrices;}
    
    // Additional Methods as per requiremnets
    public double getAverageSharePrice(){               //Calculate a weighted average of the share prices
        if (SharePrices.length == 0) return 0;          //Based on the Type of servies offered by the company

        int sum = 0; 
        double weight = 1;
        if (CompanyService == "cars")
        weight = 0.7;
        if (CompanyService == "smartphones")
        weight = 0.9;
        if (CompanyService == "accounting")
        weight = 1.3;
        if (CompanyService == "contracts")
        weight = 1.5;
        if (CompanyService == "energy")
        weight = 1.7;
        for(int price : SharePrices) {
            sum += price;
        }

        return (sum * weight) / SharePrices.length;

    }
    public String getFullDetails(){
        return "\nFull Details For: " + CompanyNumber +"\n\nCompany Number " + CompanyNumber + " named " + CompanyName + "\nThe type of service the company offers is " + CompanyService + "\nThe Company Currently Ranks " + CurrentRanking + "\nThe Symbol for the Company is " + CompanySymbol + "\nThe Share Prices for the compnay in the Past 5 days are " + getSharePriceArray() + "and has an overall Share Price of " + getAverageSharePrice();
    }
    public String getShortDetails(){
        return "\nShort Details For: " + CompanyNumber +"\n\nCN " + CompanyNumber + " Has an average weighted share price of " + getAverageSharePrice();
    }
}