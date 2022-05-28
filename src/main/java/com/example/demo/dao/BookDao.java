package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Book;

@Repository
public class BookDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	/**
	 * 新增用户
	 * 
	 * @param user
	 */
	public int addBook(Book book) {
		String sql = "insert into book( name, author) values(?,?)";
		return jdbcTemplate.update(sql, book.getName(), book.getAuthor());
	}

	/**
	 * 修改用户
	 * 
	 * @param user
	 */
	public int updateBook(Book book) {
		String sql = "update book set name=?,author=? where id=?";
		return jdbcTemplate.update(sql, book.getName(), book.getAuthor(), book.getId());
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 */
	public int delete(int id) {
		String sql = "delete from book where id=?";
		return jdbcTemplate.update(sql, id);
	}

	/**
	 * 获取指定用户
	 * 
	 * @param user
	 */
	public Book getBookById(int id) {
		String sql = " select * from  book where id=?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Book>(Book.class), id);
	}

	/**
	 * 查询全部用户
	 * 
	 * @return
	 */
	public List<Book> findAll() {
		String sql = "select * from book";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper(Book.class));
	}
}
