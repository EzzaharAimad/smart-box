package com.SMB.SMBProject.repository;

import com.SMB.SMBProject.model.SMBMessage;
import com.SMB.SMBProject.model.SMBMessageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SMBRepository extends JpaRepository<SMBMessage, SMBMessageId> {

    //@Modifying
    //@Query("delete from SMBMessage messages where messages.idTransaction=:idTransaction AND  messages.merchantNumber=:merchantNumber AND messages.bagNumber=:bagNumber AND messages.transmissionDate=:transmissionDate")
    //void deleteByMessageId(List<SMBMessageId> smbMessageId);

    Optional<SMBMessage> findByIdTransaction(Integer idTransaction);

    List<SMBMessage> findByIndicator(String indicator);
}
