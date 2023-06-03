'use strict'
{
    const selectSupplier = document.getElementById('selectSupplier');
    selectSupplier.addEventListener('click', () => {
    let selectRadio = document.querySelector('input[name="supplierRadio"]:checked');
        if(selectRadio) {
            let selectSupplierName = selectRadio.value;
            let selectSupplierId = selectRadio.getAttribute('data-id');
            document.getElementById('supplier_name').value = selectSupplierName;
            document.getElementById('supplierId').value = selectSupplierId;
            $('#supplierModal').modal('hide');
        } else {
             alert("エラーが発生しました");
        }
    });
}

