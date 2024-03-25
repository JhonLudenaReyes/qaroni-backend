package com.webservice.qaroni.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservice.qaroni.model.dao.AuthorDaoRepository;
import com.webservice.qaroni.model.dao.BookDaoRepository;
import com.webservice.qaroni.model.entity.Book;
import com.webservice.qaroni.repository.BookRepository;

@Service
public class BookService implements BookRepository{
	
	@Autowired
	private BookDaoRepository bookDaoRepository;
	
	@Autowired
	private AuthorDaoRepository authorDaoRepository;

	@Override
	public Optional<List<Book>> getActiveBooksAuthor() {
		// TODO Auto-generated method stub
		return bookDaoRepository.findAllByState("A");
	}

	@Override
	public Optional<List<Book>> getListActiveBooks() {
		// TODO Auto-generated method stub
		return bookDaoRepository.getActiveBooks("A");
	}

	@Override
	public Book save(Book book) {
		// TODO Auto-generated method stub
		return bookDaoRepository.save(book);
	}

	@Override
	public Optional<Book> getBookById(Integer bookId) {
		// TODO Auto-generated method stub
		return bookDaoRepository.findByBookIdAndState(bookId, "A");
	}

	@Override
	public Integer getTotalBooks() {
		// TODO Auto-generated method stub
		return bookDaoRepository.getTotalBooks();
	}

	@Override
	public ByteArrayInputStream exportAllData() throws Exception{
		// TODO Auto-generated method stub
		
		String[] columns = {"Total_libros", "Total_autores"};
		
		Workbook workbook = new HSSFWorkbook();
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		
		Sheet sheet = workbook.createSheet("Resumen");
		
		Row row = sheet.createRow(0);
		
		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
		}
		
		Integer totalBooks = bookDaoRepository.getTotalBooks();
		Integer totalAuthors = authorDaoRepository.getTotalAuthors();
		
		int initRow = 1;
		
		row = sheet.createRow(initRow);
		row.createCell(0).setCellValue(totalBooks);
		row.createCell(1).setCellValue(totalAuthors);
		
		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}
	

}
