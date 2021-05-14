package pl.mrook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mrook.model.Book;
import pl.mrook.model.MemoryBookService;

import java.util.List;

@RestController
public class BookController {

    private MemoryBookService books;

    @Autowired
    public BookController(MemoryBookService memoryBookService) {
        this.books = memoryBookService;
    }

    @RequestMapping(value = "/helloBook", produces = "application/json; charset=UTF-8")
    public Book helloBook() {
        return new Book(1L, "9788324631766", "Thinking in Java",
                "Bruce Eckel", "Helion", "programming");
    }

    @GetMapping(value = "/books", produces = "application/json; charset=UTF-8")
    public List<Book> allBooks() {
        return this.books.getAllBooks();
    }

    @GetMapping(value = "/books/{id}", produces = "application/json; charset=UTF-8")
    public Book bookById(@PathVariable long id) {
        return this.books.getById(id);
    }

    @PostMapping("/books")
    public void addBook(@RequestBody Book book) {
        this.books.addBook(book);
    }

    @PutMapping("/books")
    public void editBook(@RequestBody Book book) {
        this.books.editBook(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable long id) {
        this.books.deleteBook(id);
    }


}
