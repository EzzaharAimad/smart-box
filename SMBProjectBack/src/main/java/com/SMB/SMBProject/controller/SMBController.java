package com.SMB.SMBProject.controller;

import com.SMB.SMBProject.model.SMBMessage;
import com.SMB.SMBProject.model.SMBMessageId;
import com.SMB.SMBProject.service.SMBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/message")
public class SMBController {
    @Autowired
    private SMBService smbService;

    @ResponseBody
    @PostMapping
    public String postMessage(@RequestBody SMBMessage message) {
        smbService.add(message);
        return message.getStatus() +" : "+ message.getError();
    }

    @ResponseBody
    @GetMapping
    public List<SMBMessage> getMessages() {
        return smbService.getMessages();
    }

//    @GetMapping("/{id}")
//    public Optional<SMBMessage> getMessageById(@PathVariable(required = true) int id){
//    return smbService.getMessageById(id);
//    }

    @GetMapping("/{indicator}")
    public List<SMBMessage> getMessageByIndicator(@PathVariable String indicator){
        return smbService.getMessageByIndicator(indicator);
    }

//    @DeleteMapping("/{smbMessageId}")
//    public String deleteMessage(@PathVariable List<SMBMessageId> smbMessageId){
//        smbService.delete(smbMessageId);
//        return "deleted";
//    }

    @ResponseBody
    @DeleteMapping("/")
    public String deleteMessages(){
        smbService.deleteAll();
        return  "All messages are deleted";
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<SMBMessage> getAll() {
        return smbService.getMessages();
    }
}
