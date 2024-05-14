
package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Objects;

@Controller
public class GreetingController {

    @GetMapping("/introduce")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "HelloWorld";
    }
    @ResponseBody
    @GetMapping("/json")
    public HashMap<String, Object> printJson() {
        HashMap<String, Object> user = new HashMap<>();
        user.put("name", "김민준");
        user.put("age", 21);
        return user;
    }
}