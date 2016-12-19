package web.api.nsvbank.transaction;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Navjot Singh Virk
 * Date: 21st November 2016
 * Time: 4:02 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 8:06pm
 * Modified on: Mon 19th December/2016 by Navjot at 6:50 pm
 */

@Entity
@Table
@XmlRootElement
public class Transaction implements Serializable{
    //declare data members
    @Id
    //    @GeneratedValue(strategy = GenerationType.TABLE)
    private int transactionId;
    private Double transactionAmount;
    private Date transactionDate;
    private String transactionDescription;
    private Double postTransactionBalance;
    
    //constructor
    public Transaction(int transactionId, Double transactionAmount, Date transactionDate, String transactionDescription, Double posttransactionBalance){
        this.transactionId = transactionId;
        this.transactionAmount = transactionAmount;
        this.transactionDate = transactionDate;
        this.transactionDescription = transactionDescription;
        this.postTransactionBalance = posttransactionBalance;
    }
    
    //Setters and Getters
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
