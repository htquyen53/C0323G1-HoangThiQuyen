// redux
import { Provider } from 'react-redux';
import { BrowserRouter } from 'react-router-dom';
import { HelmetProvider } from 'react-helmet-async';
// Paypal
import { PayPalScriptProvider } from '@paypal/react-paypal-js';
// store
import { store } from "./redux/store";
// routes
import Router from './routes';
// theme
import ThemeProvider from './theme';
// components
import { StyledChart } from './components/chart';
import ScrollToTop from './components/scroll-to-top';


// ----------------------------------------------------------------------

export default function App() {
  return (
    <Provider store={store}>
      <PayPalScriptProvider options={{ "client-id": process.env.REACT_APP_PAYPAL_CLIENT_ID }}>
        <HelmetProvider>
          <BrowserRouter>
            <ThemeProvider>
              <ScrollToTop />
              <StyledChart />
              <Router />
            </ThemeProvider>
          </BrowserRouter>
        </HelmetProvider>
      </PayPalScriptProvider>
    </Provider>
  );
}
