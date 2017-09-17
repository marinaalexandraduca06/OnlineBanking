/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Marina
 */
public class transaction {
    private int transactionID, amountOfMoney;
    private long clientID;
    private String destination, transactionDate, transactionTime;
    
    public transaction(){}
    
    public transaction( int ID, int amount, long cID, String dest, String date, String time ){
        this.transactionID = ID;
        this.amountOfMoney = amount;
        this.clientID = cID;
        this.destination = dest;
        this.transactionDate = date;
        this.transactionTime = time;
    }
}
