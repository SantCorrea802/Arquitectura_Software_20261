package com.udea.bank.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import java.time.LocalDateTime;

//POJO --> Plain old java object



@Data
@Entity
@Table(name="transaction") // Nombre de la tabla en la base de datos
                            // Y parte del mapeo con la base de datos
public class Transaction { // nombre de la tabla pero en el codigo
    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autogenerado
    private Long id; // nombre de la primary key

    public Transaction() {
    }

    public Transaction(Long id, String senderAccountNumber, String receiverAccountNumber, Double amount, LocalDateTime timestamp) {
        this.id = id;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    // nombre de la columna en la base de datos y el nombre del atributo en el codigo
    // nullable = false indica que los datos seran obligatorios
    @Column(name="sender_account_number", nullable = false)
    private String senderAccountNumber;

    @Column(name="receiver_account_number", nullable = false)
    private String receiverAccountNumber;

    @Column(nullable = false)
    private Double amount;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public void setReceiverAccountNumber(String receiverAccountNumber) {
        this.receiverAccountNumber = receiverAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Column(nullable=false)
    private LocalDateTime timestamp;

}
