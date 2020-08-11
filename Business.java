public class Business extends LoanP {
    String clientno, clientname,loantype;
    String loanamount;

    //creating double variable for loanamount
    double loanAmount;
    String years;
    int Years;

    Business(){
        //getting values from the text values and adding to variables
        clientno = txtClientNumber.getText();
        clientname = txtClientName.getText();
        loanamount = txtLoanAmount.getText();
        loanAmount=  Double.parseDouble(loanamount);
        years = txtNumOfYears.getText();
        Years = Integer.parseInt(years);
        loantype = (String) cbTypeOfLoan.getSelectedItem();
    }

    public void amortize() {
        int monthlyRate = 0;
        double termInMonths =  Years*12;
        double monthlyPayment = (loanAmount*monthlyRate) / (1-Math.pow(1+monthlyRate, termInMonths));
    }

//    double monthlyPayment = (loanAmount*monthlyRate) / (1-Math.pow(1+monthlyRate, -termInMonths));


    public String getClientno() {
        return clientno;
    }
}


