package com.example.demo.Controllers;
import com.example.demo.Compute.Parser;
import com.example.demo.DTO.Dto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @RequestMapping ("/parser")
    public ResponseEntity<List> addInfo(@Valid @RequestBody Dto dto) throws IOException {
        try {
            Parser parser = new Parser();
            List<String> parsedList = parser.getWordCount(dto.getText());
            return new ResponseEntity<>(parsedList,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }


    }
}


