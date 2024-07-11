package com.liu.controller;

import com.liu.pojo.Book;
import com.liu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RESTful风格
@RestController
@RequestMapping("/books")
public class BookController {
    //依赖业务层对象
    @Autowired
    private BookService bookService;//子容器[springmbv的ioc容器]可以使用父容器[spring的ioc容器]中的bean

    @PostMapping
    public Result save(@RequestBody Book book) {
        boolean result = bookService.saveBook(book);
        Integer code = result ? Code.SAVE_OK : Code.SAVE_ERR;
        String message = result ? "保存成功" : "保存失败";
        return new Result(code, result, message);
    }

    @PutMapping
    public Result update(@RequestBody Book book) {
        boolean result = bookService.updateBook(book);
        Integer code = result ? Code.UPDATE_OK : Code.UPDATE_ERR;
        String message = result ? "修改成功" : "修改失败";
        return new Result(code, result, message);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean result = bookService.deleteBook(id);
        Integer code = result ? Code.DELETE_OK : Code.DELETE_ERR;
        String message = result ? "删除成功" : "删除失败";
        return new Result(code, result, message);
    }


    @GetMapping("/{id}")
    public Result getBook(@PathVariable Integer id) {
        System.out.println("查询一本图书 => " + id);
        //调用业务层对象，获取图书信息
        Book book = bookService.getBookById(id);

        //创建自定义结果对象
        Result responseResult = new Result();

        Integer code = book != null ? Code.GET_OK : Code.GET_ERR;
        String msg = book != null ? "查询成功" : "查询失败";
        responseResult.setCode(code);
        responseResult.setMsg(msg);
        responseResult.setData( book );//查询到的数据

        return responseResult;//自动把javabean对象，转换为json格式
    }


    @GetMapping
    public Result getBookList() {
        System.out.println("查询图书列表");
        //调用业务层对象，获取图书列表数据
        List<Book> bookList = bookService.getAllBooks();

        Integer code = bookList != null && bookList.size()>0 ? Code.GET_OK : Code.GET_ERR;
        String msg = bookList != null ? "查询成功" : "查询失败";

        Result responseResult = new Result(code , bookList, msg);

        return responseResult;//把Result对象转换为json格式
    }
}
