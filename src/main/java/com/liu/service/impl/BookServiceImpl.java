package com.liu.service.impl;

import com.liu.dao.BookDao;
import com.liu.pojo.Book;
import com.liu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public boolean saveBook(Book book) {
        int saveResult = bookDao.save(book);
        return saveResult>0?true:false;
    }

    @Override
    public boolean updateBook(Book book) {
        return false;
    }

    @Override
    public boolean deleteBook(Integer id) {
        int deleteResult = bookDao.delete(id);
        return deleteResult>0?true:false;
    }

    @Override
    public Book getBookById(Integer id) {
        Book getByIdResult = bookDao.getById(id);
        return getByIdResult;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = bookDao.getAll();
        return bookList;
    }
}
