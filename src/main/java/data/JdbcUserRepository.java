package data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GeoLin on 2017/5/23.
 */
//TODO May 23th, configure datasource with h2, should change to MySQL
@NoRepositoryBean
public class JdbcUserRepository implements UserRepository {
    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcUserRepository(JdbcOperations jdbcOperations){
        this.jdbcOperations=jdbcOperations;
    }

    public User save(User user){
        jdbcOperations.update("insert into user(username,password,email)"
                                    +"VALUES(?,?,?)",
                                        user.getUsername(),
                                        user.getPassword(),
                                        user.getEmail());
        return user;
    }

    public User findByUsername(String username){
        return jdbcOperations.queryForObject(
                "select id, username, null, email from User where username=?",
                new UserRowMapper(),
                username);
    }

    private class UserRowMapper implements RowMapper<User>{
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
                    null,
                    resultSet.getString("email"));
        }
    }

}
