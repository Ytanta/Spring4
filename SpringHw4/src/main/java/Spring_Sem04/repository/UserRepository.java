package Spring_Sem04.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.gb.group4546_5984.Spring_Sem04.model.User;

import java.util.List;

@Repository

public class UserRepository {
    @Autowired
    private final JdbcTemplate jdbc;
    private final SqlTemplatesProperties sql;

    public UserRepository(JdbcTemplate jdbc, SqlTemplatesProperties sql) {
        this.jdbc = jdbc;
        this.sql = sql;
    }

    public List<User> findAll() {
//        String sql = "SELECT * FROM userTable";

        RowMapper<User> userRowMapper = ((rs, rowNum) -> {
            User rowObject = new User();
            rowObject.setId(rs.getInt("id"));
            rowObject.setFirstName(rs.getString("firstName"));
            rowObject.setLastName(rs.getString("lastName"));
            return rowObject;
        });

        return jdbc.query(sql.getSqlFindAll(), userRowMapper);
    }

    public void save(User user) {
//        String sql = "INSERT INTO userTable (firstName, lastName) VALUES (?, ?)";
        jdbc.update(sql.getSqlSave(), user.getFirstName(), user.getLastName());
    }

    public void deleteById(int id) {
//        String sql = "DELETE FROM userTable WHERE id=?";
        jdbc.update(sql.getSqlDeleteById(), id);
    }

    public void updateUser(User user) {
//        String sql = "UPDATE userTable SET firstName = ?, lastName = ? WHERE id = ?";
        jdbc.update(sql.getSqlUpdateUser(), user.getFirstName(), user.getLastName(), user.getId());
    }

    public User getOne(int id) {
//        String sql = "SELECT * FROM userTable WHERE id = " + id;
        String sql_string = sql.getSqlGetOne() + id;
        RowMapper<User> userRowMapper = ((rs, rowNum) -> {
            User rowObject = new User();
            rowObject.setId(rs.getInt("id"));
            rowObject.setFirstName(rs.getString("firstName"));
            rowObject.setLastName(rs.getString("lastName"));
            return rowObject;
        });
        List<User> users = jdbc.query(sql_string, userRowMapper);
        if (users.isEmpty()) {
            return null;
        } else {
            return jdbc.query(sql_string, userRowMapper).get(0);
        }
    }
}
