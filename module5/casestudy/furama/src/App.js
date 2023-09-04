import React from 'react';
import './App.css';
import { Routes, Route } from 'react-router';
import Header from './components/layout/Header';
import Footer from './components/layout/Footer';
import ListCustomer from './components/customer/ListCustomer';
import EditCustomer from './components/customer/EditCustomer';
import ListFacility from './components/facility/ListFacility';
import CreateFacility from './components/facility/CreateFacility';
import ListContact from './components/contact/ListContact';
import CreateContact from './components/contact/CreateContact';
import EditVilla from './components/facility/villa/EditVilla';
import EditHouse from './components/facility/house/EditHouse';
import EditRoom from './components/facility/room/EditRoom';
import CreateCustomer from './components/customer/CreateCustomer';
import Home from './components/Home';

function App() {
  return (
    <>
      <Header />
      <Routes>
        <Route path='/' element={<Home />} />
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
