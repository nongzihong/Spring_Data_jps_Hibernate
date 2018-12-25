package the_template_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

@Repository
public class BookDAO {
    @Autowired
    private JdbcOperations jdbcOperations;


    public List<Map<String, Object>> getToList() {
        List<Map<String, Object>> maps = jdbcOperations.queryForList("select * from book where id > 0");
        return maps;
    }

    public Map<String, Object> getToMap() {
        String sql = "select * from book where id > ?;";
        Map<String, Object> ret = jdbcOperations.queryForMap(sql,2);
        return ret;
    }

    public Book getToBook() {
        String sql = "select * from book where id > 2;";
        Book book = jdbcOperations.queryForObject(
                sql, (rs, rowNum) -> new Book(rs.getInt(1), rs.getString(2), rs.getFloat(3))
        );
        return book;
    }

    public void create(String bookname, int price) {
        String sql = " insert into book (bookname,price) values (?,?)";
        int javaWeb = jdbcOperations.update(sql, bookname, price);
        if (javaWeb > 0) {
            System.out.println("数据插入成功");
        }
    }


}
