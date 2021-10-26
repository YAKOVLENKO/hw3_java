import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.Test;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;

public class MyTest {

    private Injector injector = Guice.createInjector(new MyTestModule());
    private LibraryFactory libraryFactory = injector.getInstance(LibraryFactory.class);

    @Test(expected = IllegalArgumentException.class)
    public void CheckSmallLibrary() {
        libraryFactory.library(2);
    }
}
