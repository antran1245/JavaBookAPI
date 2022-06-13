package com.example.mvcdemo.services;

import java.util.List;
import java.util.Optional;

//...
import org.springframework.stereotype.Service;

import com.example.mvcdemo.models.Book;
import com.example.mvcdemo.repositories.BookRepository;
@Service
public class BookService {
 // adding the book repository as a dependency
 private final BookRepository bookRepository;
 
 public BookService(BookRepository bookRepository) {
     this.bookRepository = bookRepository;
 }
 // returns all the books
 public List<Book> allBooks() {
     return bookRepository.findAll();
 }
 // creates a book
 public Book createBook(Book b) {
     return bookRepository.save(b);
 }
 // retrieves a book
 public Book findBook(Long id) {
     Optional<Book> optionalBook = bookRepository.findById(id);
     if(optionalBook.isPresent()) {
         return optionalBook.get();
     } else {
         return null;
     }
 }
 
 //update a book
 public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
	 Optional<Book> optionalBook = bookRepository.findById(id);
	 if(optionalBook.isPresent()) {		 
		 Book book = optionalBook.get();
		 book.setTitle(title);
		 book.setDescription(desc);
		 book.setLanguage(lang);
		 book.setNumberOfPages(numOfPages);
		 return book;
	 } else {
		 return null;
	 }
 }
 
 //delete a book
 public void deleteBook(Long id) {
	 bookRepository.deleteById(id);
 }
}
