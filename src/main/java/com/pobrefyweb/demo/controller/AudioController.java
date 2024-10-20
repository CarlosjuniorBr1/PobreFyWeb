package com.pobrefyweb.demo.controller;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://127.0.0.1:4200")
@RestController
@RequestMapping("/api")
public class AudioController {


    @GetMapping("/")
    public String intro(){
        return "Bem vindo ao pobreFy 2.0";
    }
    
    
    @GetMapping("/musica")
    public ResponseEntity<Resource> getAudio() throws IOException {
        // Carrega o arquivo de áudio do diretório resources
        Resource resource = new ClassPathResource("audios/Childish Gambino-Heartbeat.mp3");

        // Configura o cabeçalho de resposta para reprodução de áudio
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);

        return new ResponseEntity<>(resource, headers, HttpStatus.OK);
    }
}
