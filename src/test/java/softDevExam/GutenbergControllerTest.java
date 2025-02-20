package softDevExam;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.Ignore;

import softDevExam.controller.GutenbergController;
import softDevExam.entity.Book;
import softDevExam.persistence.GutenbergMysql;

public class GutenbergControllerTest {

	@Mock
	private GutenbergMysql mysqlService;

	@InjectMocks
	private GutenbergController controller = new GutenbergController();

	private String city = "Ajax";
	private Book book = new Book("123", "testbook", null);
	private String author = "Frederick Douglass";
	private String location = "123123";
	private List<Book> books;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		books = new ArrayList();
		books.add(book);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	@Ignore
	public void testGetBooksByCityReturnBook() throws Exception {
		when(mysqlService.getBooksByCity(anyString())).thenReturn(books);

		Response result = controller.getBooksByCity(city).build();
		assertThat(result.getEntity(), is(equalTo(books)));
	}
/*
	@Test
	public void testGetCitiesByBookReturnCities() {
		when(mysqlService.getCitiesByBook(anyString())).thenReturn(city);

		Response result = controller.getCitiesByBook(book.getName()).build();
		assertThat(result.getEntity(), is(equalTo(city)));
	}

	@Test
	public void testGetBooksAndCitysByAuthor() {
		when(mysqlService.getBooksAndCitysByAuthor(author)).thenReturn(city);

		Response result = controller.getBooksAndCitysByAuthor(author).build();
		assertThat(result.getEntity(), is(equalTo(city)));
	}
*/
	@Test
	@Ignore
	public void testGetBooksByLocation() throws Exception {
		List<Book> results = new ArrayList<>();
		results.add(book);

		when(mysqlService.getBooksByLocation(12.0, 32.0)).thenReturn(results);

		Response result = controller.getBooksByLocation(12.0, 32.0).build();
		assertThat(result.getEntity(), is(equalTo(results)));
	}

}
