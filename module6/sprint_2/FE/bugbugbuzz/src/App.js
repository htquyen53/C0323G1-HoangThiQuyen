import './App.css';
import LoginPage from './pages/LoginPage';
import { HelmetProvider } from 'react-helmet-async';


function App() {
  return (
    <>
    <HelmetProvider>
    <LoginPage />
    </HelmetProvider>
    </>
  );
}

export default App;
