package com.example.convertoperation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class ConvertController {

    @GetMapping("/tltodollar")
    public ResponseEntity<String > TlToDollar(){


        return new ResponseEntity<>("1 TL = 0,1199040767386091 Dollar" , HttpStatus.OK);

    }

    @GetMapping("/dollartotl")
    public ResponseEntity<String> dollarToTl (){

        return new ResponseEntity<>("1 Dollar = 8.34 TL" ,HttpStatus.OK);

    }

}
