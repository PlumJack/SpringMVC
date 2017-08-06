package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pl.spring.demo.constants.ModelConstants;
import pl.spring.demo.constants.ViewNames;
import pl.spring.demo.controller.BookController;
import pl.spring.demo.enumerations.BookStatus;
import pl.spring.demo.service.BookService;
import pl.spring.demo.to.BookTo;

public class BookControllerTest {

	private MockMvc mockMvc;

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}

	@Test
	public void shouldGetAllBooks() throws Exception {
		// given
		List<BookTo> listOfAllBooks = new ArrayList<BookTo>();
		listOfAllBooks.add(new BookTo(1L, "title1", "author1", BookStatus.FREE));
		listOfAllBooks.add(new BookTo(2L, "title2", "author2", BookStatus.FREE));
		Mockito.when(bookService.findAllBooks()).thenReturn(listOfAllBooks);
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/all"));
		// then
		resultActions.andExpect(view().name("books"))
				.andExpect(model().attribute(ModelConstants.BOOK_LIST, new ArgumentMatcher<Object>() {
					@Override
					public boolean matches(Object argument) {
						@SuppressWarnings("unchecked")
						List<BookTo> listOfAllBooks = (List<BookTo>) argument;
						assertEquals(2, listOfAllBooks.size());
						return listOfAllBooks != null;
					}
				}));
	}
	
	@Test
	public void shouldGetBookDetails() throws Exception {
		// given
		BookTo theBook = new BookTo(1L, "title1", "author1", BookStatus.FREE);
		Mockito.when(bookService.findBookById(Mockito.anyLong())).thenReturn(theBook);
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/bookDetails?id=3"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOK))
				.andExpect(model().attribute(ModelConstants.BOOK, new ArgumentMatcher<Object>() {
					@Override
					public boolean matches(Object argument) {
						BookTo book = (BookTo) argument;
						assertEquals(theBook, book);
						return book != null;
					}
				}));
	}
	
	@Test
	public void shouldSearchForBooks() throws Exception {
		// given
		List<BookTo> listOfBooks = new ArrayList<BookTo>();
		listOfBooks.add(new BookTo(1L, "title1", "author1", BookStatus.FREE));
		Mockito.when(bookService.findBooksByTitleAndAuthor("title1","author1")).thenReturn(listOfBooks);
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/searchForBooks?title=title1&authors=author1"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOKS))
				.andExpect(model().attribute(ModelConstants.BOOK_LIST, new ArgumentMatcher<Object>() {
					@Override
					public boolean matches(Object argument) {
						@SuppressWarnings("unchecked")
						List<BookTo> listOfBooks = (List<BookTo>) argument;
						assertEquals(1, listOfBooks.size());
						return listOfBooks != null;
					}
				}));
	}
	
	@Test
	public void shouldDeleteBooks() throws Exception {
		// given
		BookTo theBook = new BookTo(1L, "title1", "author1", BookStatus.FREE);
		Mockito.when(bookService.findBookById(Mockito.anyLong())).thenReturn(theBook);
		// when
		ResultActions resultActions = mockMvc.perform(get("/books/deleteBook?id=3"));
		// then
		resultActions.andExpect(view().name(ViewNames.BOOKDELETED))
				.andExpect(model().attribute(ModelConstants.BOOK, new ArgumentMatcher<Object>() {
					@Override
					public boolean matches(Object argument) {
						BookTo book2 = (BookTo) argument;
						assertEquals(theBook, book2);
						return book2 != null;
					}
				}));
	}
	
}
