package com.SMB.SMBProject.service;

import com.SMB.SMBProject.model.SMBMessage;
import com.SMB.SMBProject.model.SMBMessageId;
import com.SMB.SMBProject.repository.SMBRepository;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMBIntegrity {
    @Autowired
    private SMBRepository smbRepository;

    public SMBMessage invalidMessageFormat(SMBMessage smbMessage) {
        //Message indicator is not recognized or not present.
        if (!smbMessage.getIndicator().equals("D") && !smbMessage.getIndicator().equals("R") && !smbMessage.getIndicator().equals("V")) {
            smbMessage.setStatus("INV");
            smbMessage.setError("Message indicator is not recognized or not present.");

        }
        //Merchant number is not present.
        else if (smbMessage.getMerchantNumber() == null) {
            smbMessage.setStatus("INV");
            smbMessage.setError("Merchant number is not present.");
        }
        //Device number is not present.
        else if (smbMessage.getOutletNumber() == null) {
            smbMessage.setStatus("INV");
            smbMessage.setError("Outlet number is not present.");
        }
        //Sequence number is not present.
        else if (smbMessage.getSequenceNumber() == null) {
            smbMessage.setStatus("INV");
            smbMessage.setError("Sequence number is not present.");
        }
        //Bag number is not present.
        else if (smbMessage.getBagNumber() == null) {
            smbMessage.setStatus("INV");
            smbMessage.setError("Bag number is not present.");
        } else {
            smbMessage.setStatus("000");
            smbMessage.setError("");
        }

        return smbMessage;
    }
}
