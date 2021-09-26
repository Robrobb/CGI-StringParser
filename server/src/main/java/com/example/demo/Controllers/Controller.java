package com.example.demo.Controllers;
import com.example.demo.Compute.Parser;
import com.example.demo.DTO.Dto;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @RequestMapping("/parser")
    public List<String> addInfo(@RequestBody Dto dto ) throws IOException {
        Parser parser=new Parser();


        return parser.parse(dto.getText());
    }
}


