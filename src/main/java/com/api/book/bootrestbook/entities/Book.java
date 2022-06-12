package com.api.book.bootrestbook.entities;

public class Book {

    private int id;
    private String title;
    private String name;

    public Book(int id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", title=" + title + "]";
    }

}
