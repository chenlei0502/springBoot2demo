package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/getbook")
	public Book book() {
		Book book = new Book();
		book.setId(1);
		book.setName("三国演义");
		book.setAuthor("罗贯中");
		book.setPrice(null);
		book.setCationdate(new Date());
		return book;
	}

	@GetMapping("/addBook")
	public void bookOps() {
		Book book = new Book();
		book.setName("三国演义");
		book.setAuthor("罗贯中");
		int i = bookService.addBook(book);
		System.out.println("添加图书成功！" + i);
	}

	@GetMapping("/updateBook")
	public int updateBook(@RequestParam("id") Integer id, @RequestParam("name") String name,
			@RequestParam("author") String author) {
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAuthor(author);
		int i = bookService.updateBook(book);
		System.out.println("修改图书成功！" + i);
		return i;
	}

	@GetMapping("/deleteBook")
	public int deleteBook(@RequestParam("id") Integer id) {

		return bookService.delete(id);
	}

	@GetMapping("/getBook")
	public Book bookOps(@RequestParam("id") Integer id) {
		Book book = bookService.getBookById(id);
		return book;
	}

	@GetMapping("/getbooklist")
	public List<Book> getbooklist() {
		List<Book> books = bookService.findAllBooks();
		System.out.println("获取图书列表！" + books);
		return books;
	}

}
