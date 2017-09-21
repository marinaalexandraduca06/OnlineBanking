/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

/**
 *
 * @author Marina
 */
public class User {
    private String CNP, bankAcccount;
    private String firstName, lastName, password;
    private int amountOfMoney;
    
    public User(){}
    
    public User( String id, String acount, String firstN, String lastN, String passw, int amount ){
        this.CNP = id;
        this.bankAcccount = acount;
        this.firstName = firstN;
        this.lastName = lastN;
        this.password = passw;
        this.amountOfMoney = amount;
    }
    
    public String getCNP(){
        return this.CNP;
    }
    
    public String getAccount(){
        return this.bankAcccount;
    }
    
    public String getName(){
        return this.firstName+' '+this.lastName;
    }
    
    public int getMoney(){
        return this.amountOfMoney;
    }
    
    public void setCNP(String cnp){
        this.CNP = cnp;
    }
    
    public void setBankAccount(String bankAccount){
        this.bankAcccount = bankAccount;
    }
    
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setMoney(int money){
        this.amountOfMoney = money;
    }
    
    
}
