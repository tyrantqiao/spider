package data;

import controller.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by GeoLin on 2017/5/23.
 */
//TODO May 23th, configure datasource with h2, should change to MySQL
//@Repository
public class JdbcUserRepository implements UserRepository {
    private JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

//    private jdbcTemplate jdbcTemplate;
//    @Autowired
//    public JdbcUserRepository(jdbcTemplate jdbcTemplate){
//        this.jdbcTemplate=jdbcTemplate;
//    }

    public User save(User user){
        jdbcTemplate.update("insert into PUBLIC.USER(username,password,email)"
                                    +"VALUES(?,?,?)",
                                        user.getUsername(),
                                        user.getPassword(),
                                        user.getEmail());
        return user;
    }

    public User findByUsername(String username){
        return jdbcTemplate.queryForObject(
                "select id, username, password, email from PUBLIC.USER where username=?",
                new UserRowMapper(),
                username);
        //(A--sql,B--RowMapper,C--supplement for A)
    }

    private class UserRowMapper implements RowMapper<User>{
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            return new User(
                    resultSet.getLong("id"),
                    resultSet.getString("username"),
//                    null,
                    resultSet.getString("password"),
                    resultSet.getString("email"));
        }
    }

}
