package com.bookStore.controller;

import com.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MybookController {
    @Autowired
    private MyBookService myBookService;

    @PostMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Integer id){
        myBookService.deleteById(id);
        return "redirect:/my_books";
    }

}
