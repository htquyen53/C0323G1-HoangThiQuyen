import { Navigate, useRoutes } from 'react-router-dom';
// layouts
import DashboardLayout from './layouts/dashboard';
import SimpleLayout from './layouts/simple';
//
import BlogPage from './pages/BlogPage';
import UserPage from './pages/UserPage';
import LoginPage from './pages/LoginPage';
import Page404 from './pages/Page404';
import ProductsPage from './pages/ProductsPage';
import DashboardAppPage from './pages/DashboardAppPage';
import Home from './pages/Home';
import HomeLayout from './layouts/home/HomeLayout';
import Payment from './pages/Payment';
import Register from './pages/Register';
import PackagePade from './pages/PackagePage';
import Profile from './pages/Profile';
import SavedPost from './pages/SavedPost';
// ----------------------------------------------------------------------

export default function Router() {
  const routes = useRoutes([
    {
      path: '/dashboard',
      element: <DashboardLayout />,
      children: [
        { element: <Navigate to="/dashboard/app" />, index: true },
        { path: 'app', element: <DashboardAppPage /> },
        { path: 'user', element: <UserPage /> },
        { path: 'products', element: <ProductsPage /> },
        { path: 'blog', element: <BlogPage /> },
      ],
    },
    {
      path: '/bugbugbuzz',
      element: <HomeLayout />,
      children: [
        { path: 'home', element: <Home /> },
        {
          path: 'payment/:id', element: <Payment />,
        },
        { path: 'save-post', element: <SavedPost /> },
        { path: 'profile', element: <Profile /> }
      ],
    },
    {
      path: '/bugbugbuzz',
      element: <SimpleLayout />,
      children: [
        { element: <Navigate to="/home" />, index: true },
        { path: '404', element: <Page404 /> },
        { path: '*', element: <Navigate to="/bugbugbuzz/404" /> },
        { path: 'login', element: <LoginPage /> },
        { path: 'packagepage', element: <PackagePade /> },
        { path: 'register', element: <Register /> }

      ],
    },
    {
      path: '*',
      element: <Navigate to="/bugbugbuzz/login" replace />,
    },
  ]);

  return routes;
}
