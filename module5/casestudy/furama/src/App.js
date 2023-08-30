import React from 'react';
import './App.css';
import { Routes, Route } from 'react-router';
import Header from './components/Header';
import Footer from './components/Footer';
import ListCustomer from './components/ListCustomer';
import EditCustomer from './components/EditCustomer';
import ListFacility from './components/ListFacility';
import CreateFacility from './components/CreateFacility';
import ListContact from './components/ListContact';
import CreateContact from './components/CreateContact';
import EditVilla from './components/EditVilla';
import EditHouse from './components/EditHouse';
import EditRoom from './components/EditRoom';
import CreateCustomer from './components/CreateCustomer';
import Home from './components/Home';

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path='/furama' element={<Home />} />
        <Route path='/furama/facilities' element={<ListFacility />} />
        <Route path='/furama/facility/:id/edit-villa/' element={<EditVilla />} />
        <Route path='/furama/facility/:id/edit-house/' element={<EditHouse />} />
        <Route path='/furama/facility/:id/edit-room/' element={<EditRoom />} />
        <Route path='/furama/facility-create' element={<CreateFacility />} />
        <Route path='/furama/customers' element={<ListCustomer />} />
        <Route path='/furama/:id/customer-edit/' element={<EditCustomer />} />
        <Route path='/furama/customer-create/' element={<CreateCustomer />} />
        <Route path='/furama/contacts' element={<ListContact />} />
        <Route path='/furama/contact-create/' element={<CreateContact />} />
      </Routes>
      <Footer />
    </>
  );
}

export default App;
