package demo.druid;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void addUser(User user);

    void updateUser(User user);

}
