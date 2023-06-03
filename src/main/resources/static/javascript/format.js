'use strict'
{
    const form = document.querySelector('form');
    form.addEventListener('submit', event => {
      let deliveryDate = document.getElementById('delivery_date');
      let date = new Date(dateInput.value);
      let year = date.getFullYear();
      let month = ("0" + (date.getMonth() + 1)).slice(-2));
      let day = ("0" + date.getDay()).slice(-2);
      dateInput.value = year + "-" + month + "-" + day;
    });
}