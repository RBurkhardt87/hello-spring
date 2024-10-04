package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("hello")
public class HelloController {
    //handle request at path http://localhost:8080/hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //handle request at path //http://localhost:8080/hello/goodbye
    @ResponseBody
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }





    //handle requests of the form http://localhost:8080/hello?name=LaunchCode

    //NOTE: in the model.addAttribute(first, second);
    //the first MUST match ${first} located in the html file
    //the second MUST match the variable being declared in the handler
    //EXAMPLE:  greeting matches ${greeting} in hello.html
    //          theGreeting = "Hello," + name + "!"  matches theGreeting in the .addAttribute
    //Method creates a String and adds that String as a variable to the model. Model is then passed into the view when we
    //render the template by returning the template's name


    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String theGreeting = "Hello," + name + " !";
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
//    @GetMapping("/form/{name}")
//    public String helloWithPathParam(@PathVariable String name) {
//        return "Hello, " + name + "!";
//    }

    //handles requests for http://localhost:8080/hello/form
    //form is the name of our html thymeleaf file. Since we are returning a template we remove @ResponseBody
    //Also, because there's no @ResponseBody, when spring boot sees us returning a String, it already assumes it is the
    //name of a template, and then goes to render the template.
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    //Creating a post handler for form submission for name and language input

    @PostMapping("form/{name}")
    public static String createMessage(@RequestParam String name, String language, Model model) {
        String theGreeting = "Hello, " + name + " !";
        model.addAttribute("greeting", theGreeting);
        return "hello";
//        if (language.equals("Spanish")) {
//            return "Hola, " + name + "!";
//        } else if (language.equals("French")) {
//            return "Bonjour, " + name + "!";
//        } else if (language.equals("German")) {
//            return "Hallo, " + name + "!";
//        } else if (language.equals("Swedish")) {
//            return "Hej, " + name + "!";
//        } else {
//            return "Hello, " + name + "!";
//        }
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("Rachel");
        names.add("Miles");
        names.add("Darryn");
        model.addAttribute("names", names);
        return "hello-list";
    }

}