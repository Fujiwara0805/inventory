package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public List<Supplier> findByName(String name, Integer page, Integer size){
        int offset = (page - 1) * size;
        return supplierRepository.findByName(name,offset,size);
    }

    public Optional<Long> countByName(String name){
        return supplierRepository.countByName(name);
    }

    public List<Supplier> getAllSuppliers(Integer page, Integer size){
        int offset = (page - 1) * size;
        List<Supplier> suppliers = supplierRepository.findSuppliersAll(offset,size);
        return suppliers != null ? suppliers : new ArrayList<>();
    }

    public Optional<Long> getTotalSuppliers() {
        return supplierRepository.count();
    }

}
