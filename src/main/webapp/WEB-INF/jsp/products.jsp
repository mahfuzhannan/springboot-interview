<html lang="en">

<jsp:include page="head.jsp"/>

<body>

<jsp:include page="header.jsp"/>


<main>
    <div class="container">
        <h1>Our Products</h1>

        <table class="table table-striped">
            <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
            </tr>
            </thead>
            <tbody id="product-table-body" class="table table-striped" onload="getProducts()">

            </tbody>
        </table>
    </div>
</main>


<jsp:include page="footer.jsp"/>
<script src="/js/products.js" type="text/javascript"></script>
</body>
</html>