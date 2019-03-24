package br.com.danilodorgam.desafio.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Danilo Dorgam
 * @version 0.1.0
 * @email danilodorgam@gmail.com
 */

@RestController
@RequestMapping(path = "user")
public class UserController {

    @GetMapping()
    public ResponseEntity listar(){

        System.out.println("Logado");
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
