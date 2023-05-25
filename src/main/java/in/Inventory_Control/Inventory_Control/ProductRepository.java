package in.Inventory_Control.Inventory_Control;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface ProductRepository {
    @Select("SELECT * FROM Products")
    List<Product>findAll();

    @Select("SELECT * FROM Products WHERE id = #{id}")
    Product findById(int id);

    @Insert("INSERT INTO Products(name, description, price, delivery_date, product_class, quantity) VAlUES(#{name}, #{description}, #{price}, #{delivery_date}, #{product_class}, #{quantity})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Product product);

    @Update("UPDATE Products SET name = #{name}, description = #{description}, price = #{price}, delivery_date = #{delivery_date}, product_class = #{product_class}, quantity = #{quantity} WHERE id = #{id}")
    void update(Product product);

    @Delete("DELETE FROM Products WHERE id = #{id}")
    void delete(int id);

    @Insert("INSERT INTO product_suppliers(product_id, supplier_id) VALUES (#{productId}, #{supplierId})")
    void linkProductToSupplier(int productId, int supplierId);
}
