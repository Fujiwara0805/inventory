package in.Inventory_Control.Inventory_Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SupplierController {
    @Autowired
    public SupplierService supplierService;

    //error画面
    @GetMapping("/suppliers/error")
    public String showErrorPage(){
        return "error";
    }

//  仕入先一覧
    @GetMapping("/suppliers")
    public String getAllSuppliers(Model model) {
        model.addAttribute("suppliers",supplierService.getAllSuppliers());
        model.addAttribute("username", "仕入先一覧画面");
        return "/suppliers";
    }

//  仕入先登録画面
    @GetMapping("/suppliers/create")
    public String showCreatePage(Model model) {
        model.addAttribute("supplier", new Supplier());
        model.addAttribute("username", "仕入先登録画面");
        return "supplier_create";
    }

// 仕入先登録
    @PostMapping("/suppliers/create")
    public String createSupplier(@ModelAttribute Supplier supplier, Model model) {
        Supplier newSupplier = supplierService.createSupplier(supplier);
        if(newSupplier != null) {
            return "redirect:/suppliers";
        } else {
            model.addAttribute("errorMessage", "仕入れ先登録に失敗しました。もう一度お試しください");
            return "redirect:/suppliers/create";
        }
    }

// 仕入先詳細
    @GetMapping("/supplier/{id}")
    public String showSupplierDetailPage(@PathVariable int id, Model model) {
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            model.addAttribute("supplier",supplier);
            List<Product> products = supplierService.getProductsBySupplierId(id);
            model.addAttribute("products",products);
            model.addAttribute("username", "仕入先詳細画面");
            return "supplier_detail";
        } else {
            return "redirect:/suppliers";
        }
    }

// 仕入先編集画面
    @GetMapping("/supplier/edit/{id}")
    public String showSupplierEditPage(@PathVariable int id,Model model) {
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            model.addAttribute("supplier", supplier);
            model.addAttribute("username", "仕入先編集画面");
            return "supplier_edit";
        } else {
            return "redirect:/suppliers";
        }
    }

//   仕入先更新
    @PostMapping("/supplier/update/{id}")
    public String updateSupplier(@PathVariable int id, @ModelAttribute Supplier supplier) {
        supplier.setId(id);
        Supplier updateSupplier = supplierService.updateSupplier(supplier);
        if(updateSupplier != null) {
            return "redirect:/suppliers";
        } else {
            return "404";
        }
    }

//  仕入先削除
    @DeleteMapping("/supplier/delete/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable int id) {
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            supplierService.deleteSupplier(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
