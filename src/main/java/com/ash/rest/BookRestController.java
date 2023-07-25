package com.ash.rest;

import com.ash.request.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BookRestController {

    Map<Integer, Book> bookMap = new HashMap<>();
    int count = 1;

    @GetMapping(value = "/book/{bookId}" , produces = {"application/xml", "application/json"})
    public Book getBook(@PathVariable Integer bookId){
        for (Map.Entry<Integer, Book> id: bookMap.entrySet()) {
            if(id.getKey() == bookId){
                return id.getValue();
            }
        }
//        Book book = new Book();
//        book.setName("wings of fly");
//        book.setPrice(Double.valueOf("100.01D"));
//        if(bookId == 100){
//            return book;
//        }
        return null;
    }

    @PostMapping(value = "/addBook", consumes = {"application/xml", "application/json"})
    public ResponseEntity<String> addBook(@RequestBody Book book){
        book.setId(count);
        bookMap.put(count++, book);
        return new ResponseEntity<>("Books Added", HttpStatus.CREATED);
    }
}
