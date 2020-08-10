function getProducts() {
    console.log("get products");
    fetch("/api/products")
        .then(function (response) {
            return response.json()
        })
        .then(function (data) {
            var row;
            var body = $("#product-table-body");
            for (var i=0; i<data.length; i++) {
                var currentItem = data[i];
                row = "<tr>" +
                    "<td>" + currentItem.name + "</td>" +
                    "<td>" + currentItem.description + "</td>" +
                    "<td>" + currentItem.price + "</td>" +
                    "</tr>";
            }
            body.append(row);
        })
}

window.onload = function () {
    getProducts();
};
