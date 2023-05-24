package in.Inventory_Control.Inventory_Control;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserRepository {
    @Insert("INSERT INTO Users(id, username, password, email, role) VALUES (#{id}, #{username}, #{password}, #{email}, #{role})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(User User);

    @Select("SELECT * FROM Users WHERE username = #{username}")
    User findByUsername(String username);

    @Select("SELECT * FROM Users")
    List<User> findAll();

    @Select("SELECT * FROM Users WHERE id = #{id}")
    User findById(long id);

    @Update("UPDATE Users SET username = #{username}, password = #{password}, email = #{email}, role = #{role} WHERE id = #{id}")
    void update(User user);

    @Delete("DELETE FROM Users WHERE id = #{id}")
    void delete(long id);

}

