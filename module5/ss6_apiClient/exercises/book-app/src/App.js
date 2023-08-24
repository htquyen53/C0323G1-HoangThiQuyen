import { Route, Routes } from 'react-router-dom';
import './App.css';
import { BookList } from './components/BookList';
import { BookCreate } from './components/BookCreate';

function App() {
  return (
    <div className="App">
      <Routes>
        <Route path='/books' element={<BookList />} />
        <Route path='/create-book' element={<BookCreate />} />
      </Routes>
    </div>
  );
}

export default App;
