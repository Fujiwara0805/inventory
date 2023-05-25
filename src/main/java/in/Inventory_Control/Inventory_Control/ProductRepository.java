package in.Inventory_Control.Inventory_Control;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ProductRepository {
    @Select("SELECT * FROM Products")
    List<Product>findAll();

    @Select("SELECT * FROM Products WHERE id = #{id}")
    Product findById(long id);

    @Insert("INSERT INTO Products(name, description, price, delivery_date, product_class, supplier_name, quantity) VAlUES(#{name}, #{description}, #{price}, #{delivery_date}, #{product_class},#{supplier_name}, #{quantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Product product);

    @Update("UPDATE Products SET name = #{name}, description = #{description}, price = #{price}, delivery_date = #{delivery_date}, product_class = #{product_class}, supplier_name = #{supplier_name} quantity = #{quantity} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM Products WHERE id = #{id}")
    void delete(long id);

    @Insert("INSERT INTO product_suppliers(product_id, supplier_id) VALUES (#{productId}, #{supplierId})")
    void linkProductToSupplier(Integer productId, Integer supplierId);
}
