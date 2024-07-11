package com.liu;

import com.liu.config.SpringConfig;
import com.liu.pojo.Book;
import com.liu.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)//spring整合junit
@ContextConfiguration(classes = SpringConfig.class)
public class BookServiceTest {
    @Autowired
    BookService bookService;
    @Test
    public void testGetAll(){
        List<Book> bookList = bookService.getAllBooks();
        for (Book book : bookList) {
            System.out.println(book);
        }
    }
    @Test
    public void testGetBookById(){
        Book book = bookService.getBookById(5);
        System.out.println(book);
    }
    @Test
    public void testSave(){
        Book book1 = new Book();
        book1.setId(7);
        book1.setName("java从入门到入土");
        book1.setType("java");
        book1.setDescription("java牛逼");
        boolean result = bookService.saveBook(book1);
        System.out.println(result);
    }
    @Test
    public void testDeleteById(){
        boolean result = bookService.deleteBook(5);
        System.out.println(result);
    }
}
