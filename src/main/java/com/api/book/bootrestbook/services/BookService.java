package com.api.book.bootrestbook.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import com.api.book.bootrestbook.entities.Book;

@Component
public class BookService {
    public static List<Book> list = new ArrayList<>();
    static {
        list.add(new Book(2, "Python", "S.M Sharma"));
        list.add(new Book(3, "Java", "M.M Rama"));
        list.add(new Book(4, "JS", "M.P Sahoo"));
    }

    public List<Book> getAllBooks() {
        return list;
    }

    public Book getBookById(int id) {

        Book book = null;
        try {
            book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return book;
    }

    // Adding Book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    public void deleteBook(int bookId) {
        list = list.stream().filter(book -> book.getId() != bookId).collect(Collectors.toList());
        System.out.println(list);
    }

    // update book
    public void updateBook(Book book, int bookId) {

        list = list.stream().map(b -> {
            if (b.getId() == bookId) {
                b.setTitle(book.getTitle());
                b.setName(book.getName());
            }
            return b;
        }).collect(Collectors.toList());
    }
}
