package com.SMB.SMBProject.service;

import com.SMB.SMBProject.model.SMBMessage;
import com.SMB.SMBProject.model.SMBMessageId;
import com.SMB.SMBProject.repository.SMBRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Service
public class SMBService {
    @Autowired
    private SMBRepository smbRepository;
    @Autowired
    private SMBIntegrity smbIntegrity;

    public void add(SMBMessage message) {
        message = smbIntegrity.invalidMessageFormat(message);
        smbRepository.save(message);
    }

//    public void delete(List<SMBMessageId> smbMessageId ) {
//        smbRepository.deleteByMessageId(smbMessageId);
//    }

    public void deleteAll(){
        smbRepository.deleteAll();
    }

    public List<SMBMessage> getMessages() {
        List<SMBMessage> messages = smbRepository.findAll();
        return messages;
    }

    public Optional<SMBMessage> getMessageById(int idTransaction) {
        Optional<SMBMessage> message = smbRepository.findByIdTransaction(idTransaction);
        return message;
    }

    public List<SMBMessage> getMessageByIndicator(String indicator) {
        List<SMBMessage> messages = smbRepository.findByIndicator(indicator);
        return messages;
    }

}
