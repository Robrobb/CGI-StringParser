package com.example.demo.Controllers;

import com.example.demo.Compute.Parser;
import com.example.demo.DTO.Dto;
import com.example.demo.DTO.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @RequestMapping("/parser")
    public ResponseEntity<List> addInfo(@RequestBody Dto dto) throws IOException {
        Parser parser = new Parser();
        try {
            return new ResponseEntity<>(parser.parse(dto.getText()),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(parser.parse("Error"),HttpStatus.BAD_REQUEST);
        }


    }
}


