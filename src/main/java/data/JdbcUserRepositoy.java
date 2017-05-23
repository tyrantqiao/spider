package data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by GeoLin on 2017/5/23.
 */
//TODO May 23th, configure datasource with h2, should change to MySQL
@Repository
public class JdbcUserRepositoy {
    private JdbcOperations jdbcOperations;

    @Autowired
    public JdbcUserRepositoy(JdbcOperations jdbcOperation){
        this.jdbcOperations=jdbcOperation;
    }

    public void save(){

    }

}
