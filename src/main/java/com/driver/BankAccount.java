package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        int[] freq=new int[10];
        int count=0;
        for(int i=9;i>=1;i--){
            if(sum!=0 && sum>=i){
                int frequency=sum/i;
                freq[i]=frequency;
                sum-=frequency*i;
            }
        }
        StringBuilder accountNumber=new StringBuilder();
        for(int i=9;i>0;i--){
            while(freq[i]!=0){
                accountNumber.append(i);
            }
        }
        while(accountNumber.length()!=digits){
            accountNumber.append(0);
        }
        if(accountNumber.length()==digits) return accountNumber.toString();
        else{
            throw new Exception("Account Number cannot be generated");
        }
    }

    public void deposit(double amount) {
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        double remainingAmount=balance-amount;
        if(remainingAmount<minBalance){
            throw new Exception("Insufficient Balance");
        }
        balance=remainingAmount;
    }

}