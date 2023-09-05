import './App.css';
import CreateProduct from './components/CreateProduct';
import EditProduct from './components/EditProduct';
import ListProduct from './components/ListProduct';
import { Route, Routes } from 'react-router';

function App() {
  return (
    <>
      <Routes>
        <Route path='/products' element={<ListProduct />} />
        <Route path='/products/:id/edit' element={<EditProduct />} />
        <Route path='/products/create' element={<CreateProduct />} />
      </Routes>
    </>
  );
}

export default App;
