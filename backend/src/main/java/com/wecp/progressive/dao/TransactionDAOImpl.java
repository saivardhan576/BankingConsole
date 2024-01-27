package com.wecp.progressive.dao;

import com.wecp.progressive.entity.Transactions;

import java.util.ArrayList;
import java.util.List;

public class TransactionDAOImpl implements TransactionDAO{

    @Override
    public List<Transactions> getAllTransactions(){
        List<Transactions> transactions = new ArrayList<>();
        return transactions;
    }

    @Override
    public Transactions getTransactionById(int transactionId) {
        return null;
    }

    @Override
    public int addTransaction(Transactions transaction) {
        int generatedID = -1;
        return generatedID;
    }

    @Override
    public void updateTransaction(Transactions transaction) {

    }

    @Override
    public void deleteTransaction(int transactionId) {

    }

}