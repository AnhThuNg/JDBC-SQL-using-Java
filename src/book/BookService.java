package book;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface BookService {
    Book findBookById(int id, Statement statement) throws SQLException;
    List<Book> findAll(Statement statement) throws SQLException;
    void deleteBookById(int id, Statement statement) throws SQLException ;
    void insertBook(Book book, Statement statement) throws SQLException ;
    void updateBook(Book book, Statement statement) throws SQLException ;
    List<Book> searchBookByName(String title, Statement statement) throws SQLException ;
    List<Book> deleteBookByName(String title, Statement statement) throws SQLException ;
    List<Book> findBookByListId(List<Integer> ids, Statement statement) throws SQLException ;
}
