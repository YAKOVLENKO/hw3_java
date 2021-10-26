import lombok.Data;
import org.jetbrains.annotations.NotNull;

@Data
public class Author {

    @NotNull
    private final String name;

}