package be.solodoukhin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DefaultController {

    @Value("${app.version}")
    private String projectVersion;

    @GetMapping
    public String sayHello(){
        return "Hello world !";
    }

    @GetMapping(path = "/version")
    public String getVersion(){
        return this.projectVersion;
    }
}
