package data;

import org.springframework.stereotype.Repository;

/**
 * Created by GeoLin on 2017/5/21.
 */

public interface UserRepository {
    User save(User user);

    User findByUsername(String username);
}
