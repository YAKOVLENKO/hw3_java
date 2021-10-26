import com.google.inject.Inject;
import com.google.inject.name.Named;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> bookCells = new ArrayList<>();
    @Getter
    private final int numberOfCells;

    public Library(int numberOfCells,
                   @NotNull BooksFactory booksFactory) {
        this.numberOfCells = numberOfCells;
        fillBookCells(booksFactory.books());

    }

    private void fillBookCells(List<Book> books) {
        if (this.numberOfCells < books.size()) {
            throw new IllegalArgumentException("В библиотеке недостаточно места для такого количества книг.");
        }
        this.bookCells.addAll(books);
    }

    public Book takeBook(int cellNumber) {
        if (cellNumber + 1 > bookCells.size()) {

            throw new IndexOutOfBoundsException("Ячейка пуста или не существует!");
        }

        Book book = bookCells.get(cellNumber);
        System.out.println(cellNumber);
        System.out.println(this.bookCells.get(cellNumber));
        bookCells.set(cellNumber, null);
        return book;
    }

    public void addBook(Book book) throws Exception {
        int emptyCellNumber = getFirstEmptyCell();
        if (emptyCellNumber >= this.numberOfCells) {
            throw new Exception("Все ячейки заняты!");
        }
        this.bookCells.set(emptyCellNumber, book);
    }

    public void writeIntoConsole() {
        for (Book book: this.bookCells) {
            System.out.println(book);
        }
    }

    private int getFirstEmptyCell() {
        return this.bookCells.indexOf(null);
    }


}