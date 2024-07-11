package com.liu.service.impl;

import com.liu.controller.Code;
import com.liu.dao.BookDao;
import com.liu.exception.BusinessException;
import com.liu.exception.SystemException;
import com.liu.pojo.Book;
import com.liu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bookService") //当前类对象由Spring管理
public class BookServiceImpl implements BookService {
    //需要依赖dao层对象
    @Autowired
    private BookDao bookDao;

    @Override
    public boolean saveBook(Book book) {
        System.out.println("添加图书 => " + book);
        int saveResult = bookDao.save(book);
        return saveResult > 0 ? true : false;
    }

    @Override
    public boolean updateBook(Book book) {
        System.out.println("修改图书 => " + book);
        int updateResult = bookDao.update(book);
        return updateResult > 0 ? true : false;
    }

    @Override
    public boolean deleteBook(Integer id) {
        System.out.println("删除图书 => " + id);
        int deleteResult = bookDao.delete(id);
        return deleteResult > 0 ? true : false;
    }

    @Override
    public Book getBookById(Integer id) {
        System.out.println("根据id查询图书 => " + id);

        //业务逻辑判断：传递参数的合法性（用户录入）
        if (id < 0) {
            //业务异常: 用户造成的
            throw new BusinessException(Code.BUSINESS_ERR, "用户id不能为负数");
        }

        Book book = null;
        try {
            //数据库可能有问题抛出异常
            book = bookDao.getById(id);
        } catch (Exception e) {
            throw new SystemException(Code.SYSTEM_ERR, "当前访问人数较多,请稍后访问");
        }

        //模拟未知异常
        int i = 1 / 0;

        return book;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> bookList = bookDao.getAll();
        return bookList;
    }
}
