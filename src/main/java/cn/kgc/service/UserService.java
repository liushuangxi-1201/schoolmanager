package cn.kgc.service;

import cn.kgc.entity.Role;
import cn.kgc.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

public interface UserService extends IService<User> {

    User findUserByLoginName(String name);

    User findUserById(String id);

    int userCount(String loginName);

    void saveUserRoles(String id, Set<Role> roleLists);

    void saveUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    void lockUser(User user);
}
