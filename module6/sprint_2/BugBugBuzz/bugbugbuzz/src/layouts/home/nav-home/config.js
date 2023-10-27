// component
import SvgColor from '../../../components/svg-color';

// ----------------------------------------------------------------------

const icon = (name) => <SvgColor src={`/assets/icons/navbar/${name}.svg`} sx={{ width: 1, height: 1 }} />;

const navConfig = [
  {
    title: 'Profile',
    path: '/bugbugbuzz/profile',
    icon: icon('ic_lock'),
  },
  {
    title: 'Favorite Zone',
    path: localStorage.getItem("VipStatus") !== "" ? ('/bugbugbuzz/save-post') : ('/bugbugbuzz/packagepage'),
    icon: icon('ic_blog'),
  },
  {
    title: 'Update VIP',
    path: '/bugbugbuzz/packagepage',
    icon: icon('ic_user'),
  },
  {
    title: 'New Feed',
    path: '/bugbugbuzz/home',
    icon: icon('ic_notification_chat'),
  }
  // {
  //   title: 'login',
  //   path: '/login',
  //   icon: icon('ic_lock'),
  // },
  // {
  //   title: 'Not found',
  //   path: '/404',
  //   icon: icon('ic_disabled'),
  // },
];

export default navConfig;
