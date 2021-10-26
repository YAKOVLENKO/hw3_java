import com.google.inject.Inject;
import lombok.Getter;

import javax.inject.Named;

public class LibraryFactory {


    private final BooksFactory booksFactory;

    @Inject
    public LibraryFactory(BooksFactory booksFactory) {
        this.booksFactory = booksFactory;
    }

    public Library library(int capacity) {
        return new Library(capacity, booksFactory);
    }
}
