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
public class User {
    private long CNP, bankAcccount;
    private String firstName, lastName, password;
    private int amountOfMoney;
    
    public User(){}
    
    public User( long id, long acount, String firstN, String lastN, String passw, int amount ){
        this.CNP = id;
        this.bankAcccount = acount;
        this.firstName = firstN;
        this.lastName = lastN;
        this.password = passw;
        this.amountOfMoney = amount;
    }
    
    public long getCNP(){
        return this.CNP;
    }
    
    public long getAccount(){
        return this.bankAcccount;
    }
    
    public String getName(){
        return this.firstName+' '+this.lastName;
    }
    
    public int getMoney(){
        return this.amountOfMoney;
    }
    
    
}
