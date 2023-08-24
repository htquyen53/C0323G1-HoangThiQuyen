import './App.css';
import { ToDoList } from './components/ToDoList';
import { Routes, Route, Link } from 'react-router-dom';

function App() {
  return (
    <div className="App">
      <ToDoList />
    </div>
  );
}

export default App;
