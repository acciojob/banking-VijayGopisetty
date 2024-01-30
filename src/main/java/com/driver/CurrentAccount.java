package com.driver;

public class CurrentAccount extends BankAccount{
    String tradeLicenseId; //consists of Uppercase English characters only

    public CurrentAccount(String name, double balance, String tradeLicenseId) throws Exception {
        // minimum balance is 5000 by default. If balance is less than 5000, throw "Insufficient Balance" exception
        super(name,balance,5000);
        this.tradeLicenseId=tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {
        // A trade license Id is said to be valid if no two consecutive characters are same
        // If the license Id is valid, do nothing
        // If the characters of the license Id can be rearranged to create any valid license Id
        // If it is not possible, throw "Valid License can not be generated" Exception
        if(checkConsecutive()){
            int n=tradeLicenseId.length();
            int[] freq=new int[26];
            for(int i=0;i<tradeLicenseId.length();i++){
                char ch=tradeLicenseId.charAt(i);
                freq[ch-'A']++;
            }
            for(int i=0;i<26;i++){
                if(freq[i]>n/2){
                    throw new Exception("Valid License can not be generated");
                }
            }
        }
    }
    public boolean checkConsecutive(){
        int n=tradeLicenseId.length();
        for(int i=0;i<n-1;i++){
            if(tradeLicenseId.charAt(i)==tradeLicenseId.charAt(i+1))
                return false;
        }
        return true;
    }

}
