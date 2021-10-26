import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.name.Names;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ApplicationModule extends AbstractModule {

    @NotNull @Getter
    private static int capacity;

    @NotNull @Getter
    private static String filePath;

    public ApplicationModule(String[] applicationParams) {
        checkParamLength(applicationParams);
        filePath = applicationParams[0];
        capacity = getIntCapacity(applicationParams[1]);
    }

    private void checkParamLength(String[] applicationParams) {
        if (applicationParams.length != 2) {
            throw new IllegalArgumentException("Программа принимает два параметра!");
        }
    }

    private int getIntCapacity(String capacity) {
        int intCapacity = Integer.parseInt(capacity);
        if (intCapacity < 0) {
            throw new IllegalArgumentException("Вместимость библиотеки должна быть по меньшей мере 0!");
        }
        return intCapacity;
    }

    @Override
    protected void configure() {
        install(new ModelsModule(filePath));
        bind(BooksFactory.class).to(FileBookFactory.class);
    }
}
