import com.google.inject.AbstractModule;
import org.mockito.Mockito;

import java.util.ArrayList;

public class MyTestModule extends AbstractModule {
    @Override
    protected void configure() {
        FileBookFactory fileBookFactory = Mockito.mock(FileBookFactory.class);
        Mockito.when(fileBookFactory.books()).thenReturn(new ArrayList<>() {{
            add(new Book("Book1", new Author("Author1")));
            add(new Book("Book2", new Author("Author2")));
            add(new Book("Book3", new Author("Author3")));
        }});
        bind(BooksFactory.class).toInstance(fileBookFactory);
    }
}
