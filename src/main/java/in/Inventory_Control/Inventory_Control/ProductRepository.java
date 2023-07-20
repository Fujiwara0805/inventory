package in.Inventory_Control.Inventory_Control;
import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface ProductRepository {
    @Select("SELECT * FROM Products")
    List<Product>findAll();

    @Select("SELECT * FROM Products WHERE id = #{id}")
    Product findById(int id);

    @Insert("INSERT INTO Products(name, description, price, product_class, delivery_date, quantity) VAlUES(#{name}, #{description}, #{price},#{product_class},#{delivery_date},#{quantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Product product);

    @Update("UPDATE Products SET name = #{name}, description = #{description}, price = #{price},product_class = #{product_class}, delivery_date =#{delivery_date}, quantity = #{quantity} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM Products WHERE id = #{id}")
    void delete(int id);

    @Insert("INSERT INTO product_suppliers(product_id, supplier_id) VALUES (#{productId}, #{supplierId})")
    void linkProductToSupplier(int productId, int supplierId);

    @Delete("DELETE FROM product_suppliers WHERE product_id = #{id}")
    void deleteProductSupplierRelations(int id);

    @Select("SELECT * FROM Products WHERE name LIKE CONCAT('%', #{name}, '%') ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    List<Product> findByName(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM Products WHERE name LIKE CONCAT('%', #{name}, '%')")
    Optional<Long> countByName(@Param("name") String name);

    @Select("SELECT * FROM Products ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    List<Product> findProductsAll(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM Products")
    Optional<Long> count();
}
