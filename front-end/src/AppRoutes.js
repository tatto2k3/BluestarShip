import SearchPage from "./Components/Layouts/BookingMain/SearchPage";
import DefaultLayOut from "./Components/Layouts/DeafaultLayout/DefaultLayout";
import SearchTicket from "./Components/Pages/SearchTicket/SearchTicket";
import MainLayoutLogin from "./Components/Layouts/MainLayoutLogin/MainLayoutLogin";
import TicketReview from "./Components/Pages/TicketReview/TicketReview";
import Explore from "./Components/Pages/Explore/explore";
import AboutUs from "./Components/Pages/AboutUs/AboutUs";
import LayoutAboutUs from "./Components/Layouts/LayoutAboutUs/LayoutAboutUs";
import TicketPage from "./Components/Pages/Ticket/TicketPage";
import MainLayout from "./Components/Layouts/MainLayout/MainLayOut";
import Payment from "./Components/Pages/Payment/Payment";
import SeatBooking from "./Components/Pages/Seat/SeatBooking";



const AppRoutes = [
  
  {
        path: '/',
        element: SearchPage,
        layout: DefaultLayOut
    },
    {
      path: '/search-ticket',
      element: SearchTicket,
      layout: MainLayoutLogin
    },
    {
      path: '/ticket-review',
      element: TicketReview,
      layout: MainLayoutLogin
    },
    {
      path: '/explore',
      element: Explore,
      layout: MainLayoutLogin
    },
    {
    path: '/about-us',
    element: AboutUs,
    layout: LayoutAboutUs
    },
    {
      path: '/ticket',
      element: TicketPage,
      layout: MainLayout
  },
  
{
    path: '/seat',
    element: SeatBooking,
    layout: MainLayout
},
{
  path: '/payment',
  element: Payment,
  layout: MainLayout
},


];

export default AppRoutes;
