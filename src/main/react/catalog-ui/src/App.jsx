import logo from './logo.svg';
import './App.css';
import {useEffect, useState} from "react";
import {Link, Routes, Route} from "react-router-dom";
import OurProductsPage from "./pages/OurProductsPage";
import DemoProductsPage from "./pages/DemoProductsPage";
import ErrorBoundary from "./ErrorBoundary";

function App() {

  return (
    <div className="App">
      <div style={{width: '100%', display: 'flex', flexDirection: 'row', justifyContent:'space-between', alignItems:'center'}}>
        <h1>The Catalog</h1>
        <div style={{ display: 'flex', flexDirection: 'row', justifyContent:'flex-end', alignItems:'center'}}>
          <Link to="/">Demo Products</Link>
          <Link to={"/products"}>Our Products</Link>
        </div>
      </div>

      <div style={{flex:1, display: 'flex'}}>
        <Routes>
                <Route path={"/"} element={
                    <ErrorBoundary>
                        <DemoProductsPage/>
                    </ErrorBoundary>
                }/>
                <Route path={"/products"} element={
                    <ErrorBoundary>
                        <OurProductsPage/>
                    </ErrorBoundary>
                }/>
        </Routes>

      </div>
    </div>
  );
}

export default App;
