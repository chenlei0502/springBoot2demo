package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookDao;
import com.example.demo.dao.mapper.BookMapper;
import com.example.demo.model.Book;

@Service
public class BookService {

	@Autowired
	private BookDao bookDao;

	public int addBook(Book book) {
		return bookDao.addBook(book);
	}
	
	public int updateBook(Book book) {
		return bookDao.updateBook(book);
	}

	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	public int delete(int id) {
		return bookDao.delete(id);
	}

	public List<Book> findAll() {
		return bookDao.findAll();
	}
	
	//mybatis持久化
	@Autowired
	private BookMapper bookMapper;
	
	public List<Book> findAllBooks() {
		return bookMapper.selectByExample(null);
	}

}
