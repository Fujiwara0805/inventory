package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        ProductRepository.insert(product);
        return product;
    }

    public Product updateProduct(Product product){
        ProductRepository.update(product);
        return product;
    }

    public void deleteProducts(int id){
        ProductRepository.deleteProductSupplierRelations(id);
        ProductRepository.delete(id);
    }

    public void linkProductToSupplier(Integer productId, Supplier supplier) {
        ProductRepository.linkProductToSupplier(productId,supplier.getId());
    }

    public List<Product> findByName(String name, Integer page, Integer size){
        int offset = (page - 1) * size;
        return ProductRepository.findByName(name,offset,size);
    }

    public Optional<Long> countByName(String name){
        return ProductRepository.countByName(name);
    }

    public List<Product> getAllProducts(Integer page, Integer size){
        int offset = (page - 1) * size;
        List<Product> products = ProductRepository.findProductsAll(offset,size);
        return products != null ? products : new ArrayList<>();
    }

    public Optional<Long> getTotalProducts() {
        return ProductRepository.count();
    }

}
