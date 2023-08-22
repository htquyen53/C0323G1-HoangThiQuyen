import logo from './logo.svg';
import './App.css';
import { useState } from 'react';

function App() {
  const carList= ["BMW","Mercedes s600", "Cambri", "VinFast"];
  const colorList = ["red","black", "white","pink"];
  const [selectedCar,setSelectedCar] = useState([{car:"BMW", color:"red"}]);
  const [selected, setSelected] = useState([{car:"BMW", color:"red"}]);
  const handleSelectCar() => {
    setSelectedCar((previousState) => {[...previousState, selected]})
  }
  return (
    <div className="App">
      
    </div>
  );
}

export default App;
