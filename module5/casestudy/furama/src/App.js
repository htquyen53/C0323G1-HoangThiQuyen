import logo from './logo.svg';
import './App.css';
import Header from './components/Header';
import Footer from './components/Footer';
import Services from './components/Services';
import EditServices from './components/EditService';
import CreateServices from './components/CreateService';

function App() {
  return (
    <div className="App">
      <Header />
      <Services />
      {/* <EditServices /> */}
      {/* <CreateServices /> */}
      <Footer />
    </div>
  );
}

export default App;
