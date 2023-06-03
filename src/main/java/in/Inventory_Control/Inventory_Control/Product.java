package in.Inventory_Control.Inventory_Control;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    private int id;
    private String name;
    private String description;
    private BigDecimal price;
    private String product_class;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date delivery_date;
    private int quantity;
    private Timestamp created_at;
    private Timestamp updated_at;

    private int supplierId;
    private Supplier supplier;

}
