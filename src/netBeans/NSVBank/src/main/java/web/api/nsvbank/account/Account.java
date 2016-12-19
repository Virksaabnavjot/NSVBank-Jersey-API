package web.api.nsvbank.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import web.api.nsvbank.transaction.Transaction;

/**
 *
 * @author Navjot Singh Virk
 * Date: Mon 21st November 2016
 * Time: 4:00 pm (Dublin,Ireland)
 * 
 * @Modification History
 * Modified on: 23rd November/2016 by Navjot at 7:45pm
 * Modified on: Mon 19th December/2016 by Navjot at 7:03 pm
 */

@Entity
@Table
@XmlRootElement
public class Account implements Serializable{
    //declaring data members
    @Id
    //    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;
    private int accountNumber;
    private String sortCode;
    private Double currentBalance;
    private List <Transaction> transactions;
    
    //constructor
    public Account(int id, int accountNumber, String sortcode, Double currentBalance, List transactions){
        this.id = id;
        this.accountNumber = accountNumber;
        this.sortCode = sortcode;
        this.currentBalance = currentBalance;
        this.transactions = transactions;
    }
    
    //setters and getters
    public void setId(int id) {
        this.id = id;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getId() {
        return id;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSortCode() {
        return sortCode;
    }

    public void setSortCode(String sortCode) {
        this.sortCode = sortCode;
    }

    public Double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
    
}
