'use strict'
    function deleteProduct(element) {
        const id = element.getAttribute('data-product-id');
        if(confirm('商品を削除してもよろしいですか？')) {
            fetch(`/product/delete/${id}`, {
                method: "DELETE"
            }).then(response => {
                if(response.ok) {
                    alert('商品が削除されました');
                    location.reload();
                } else {
                    alert('削除中にエラーが発生しました');
                }
            });
        }
    }
