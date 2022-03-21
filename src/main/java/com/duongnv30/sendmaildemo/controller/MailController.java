package com.duongnv30.sendmaildemo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duongnv30.sendmaildemo.dto.sdi.ClientSdi;
import com.duongnv30.sendmaildemo.service.ClientService;

@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/")
	public ResponseEntity<String> echo(@PathParam("name") String name){
		return ResponseEntity.ok().body("Hello: " +  name);
	}
	
	@GetMapping("/sendMail")
    public ResponseEntity<Boolean> create(@PathParam("name") String name, @PathParam("username") String username, @PathParam("email") String email) {		ClientSdi sdi = new ClientSdi();
		sdi.setName(name);
		sdi.setUsername(username);
		sdi.setEmail(email);
        return ResponseEntity.ok(clientService.create(sdi));
    }
}
