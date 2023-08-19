package com.bookStore.service;

import com.bookStore.entity.Books;
import com.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public void save(Books books){
        bookRepository.save(books);
    }
    public List<Books> getAllBooks(){
        return bookRepository.findAll();
    }
    public Books getBooksById(Integer id){
        return bookRepository.findById(id).get();
    }
    public void deleteById(Integer id){
        bookRepository.deleteById(id);
    }

}
