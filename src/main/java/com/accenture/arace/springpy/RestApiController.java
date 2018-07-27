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

    @GetMapping("/svn")
    public String goSvnGo() {
        InputStream initInputStream = this.getClass().getClassLoader().getResourceAsStream("python/init.py");
        jythonService.execScriptAsInputStream(initInputStream);
        return jythonService.execMethodInPyClass("main", "Main", "launchAndDebug");
    }

}
