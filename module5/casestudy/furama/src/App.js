import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import ListCustomer from './components/ListCustomer';
import EditCustomer from './components/EditCustomer';
import { Routes, Route } from 'react-router';
import ListFacility from './components/ListFacility';
import EditFacility from './components/EditFacility';
import CreateFacility from './components/CreateFavcility';
import ListContact from './components/ListContact';
import CreateContact from './components/CreateContact';

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path='/furama/facilities' element={<ListFacility />} />
        <Route path='/furama/:id/facility-edit' element={<EditFacility />} />
        <Route path='/furama/facility-create' element={<CreateFacility />} />
        <Route path='/furama/customers' element={<ListCustomer />} />
        <Route path='/furama/:id/customer-edit/' element={<EditCustomer />} />
        <Route path='/furama/contacts' element={<ListContact />} />
        <Route path='/furama/:id/contact-create/' element={<CreateContact />} />
      </Routes>
      <Footer />
    </>
  );
}

export default App;
