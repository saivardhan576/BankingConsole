package com.wecp.progressive.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.Transactions;
import com.wecp.progressive.repository.AccountRepository;
import com.wecp.progressive.repository.TransactionRepository;
@Service
public class TransactionServiceImplJpa implements TransactionService{

    @Autowired
    private TransactionRepository transactionRepository;
    private AccountRepository accountRepository;
    
    private static List<Transactions> transactionsList=new ArrayList<>();

    public TransactionServiceImplJpa(TransactionRepository transactionRepository,AccountRepository accountRepository){
        this.transactionRepository=transactionRepository;
        this.accountRepository=accountRepository;
    }

    @Override
    public List<Transactions> getAllTransactions() throws SQLException {
        return transactionRepository.findAll();
    }

    @Override
    public Transactions getTransactionById(int transactionId) throws SQLException {
       return transactionRepository.findById(transactionId).get();
    }

    @Override
    public int addTransaction(Transactions transaction) throws SQLException {
        transactionRepository.save(transaction);
        return transaction.getTransactionId();
    }

    @Override
    public void updateTransaction(Transactions transaction) throws SQLException {
        transactionRepository.findById(transaction.getTransactionId()).map(transactions->{
            transactions.setAccountId(transaction.getAccountId());
            transactions.setAmount(transaction.getAmount());
            transactions.setTransactionDate(transaction.getTransactionDate());
            transactions.setTransactionType(transaction.getTransactionType());
            return transactionRepository.save(transactions);
        });
    }

    @Override
    public void deleteTransaction(int transactionId) throws SQLException {
        transactionRepository.deleteById(transactionId);
    }

    @Override
    public List<Transactions> getTransactionsByCustomerId(int customerId) throws SQLException {
        return null; //transactionRepository.findByCustomerId(customerId);
    }

}