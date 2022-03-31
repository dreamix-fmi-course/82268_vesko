package repository;

import model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StoreDB implements CRUD{

    private Map<String, Book> db = new ConcurrentHashMap<>();

    @Override
    public void add(Book book)
    {
        db.put(book.getISBN(), book);
    }

    @Override
    public Book update(Book book)
    {
        db.putIfAbsent(book.getISBN(), book);
        return book;
    }

    @Override
    public void remove(String isbn)
    {
        db.remove(isbn);
    }

    @Override
    public Book getByKey(String isbn)
    {
        return db.get(isbn);
    }

    @Override
    public List<Book> getAll()
    {
        return new ArrayList<>(db.values());
    }

    @Override
    public void clear()
    {
        db.clear();
    }
}
