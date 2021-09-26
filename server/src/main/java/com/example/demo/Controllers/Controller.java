package com.example.demo.Controllers;

import com.example.demo.Compute.Parser;
import com.example.demo.DTO.Dto;
import com.example.demo.DTO.Response;
import org.junit.validator.ValidateWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @RequestMapping ("/parser")
    public ResponseEntity<List> addInfo(@Validated @RequestBody Dto dto) throws IOException {
        Parser parser = new Parser();
        try {
            return new ResponseEntity<>(parser.getWordCount(dto.getText()),HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }
}


