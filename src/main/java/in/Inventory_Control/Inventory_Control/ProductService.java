package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product>getAllProducts() {
        return ProductRepository.findAll();
    }

    public Product findById(int id){
        return ProductRepository.findById(id);
    }

    public Product createProduct(Product product) {
        int id = ProductRepository.insert(product);
        product.setId(id);
        return product;
    }

    public Product updateProduct(Product product){
        ProductRepository.update(product);
        return product;
    }

    public void deleteProducts(int id){
        ProductRepository.delete(id);
    }

    public void linkProductToSupplier(Integer productId, Supplier supplier) {
        ProductRepository.linkProductToSupplier(productId,supplier.getId());
    }
}
