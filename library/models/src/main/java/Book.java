import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Book {

    @NotNull
    private final String name;

    @NotNull
    private final Author author;


}