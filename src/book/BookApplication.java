package book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookApplication {
    public static void main(String[] args) throws ClassNotFoundException {
        String db_conn = "jdbc:sqlserver:localhost:1433;"
                + "databaseName=BookService;"
                + "user=***;"
                + "password=***;"
                + "integratedSecurity=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        try {
            Connection connection = DriverManager.getConnection(db_conn);
            Statement statement = connection.createStatement();
            BookServiceImpl bookService = new BookServiceImpl();
            //TODO: Find by Id
            Book book = bookService.findBookById(1, statement);
            System.out.println(book);
            
            //TODO: Find all
            List<Book> bookList = bookService.findAll(statement);
            bookList.forEach(System.out::println);
            
            //TODO: Delete Book By Id
            bookService.deleteBookById(9, statement);
            List<Book> bookList = bookService.findAll(statement);
            bookList.forEach(System.out::println);
            
            //TODO: Insert Book By Id
            Book book = new Book();
            book.setId(9);
            book.setTitle("book-name");
            bookService.insertBook(book, statement);
            List<Book> bookList = bookService.findAll(statement);
            bookList.forEach(System.out::println);
            
            //TODO: Update Book by Id
            Book book1 = new Book();
            book1.setId(8);
            book1.setTitle("book-name");
            bookService.updateBook(book1, statement);
            List<Book> bookList = bookService.findAll(statement);
            bookList.forEach(System.out::println);
            
            //TODO: Find By Title
            List<Book> bookList1 = bookService.searchBookByName("book-name", statement);
            bookList1.forEach(System.out::println);
            
            //TODO: Delete Book By Name
            List<Book> bookList = bookService.deleteBookByName("book-name", statement);
            bookList.forEach(System.out::println);
            
            //TODO: Find multi rows by Id
            List<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(4);
            //input: [1, 2, 4]
            List<Book> bookList = bookService.findBookByListId(ids, statement);
            bookList.forEach(System.out::println);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}







