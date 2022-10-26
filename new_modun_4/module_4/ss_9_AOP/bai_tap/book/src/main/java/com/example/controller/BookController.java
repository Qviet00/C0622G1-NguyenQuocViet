package com.example.controller;

import com.example.model.Book;
import com.example.model.Order;
import com.example.service.IBookService;
import com.example.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;

    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    public String showList(Model model) {
        List<Book> bookList = bookService.findAll();
        model.addAttribute("book", bookList);
        return "/book/list";
    }

    @GetMapping("/{id}/order")
    public String order(@PathVariable int id, Model model) {
        Order orderBook = new Order();
        int code = (int) (Math.random() * (99999 - 10000) + 10000);
        orderBook.setCode(code);

        orderBook.setDate(new Date(System.currentTimeMillis()));

        orderBook.setBook(bookService.findById(id));
        orderService.save(orderBook);

        model.addAttribute("order", orderBook);

        model.addAttribute("book", bookService.findById(id));

        return "/book/display";
    }

    @PostMapping("/order")
    public String submitOrder(@RequestParam int id, Model model) throws Exception {
        Book books = bookService.findById(id);
        books.setCount(books.getCount() - 1);

        if (books.getCount() == -1) {
            throw new Exception();
        }

        bookService.save(books);
        model.addAttribute("book", bookService.findAll());
        return "book/list";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("book", bookService.findById(id));
        model.addAttribute("orderBook", orderService.findAll());
        return "book/view";
    }

    @ExceptionHandler(Exception.class)
    public String handleError() {
        return "error";
    }
}
