package in.Inventory_Control.Inventory_Control;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private String product_class;
    private int quantity;
    private Timestamp created_at;
    private Timestamp updated_at;

    private int supplierId;
    private Supplier supplier;

}
