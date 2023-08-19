package com.bookStore.controller;

import com.bookStore.entity.Books;
import com.bookStore.entity.MyBookList;
import com.bookStore.service.BookService;
import com.bookStore.service.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_books")
    public ModelAndView getAllBooks(){
        List<Books> list=bookService.getAllBooks();
        return new ModelAndView("bookList","book",list);
    }
    @PostMapping("/save")
    public String addBook(@ModelAttribute Books books){
        bookService.save(books);
        return"redirect:/available_books";
    }
//    @GetMapping("/my_books")
//    public String myBooks(){
//        return "myBooks";
//    }
    @GetMapping("/my_books")
    public String getMyBooks(Model model){
        List<MyBookList> list=myBookService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBooks";
    }
    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Integer id){
        Books books=bookService.getBooksById(id);
        MyBookList myBookList=new MyBookList(books.getId(),books.getName(),books.getAuthor(),books.getPrice());
        myBookService.saveMyBooks(myBookList);
        return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Integer id,Model model){
        Books books=bookService.getBooksById(id);
        model.addAttribute("book",books);
        return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Integer id){
        bookService.deleteById(id);
        return "redirect:/available_books";
    }

}
