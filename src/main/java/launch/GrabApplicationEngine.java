package launch;

import data.JdbcUserRepository;
import org.hibernate.annotations.FetchProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by GeoLin on 2017/5/21.
 */
@SpringBootApplication(scanBasePackages = {"controller","data"},excludeName = "UserRepository")
//@EnableJpaRepositories("data")
public class GrabApplicationEngine {
    @Bean
    @Primary//Actually, this can be done with bean's id and @Qualifier
    public DataSource dataSource(){
           return new EmbeddedDatabaseBuilder()
                   .setType(EmbeddedDatabaseType.H2)
                   .addScript("/static/schema.sql")
                   .build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public JdbcUserRepository jdbcUserRepository(JdbcTemplate jdbcTemplate){
        return new JdbcUserRepository(jdbcTemplate);
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    public static void main(String[] args){
        SpringApplication.run(GrabApplicationEngine.class,args);
    }
}
