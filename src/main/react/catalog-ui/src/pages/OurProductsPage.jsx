import {useEffect, useState} from "react";

function OurProductsPage() {
    const [products, setProducts] = useState(null);

    useEffect(() => {
        fetch("api/products")
            .then(r => r.json())
            .then(data => setProducts(data))
    }, [products])

    return (
        <div >
            <h2>Our Products</h2>
            <table style={{textAlign: 'left', padding: '10px'}}>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Description</th>
                </tr>
                </thead>
                <tbody>
                {products && products?.map(p =>
                    <tr style={{height: "40px"}}>
                        <td style={{minWidth: '300px'}}>{p.name}</td>
                        <td style={{fontWeight: 'bold'}}>{p.price}</td>
                        <td>{p.description.substring(0, 50)}...</td>
                    </tr>
                )}
                </tbody>

            </table>
        </div>
    );
}

export default OurProductsPage;
