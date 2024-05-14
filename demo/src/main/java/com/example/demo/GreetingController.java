package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class GreetingController {

    private Map<Integer, HashMap<String, Object>> articles = new HashMap<>();
    private int nextId = 1;

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

    @GetMapping("/article/{id}")
    @ResponseBody
    public HashMap<String, Object> getArticle(@PathVariable int id) {
        return articles.get(id);
    }

    @PostMapping("/article")
    @ResponseBody
    public HashMap<String, Object> createArticle(@RequestBody HashMap<String, Object> article) {
        articles.put(nextId, article);
        nextId++;
        return article;
    }

    @PutMapping("/article/{id}")
    @ResponseBody
    public HashMap<String, Object> updateArticle(@PathVariable int id, @RequestBody HashMap<String, Object> updatedArticle) {
        HashMap<String, Object> existingArticle = articles.get(id);
        if (existingArticle != null) {
            existingArticle.putAll(updatedArticle);
            return existingArticle;
        } else {
            return null; // or handle error appropriately
        }
    }

    @DeleteMapping("/article/{id}")
    @ResponseBody
    public String deleteArticle(@PathVariable int id) {
        if (articles.containsKey(id)) {
            articles.remove(id);
            return "Article with ID " + id + " deleted successfully";
        } else {
            return "Article with ID " + id + " does not exist";
        }
    }
}
