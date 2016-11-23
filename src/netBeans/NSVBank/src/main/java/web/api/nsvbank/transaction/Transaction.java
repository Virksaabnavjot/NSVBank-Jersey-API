package web.api.nsvbank.transaction;

import java.util.Date;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 8:06pm
 */

public class Transaction {
    //declare data members
    int transactionId;
    Double transactionAmount;
    Date transactionDate;
    String transactionDescription;
    Double postTransactionBalance;
    
    //constructor
    public Transaction(){
        transactionId = 0;
        transactionAmount = 0.0;
        transactionDate = new Date();
        transactionDescription = "";
        postTransactionBalance = 0.0;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public void setTransactionDescription(String transactionDescription) {
        this.transactionDescription = transactionDescription;
    }

    public Double getPostTransactionBalance() {
        return postTransactionBalance;
    }

    public void setPostTransactionBalance(Double postTransactionBalance) {
        this.postTransactionBalance = postTransactionBalance;
    }
    
}
