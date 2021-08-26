package book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {
    @Override
    public Book findBookById(int id, Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from Book where id = " + id);
        //show data
        Book result = new Book();
        while (resultSet.next()) {
            Integer col1 = resultSet.getInt("id");
            String col2 = resultSet.getString("title");
            result.setId(col1);
            result.setTitle(col2);
        }
        return result;
    }

    @Override
    public List<Book> findAll(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select * from Book");
        List<Book> bookList = new ArrayList<>();
        //show data
        while (resultSet.next()) {
            Book book = new Book();
            Integer col1 = resultSet.getInt("id");
            String col2 = resultSet.getString("title");
            book.setId(col1);
            book.setTitle(col2);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public void deleteBookById(int id, Statement statement) throws SQLException {
        statement.executeUpdate("delete from Book where id = " + id);
    }

    @Override
    public void insertBook(Book book, Statement statement) throws SQLException {
        statement.executeUpdate("insert into Book values ("+book.getId()+", '"+book.getTitle()+"');");
    }

    @Override
    public void updateBook(Book book, Statement statement) throws SQLException {
        statement.executeUpdate("update Book set title = '"+book.getTitle()+"' where id = "+book.getId()+";");
    }

    @Override
    public List<Book> searchBookByName(String title, Statement statement) throws SQLException {
        // select * from Book where title = 'a'
        ResultSet resultSet = statement.executeQuery("select * from Book where title = '" + title + "'");
        List<Book> bookList = new ArrayList<>();
        //show data
        while (resultSet.next()) {
            Book book = new Book();
            Integer col1 = resultSet.getInt("id");
            String col2 = resultSet.getString("title");
            book.setId(col1);
            book.setTitle(col2);
            bookList.add(book);
        }
        return bookList;
    }

    @Override
    public List<Book> deleteBookByName(String title, Statement statement) throws SQLException {
        //delete Book where title = 'cdb'
        statement.executeUpdate("delete Book where title = '"+title+"'");
        List<Book> bookList = new ArrayList<>();
        return bookList;
    }

    @Override
    public List<Book> findBookByListId(List<Integer> ids, Statement statement) throws SQLException {
        String output = String.valueOf(ids).substring(1, String.valueOf(ids).length() - 1); // "1, 2, 4"

        ResultSet resultSet = statement.executeQuery("select * from Book where id in ( "+output+");");
        List<Book> bookList = new ArrayList<>();
        //show data
        while (resultSet.next()) {
            Book book = new Book();
            Integer col1 = resultSet.getInt("id");
            String col2 = resultSet.getString("title");
            book.setId(col1);
            book.setTitle(col2);
            bookList.add(book);
        }
        return bookList;
    }
}
