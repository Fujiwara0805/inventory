package in.Inventory_Control.Inventory_Control;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Product {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private Date delivery_date;
    private String product_class;
    private String supplier_name;
    private Integer quantity;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Integer supplierId = 0;
    private String supplierName;

    private String errorMessage;

    public int getSupplierId(){
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName(){
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage() {
        this.errorMessage = errorMessage;
    }

}
