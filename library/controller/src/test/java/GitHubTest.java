import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.name.Names;
import net.lamberto.junit.GuiceJUnitRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collections;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(GuiceJUnitRunner.class)
@GuiceJUnitRunner.GuiceModules(GitHubTest.TestModule.class)
public class GitHubTest {

    private final Book book1 = new Book("Book1", new Author("Author1"));
    private final Book book2 = new Book("Book2", new Author("Author2"));

    @Inject
    private BooksFactory booksFactory;

    private LibraryFactory libraryFactory;
    private Library library;

    @Before
    public void before() {
        Mockito.when(booksFactory.books()).thenReturn(new ArrayList<>() {{add(book1); add(book2);}});
        libraryFactory = new LibraryFactory(booksFactory);
        library = libraryFactory.library(4);

    }

    @After
    public void after() {
        Mockito.reset();
    }

    @Test
    public void test_check_position() {
        ArrayList<Book> books = booksFactory.books();
        assertEquals(library.takeBook(0), books.get(0));
        assertEquals(library.takeBook(1), books.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void check_empty_chell(){
        library.takeBook(3);
    }



    public static class TestModule extends AbstractModule {
        @Override
        protected void configure() {
            bind(BooksFactory.class).toInstance(Mockito.mock(FileBookFactory.class));
        }
    }
}

