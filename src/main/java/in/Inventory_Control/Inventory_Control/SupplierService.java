package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> getAllSuppliers() {
        return supplierRepository.findAll();
    }

    public Supplier findById(int id) {
        return supplierRepository.findById(id);
    }

    public Supplier findByName(String name) {
        return supplierRepository.findByName(name);
    }

    public Supplier createSupplier(Supplier supplier) {
        supplierRepository.insert(supplier);
        return supplier;
    }

    public Supplier updateSupplier(Supplier supplier) {
        supplierRepository.update(supplier);
        return supplier;
    }

    public void deleteSupplier(int id) {
        supplierRepository.deleteProductSupplierRelations(id);
        supplierRepository.delete(id);
    }

    public List<Product> getProductsBySupplierId(Integer supplierId) {
        return supplierRepository.findProductsBySupplierId(supplierId);
    }
}
