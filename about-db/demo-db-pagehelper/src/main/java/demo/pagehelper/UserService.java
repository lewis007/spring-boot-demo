package demo.pagehelper;

import com.github.pagehelper.PageInfo;

import java.util.List;

public interface UserService {

    List<User> findAll();

    void addUser(User user);

    void updateUser(User user);

    void addUsers(List<User> users);

    PageInfo<User> findAllByPage(Integer pageNum, Integer pageSize);

}
