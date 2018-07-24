package com.accenture.arace.springpy;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {

    @Autowired
    JythonService jythonService;

    @GetMapping("/hello-world")
    public void echo() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("hello_world.py"); 
        jythonService.invokeHelloWorld(inputStream);
    }

    @GetMapping("/class")
    public String divider(@RequestParam(value="n") Integer n, @RequestParam(value="d") Integer d) {
        this.getClass().getClassLoader().getResourceAsStream("classcaller.py"); 
        return jythonService.invokeClass(n, d);
    }

}
