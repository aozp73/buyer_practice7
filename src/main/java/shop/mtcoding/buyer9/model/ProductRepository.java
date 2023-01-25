package shop.mtcoding.buyer9.model;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProductRepository {
    public int insert(@Param("name") String name, @Param("price") int price, @Param("qty") int qty);

    public Product findAll();

    public Product findById(int id);

    public int updateById(@Param("id") String id, @Param("name") String name, @Param("price") int price,
            @Param("qty") int qty);

    public int deleteById(int id);
}
