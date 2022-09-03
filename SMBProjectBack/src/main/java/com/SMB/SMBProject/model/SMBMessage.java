package com.SMB.SMBProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
@Table(name = "messages")
@IdClass(SMBMessageId.class)
public class SMBMessage implements Serializable {
    @Id
    @Column(name="idTransaction", length=10)
    private Integer idTransaction;

    @Id
    @Column(name="merchantNumber", length=15)
    private Integer merchantNumber;

    @Id
    @Column(name="bagNumber", length=14)
    private String bagNumber;

    @Id
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSS")
    @Column(name="transmissionDate", length=26)
    private Date transmissionDate;
//    @CreatedDate
//    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
//    @Column(name="dateTime", length=26)
//    private LocalDateTime dateTime = LocalDateTime.now();
    @Column(name = "indicator")
    private String indicator; //D,R,V
    @Column(name="sequenceNumber", length=4)
    private Integer sequenceNumber ;
    @Column(name="outletNumber", length=15)
    private String outletNumber;
    //    private String containerType; //notes or coins;
//    private double amount;
//    private int notesAmount;
//    private int coinsAmount;
//    private Date dateAndTime;
//    private int denomination1;
//    private int denomination2;
//    private int denomination3;
//    private int denomination4;
//    private int denomination5;
//    private int denomination6;
//    private int denomination7;
//    private int denomination8;
//    private int denomination9;
//    private int denomination10;
//    private int denomination11;
    private String status;
    private String error;

    public SMBMessage() {
    }

    public SMBMessage(int idTransaction, Integer merchantNumber, String bagNumber, Date transmissionDate, String indicator, Integer sequenceNumber, String outletNumber, String status, String error) {
        this.idTransaction = idTransaction;
        this.merchantNumber = merchantNumber;
        this.bagNumber = bagNumber;
        this.transmissionDate = transmissionDate;
        this.indicator = indicator;
        this.sequenceNumber = sequenceNumber;
        this.outletNumber = outletNumber;
        this.status = status;
        this.error = error;
    }
}

