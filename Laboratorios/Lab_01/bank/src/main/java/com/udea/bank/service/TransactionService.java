package com.udea.bank.service;


import com.udea.bank.dto.TransactionDTO;
import com.udea.bank.entity.Customer;
import com.udea.bank.entity.Transaction;
import com.udea.bank.repository.CustomerRepository;
import com.udea.bank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CustomerRepository customerRepository;


    // Validar que los numeros de cuenta no sean nulos
    public TransactionDTO transferMoney(TransactionDTO transactionDTO){
        if (transactionDTO.getSenderAccountNumber() == null || transactionDTO.getReceiverAccountNumber() == null){
            throw new IllegalArgumentException("Los numeros de cuenta del remitente y receptor son obligatorios");
        }

        // buscar clientes por numero de cuenta
        Customer sender = customerRepository.findByAccountNumber(transactionDTO.getSenderAccountNumber()).orElseThrow(()->new IllegalArgumentException("La cuente del remitente no existe."));
        Customer receiver = customerRepository.findByAccountNumber(transactionDTO.getReceiverAccountNumber()).orElseThrow(()->new IllegalArgumentException("La cuenta del receptor no existe."));

        // validar saldo suficiente
        if (sender.getBalance() < transactionDTO.getAmount()){
            throw new IllegalArgumentException("Saldo insuficiente en la cuenta del remitente.");
        }

        // Realizar las transferencias de dinero
        sender.setBalance(sender.getBalance() - transactionDTO.getAmount());
        receiver.setBalance(receiver.getBalance() + transactionDTO.getAmount());

        // Guardar los cambios en las cuentas
        customerRepository.save(sender);
        customerRepository.save(receiver);

        // crear y guardar la transaccion
        Transaction transaction = new Transaction();
        transaction.setSenderAccountNumber(sender.getAccountNumber());
        transaction.setReceiverAccountNumber(receiver.getAccountNumber());
        transaction.setAmount(transactionDTO.getAmount());


        transaction = transactionRepository.save(transaction);

        // Devolver la transaccion creada como DTO
        TransactionDTO savedTransaction = new TransactionDTO();
        savedTransaction.setId(transaction.getId());
        savedTransaction.setSenderAccountNumber(transaction.getSenderAccountNumber());
        savedTransaction.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
        savedTransaction.setAmount(transaction.getAmount());

        return savedTransaction;
    }


    public List<TransactionDTO> getTransactionsForAccount(String accountNumber){
        List<Transaction> transactions = transactionRepository.findBySenderAccountNumberOrReceiverAccountNumber(accountNumber, accountNumber);
        return transactions.stream().map(transaction -> {
            TransactionDTO dto = new TransactionDTO();
            dto.setId(transaction.getId());
            dto.setSenderAccountNumber(transaction.getSenderAccountNumber());
            dto.setReceiverAccountNumber(transaction.getReceiverAccountNumber());
            dto.setAmount(transaction.getAmount());
            dto.setTimestamp(transaction.getTimestamp());
            return dto;
        }).collect(Collectors.toList());
    }


}
