'use strict'
{
    function deleteSupplier(element) {
        const id = element.getAttribute('data-supplier-id');
        if(confirm('仕入先を削除してもよろしいですか？')) {
            fetch(`/supplier/delete/${id}`, {
                method: "DELETE"
            }).then(response => {
                if(response.ok) {
                    alert('仕入先が削除されました');
                    location.reload();
                } else {
                    alert('削除中にエラーが発生しました');
                }
            });
        }
    }
}
