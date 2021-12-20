import {useEffect, useState} from "react";

function DemoProductsPage() {
    const [products, setProducts] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    useEffect(() => {
        fetch('https://fakestoreapi.com/products')
            .then(res=>res.json())
            .then(json => setProducts(json))
    }, [isLoading])

    return (
        <div >
            <h2>Our Products</h2>
            {isLoading
                ? <div>Loading</div>
                : <table style={{textAlign: 'left', padding: '10px'}}>
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                        <th>Description</th>
                    </tr>
                    </thead>
                    <tbody>
                    {products}
                    </tbody>

                </table>
            }
        </div>
    );
}

export default DemoProductsPage;
