package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionModel {
    private String from_account;
    private String to_account;
    private double amount;

    public TransactionModel(){

    }

    public TransactionModel(String from_account, String to_account, double amount){
        this.from_account = from_account;
        this.to_account = to_account;
        this.amount = amount;
    }
}
