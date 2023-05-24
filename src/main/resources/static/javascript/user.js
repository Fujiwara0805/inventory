function deleteUser(element) {
    const id = element.getAttribute('data-user-id');
        if(confirm('ユーザを削除してもよろしいですか？')) {
            fetch(`/user/delete/${id}`, {
            method: "DELETE"
            }).then(response => {
                if(response.ok) {
                    alert('ユーザが削除されました');
                    location.reload();
                } else {
                    alert('ユーザ削除中にエラーが発生しました');
                }
            });
    }
}
