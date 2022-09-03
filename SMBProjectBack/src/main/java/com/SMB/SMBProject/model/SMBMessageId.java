package com.SMB.SMBProject.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Data
public class SMBMessageId implements Serializable {

    //@Column(name="idTransaction", length=10)
    private Integer idTransaction;

    //@Column(name="merchantNumber", length=15)
    private Integer merchantNumber;

    //@Column(name="bagNumber", length=14)
    private String bagNumber;

//    @CreatedDate
//    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
//    @Column(name="dateTime", length=26)
//    private LocalDateTime dateTime = LocalDateTime.now();
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSSS")
    @Column(name="transmissionDate", length=26)
    private Date transmissionDate;

    public SMBMessageId() {
    }

    public SMBMessageId(int idTransaction, Integer merchantNumber, String bagNumber, Date transmissionDate) {
        this.idTransaction = idTransaction;
        this.merchantNumber = merchantNumber;
        this.bagNumber = bagNumber;
        this.transmissionDate = transmissionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SMBMessageId that = (SMBMessageId) o;
        return idTransaction == that.idTransaction && merchantNumber.equals(that.merchantNumber) && bagNumber.equals(that.bagNumber) && transmissionDate.equals(that.transmissionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTransaction, merchantNumber, bagNumber, transmissionDate);
    }
}
