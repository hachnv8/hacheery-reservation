package com.hacheery.reservation.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HachNV on Feb 21, 2023
 */
@RestController
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {
    @GetMapping()
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("hello from secure endpoint");
    }
}
