package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {
    //handle request at path http://localhost:8080/hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //handle request at path //http://localhost:8080/hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
//    @GetMapping("/form/{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    //handles requests for http://localhost:8080/hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = 'form/{name}' method = 'POST'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<select name = 'language'>" +
                "<option value= 'English'> English </option>" +
                "<option value= 'Spanish'> Spanish </option>" +
                "<option value= 'French'> French </option>" +
                "<option value= 'German'> German </option>" +
                "<option value= 'Swedish'> Swedish </option>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //Creating a post handler for form submission for name and language input
    @PostMapping("form/{name}")
    public static String createMessage(@RequestParam String name, String language) {

        if (language.equals("Spanish")) {
            return "Hola, " + name + "!";
        } else if (language.equals("French")) {
            return "Bonjour, " + name + "!";
        } else if (language.equals("German")) {
            return "Hallo, " + name + "!";
        } else if (language.equals("Swedish")) {
            return "Hej, " + name + "!";
        } else {
            return "Hello, " + name + "!";
        }
    }


}