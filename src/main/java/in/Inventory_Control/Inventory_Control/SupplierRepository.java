package in.Inventory_Control.Inventory_Control;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface SupplierRepository {
    @Select("SELECT * FROM Suppliers")
    List<Supplier> findAll();

    @Select("SELECT * FROM Suppliers WHERE id = #{id}")
    Supplier findById(int id);

    @Select("SELECT * FROM Suppliers WHERE id = #{name}")
    Supplier findByName(String name);

    @Insert("INSERT INTO Suppliers(name, address, email, phone) VALUES (#{name}, #{address}, #{email}, #{phone})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insert(Supplier supplier);

    @Update("UPDATE Suppliers SET name = #{name}, address = #{address}, email = #{email}, phone = #{phone} WHERE id = #{id}")
    void update(Supplier supplier);

    @Delete("DELETE FROM Suppliers WHERE id = #{id}")
    void delete(int id);

    @Delete("DELETE FROM product_suppliers WHERE supplier_id = #{id}")
    void deleteProductSupplierRelations(int id);

    @Select("SELECT * FROM Products INNER JOIN product_suppliers ON (Products.id = product_suppliers.product_id) WHERE product_suppliers.supplier_id = #{supplier.Id}")
    List<Product> findProductsBySupplierId(Integer id);
}


