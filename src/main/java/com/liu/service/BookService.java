package com.liu.service;

import com.liu.pojo.Book;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookService {
    /**
     *增
     * @param book
     * @return boolean
     **/
    @Transactional
    public boolean saveBook(Book book);
    /**
     *改
     * @param book
     * @return boolean
     **/
    @Transactional
    public boolean updateBook(Book book);
    /**
     *删
     * @param id
     * @return boolean
     **/
    @Transactional
    public boolean deleteBook(Integer id);
    /**
     *根据id进行查询
     * @param id
     * @return com.liu.pojo.Book
     **/
    public Book getBookById(Integer id);
    /**
     *查询所有
     * @return java.util.List<com.liu.pojo.Book>
     **/
    public List<Book> getAllBooks();
}
