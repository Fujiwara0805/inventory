package in.Inventory_Control.Inventory_Control;

import org.apache.ibatis.annotations.*;
import java.util.List;
import java.util.Optional;

@Mapper
public interface SupplierRepository {
    @Select("SELECT * FROM Suppliers")
    List<Supplier> findAll();

    @Select("SELECT * FROM Suppliers WHERE id = #{id}")
    Supplier findById(int id);

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

    //検索機能
    @Select("SELECT COUNT(*) FROM Suppliers WHERE name LIKE CONCAT('%', #{name}, '%')")
    Optional<Long> countByName(@Param("name") String name);


    //ページネーション
    @Select("SELECT * FROM Suppliers WHERE name LIKE CONCAT('%', #{name}, '%') ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    List<Supplier> findByName(@Param("name") String name, @Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT * FROM Suppliers ORDER BY id LIMIT #{limit} OFFSET #{offset}")
    List<Supplier> findSuppliersAll(@Param("offset") int offset, @Param("limit") int limit);

    @Select("SELECT COUNT(*) FROM Suppliers")
    Optional<Long> count();

}


