package ru.java.library.service;

import ru.java.library.entity.Book;
import ru.java.library.repository.BookRepository;

/**
 * Основной класс сервис книг, имплементирует интерфейс сервис для работы с книгами
 */

public class BookServiceImpl implements BookService{

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void showAll() {
        bookRepository.showAll().stream().forEach(System.out::println);
    }

    @Override
    public Book showOneBook(Integer id) {
        return bookRepository.showOne(id);
    }

    @Override
    public void addBook(Book book) {
        bookRepository.addItem(book);
    }

    @Override
    public void editBook(Book book, Integer id) {
        bookRepository.editItem(book, id);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRepository.removeItem(id);
    }
}
