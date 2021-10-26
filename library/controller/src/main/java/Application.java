import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
//            args = new String[] {"/home/ayakovlenko/Mail/HW3/books.txt", "30"};
            Injector injector = Guice.createInjector(new ApplicationModule(args));
            Library library = injector.getInstance(LibraryFactory.class).library(ApplicationModule.getCapacity());
            library.writeIntoConsole();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}
