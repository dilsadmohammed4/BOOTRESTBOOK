package com.api.book.bootrestbook.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.dao.BookRepository;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> list = (List<Book>) this.bookRepository.findAll();
        return list;
    }

    public Book getBookById(int id) {

        Book book = null;
        try {
            book = this.bookRepository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    // Adding Book
    public Book addBook(Book b) {
        Book result = bookRepository.save(b);
        System.out.println("serv " + result);
        return result;
    }
    //delete book
    public void deleteBook(int bookId) {
        this.bookRepository.deleteById(bookId);
    }

    // update book
    public void updateBook(Book book, int bookId) {
        book.setId(bookId);
        this.bookRepository.save(book);
    }
}
