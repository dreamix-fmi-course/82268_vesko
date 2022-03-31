package service;

import model.Book;
import repository.StoreDB;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BookStore implements Store {

    private StoreDB dataBase = new StoreDB();

    @Override
    public boolean add(Book book)
    {
        Book fromDB = dataBase.getByKey(book.getISBN());

        if(book.equals(fromDB)){
            return false;
        }

        dataBase.add(book);
        return true;
    }

    @Override
    public void remove(Book book)
    {
        dataBase.remove(book.getISBN());
    }

    @Override
    public void clear()
    {
        dataBase.clear();
    }

    @Override
    public List<Book> getAllBooksByAuthor(String author)
    {
        return dataBase.getAll().stream()
                .filter(book -> book.getAuthor() == author)
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksPublishedAfter(LocalDate from)
    {
        return dataBase.getAll().stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .collect(Collectors.toList());
    }

    @Override
    public List<Book> getAllBooksBetween(LocalDate from, LocalDate to)
    {
        return dataBase.getAll().stream()
                .filter(book -> book.getPublishedYear().isAfter(from))
                .filter(book -> book.getPublishedYear().isBefore(to))
                .collect(Collectors.toList());
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByAuthor()
    {
        return dataBase.getAll().stream().collect(Collectors.groupingBy(Book::getAuthor));
    }

    @Override
    public Map<String, List<Book>> getAllBooksGroupByPublisher()
    {
        return dataBase.getAll().stream().collect(Collectors.groupingBy(Book::getPublisher));
    }

    @Override
    public List<Book> getAllBooksFilterBy(Predicate<Book> bookPredicate)
    {
        return dataBase.getAll().stream().filter(bookPredicate).collect(Collectors.toList());
    }
}
