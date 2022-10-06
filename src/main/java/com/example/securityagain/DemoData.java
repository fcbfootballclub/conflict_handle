package com.example.securityagain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(path = "/demo")
public class DemoData {
    @GetMapping(path = "")
    public ResponseEntity<?> getDemo() {
        return ResponseEntity.ok("This is data");
    }
}
