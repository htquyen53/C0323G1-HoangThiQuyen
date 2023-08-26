import { Route, Routes } from 'react-router-dom';
import './App.css';
import { BookList } from './components/BookList';
import { BookCreate } from './components/BookCreate';
import { BookEdit } from './components/BookEdit';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/books' element={<BookList />} />
        <Route path='/edit-book/:id' element={<BookEdit />} />
        <Route path='/create-book' element={<BookCreate />} />
      </Routes>
    </div>
  );
}

export default App;
