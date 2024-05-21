package com.example.demo;

import com.example.demo.asset.Article;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.ArticleRepo;
import com.example.demo.Service;

import java.net.URI;
import java.util.*;

@Controller
public class GreetingController {
    Service service = new Service();

//    private Map<Integer, HashMap<String, Object>> articles = new HashMap<>();
//    private int nextId = 1;

//    @GetMapping("/introduce")
//    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
//        model.addAttribute("name", name);
//        return "HelloWorld";
//    }

    @GetMapping("/posts")
    public String printPosts(Model model) {
        model.addAttribute("posts", service.getArticleMap());
        return "HelloWorld";
    }


    //Article 모두 출력
    @GetMapping("/article")
    @ResponseBody
    public HashMap<Integer, Article> printArticleMap() {
        return service.getArticleMap();
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
    public Article getArticle(@PathVariable int id) {
        return service.getArticle(id);
    }

    @PostMapping("/article")
    @ResponseBody
    public ResponseEntity createArticle(@RequestBody Article article) {
        if (!service.isContainElements(article)) { //String 값들이 존재하는지 확인
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        service.addArticle(article);
        return ResponseEntity.created(URI.create("/article")).build();
    }

    @PutMapping("/article/{id}")
    @ResponseBody
    public ResponseEntity updateArticle(@PathVariable int id, @RequestBody Article article) {
        if (!service.isContainElements(article)) { //String 값들이 존재하는지 확인
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        service.addArticle(article);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/article/{id}")
    @ResponseBody
    public ResponseEntity deleteArticle(@PathVariable int id) {
        if (service.isExist(id)) {
            service.deleteArticle(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
