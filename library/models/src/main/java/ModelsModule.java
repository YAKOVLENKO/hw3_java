import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class ModelsModule extends AbstractModule {

    private final String pathToBooks;

    public ModelsModule(String pathToBooks) {
        this.pathToBooks = pathToBooks;
    }

    @Override
    protected void configure() {
        bind(String.class).annotatedWith(Names.named("path_to_file")).toInstance(pathToBooks);
    }
}
