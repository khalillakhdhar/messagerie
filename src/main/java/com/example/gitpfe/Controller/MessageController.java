package com.example.gitpfe.Controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.example.gitpfe.exception.ResourceNotFoundException;
import com.example.gitpfe.model.Message;
import com.example.gitpfe.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@RestController
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins = "localhost:3000", maxAge = 3600)

public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    // Get All Messages
@GetMapping("/message")
public List<Message> getMessages() {
    return (List<Message>) messageRepository.findAll();
}
// Create a new Message
@PostMapping("/messages")
public Message createMessage(@Valid @RequestBody Message message) {
    return messageRepository.save(message);
}

// Get a Single Message
@GetMapping("/messages/{id}")
public Message getMessageById(@PathVariable(value = "id") Long messageId) {
    return messageRepository.findById(messageId)
            .orElseThrow(() -> new ResourceNotFoundException("Message", "id", messageId));
}
   
// Delete a Message
@DeleteMapping("/messages/{id}")
public ResponseEntity<?> deleteMessage(@PathVariable(value = "id") Long messageId) {
    Message message = messageRepository.findById(messageId)
            .orElseThrow(() -> new ResourceNotFoundException("Message", "id", messageId));

    messageRepository.delete(message);

    return ResponseEntity.ok().build();
}
}