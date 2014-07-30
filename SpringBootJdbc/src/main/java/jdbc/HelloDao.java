package jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * <pre>
 * Hello DAO
 * </pre>
 *
 * @author nova
 * @since 2014. 7. 29.
 */
@Repository
public class HelloDao {

    @Autowired
    private JdbcTemplate template;

    /**
     * Get hello list, using BeanPropertyRowMapper
     *
     * @return
     */
    public List<Hello> listForBeanPropertyRowMapper() {
        String query = "SELECT * FROM hello";
        return template.query(query, new BeanPropertyRowMapper(Hello.class));
    }

    /**
     * Insert hello
     *
     * @param hello
     * @return
     */
    public int insert(Hello hello) {
        String query = "INSERT INTO hello(name, message) VALUES(?, ?)";
        return template.update(query, hello.getName(), hello.getMessage());
    }

    /**
     * Get hello list, using custom RowMapper
     *
     * @return
     */
    public List<Hello> listForCustomRowMapper() {
        String query = "SELECT * FROM hello";
        return template.query(query, new HelloRowMapper());
    }

    /**
     * RowMapper for Hello
     */
    class HelloRowMapper implements RowMapper<Hello> {
        @Override
        public Hello mapRow(ResultSet rs, int rowNum) throws SQLException {
            Hello hello = new Hello();
            hello.setName(rs.getString("name"));
            hello.setMessage(rs.getString("message"));
            return hello;
        }
    }

}