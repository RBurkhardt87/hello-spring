package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@ResponseBody
@Controller
@RequestMapping("hello")
public class HelloController {


    //TODO: Handles request at the root path
    @GetMapping
    public String helloRoot() {
        return "Hello, Spring";
    }

    //TODO: Handles get request at path/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring";
    }

    //TODO: Responds to post requests at "/goodbye"   <---- also at /hello/goodbye
    @PostMapping("goodbye")
    public String goodbyePost() {
        return "Post Goodbye";
    }

    //TODO: Handles request of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //TODO: Create form that submits via post request     <--- lives at /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'>" +
                "<input type='submit' value= 'Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //TODO: Handler will do GET and POST request at the /hello path
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello " + name + "!";
    }
}
