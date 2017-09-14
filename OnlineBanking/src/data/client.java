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
public class client {
    private long CNP, bankAcunt;
    private String firstName, lastName, password;
    private int amountOfMoney;
    
    public client(){}
    
    public client( long id, long acount, String firstN, String lastN, String passw, int amount ){
        this.CNP = id;
        this.bankAcunt = acount;
        this.firstName = firstN;
        this.lastName = lastN;
        this.password = passw;
        this.amountOfMoney = amount;
    }
}
