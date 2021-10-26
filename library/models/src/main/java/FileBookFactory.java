import com.google.gson.Gson;
import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;
import com.google.gson.reflect.TypeToken;

import javax.inject.Named;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;

import java.util.ArrayList;

public class FileBookFactory implements BooksFactory{
    @NotNull
    private static final Type listBooksType = new TypeToken<ArrayList<Book>>() {}.getType();

    @NotNull
    private final String fileName;

    @Inject
    public FileBookFactory(@NotNull @Named("path_to_file") String fileName) {
        this.fileName = fileName;
    }

    @NotNull
    @Override
    public ArrayList<Book> books() {
        try {
            return new Gson().fromJson(new BufferedReader(new FileReader(fileName)), listBooksType);
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}