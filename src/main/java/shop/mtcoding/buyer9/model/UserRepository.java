package shop.mtcoding.buyer9.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {
    public int insert(@Param("username") String username, @Param("password") int password, @Param("email") int email);

    public Product findAll();

    public Product findById(int id);

    public int updateById(@Param("id") String id, @Param("password") String password);

    public int deleteById(int id);
}
