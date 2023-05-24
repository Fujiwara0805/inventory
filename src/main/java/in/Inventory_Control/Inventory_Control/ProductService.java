package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository ProductRepository;

    public List<Product>getAllProducts() {
        return ProductRepository.findAll();
    }

    public Product findById(long id){ return ProductRepository.findById(id);}

    public Product createProduct(Product product) {
        ProductRepository.insert(product);
        return product;
    }

    public Product updateProduct(Product product){
        ProductRepository.update(product);
        return product;
    }

    public void deleteProducts(long id){
        ProductRepository.delete(id);
    }

    public void linkProductToSupplier(Integer productId, Integer supplierId) {
        ProductRepository.linkProductToSupplier(productId,supplierId);
    }
}
