import Dashboard from "../pages/Dashboard";
import Profile from "../pages/profile";
import ChangePassword from "../pages/profile/ChangePassword";
import LearnerList from "../pages/learner/LearnerList";
import InstructorList from "../pages/instructor/InstructorList";
import CourseList from "../pages/course/CourseList";
import BookingList from "../pages/booking/BookingList";
import StaffList from "../pages/staff/StaffList";

interface RouteProp {
  path: string,
  component: JSX.Element
}

const appRoutes: Array<RouteProp> = [
  {
    path: "/dashboard",
    component: <Dashboard/>
  },
  {
    path: "/profile",
    component: <Profile/>
  },
  {
    path: "/change-password",
    component: <ChangePassword/>
  },
  {
    path: "/learners",
    component: <LearnerList/>
  },
  {
    path: "/instructors",
    component: <InstructorList/>
  },
  {
    path: "/courses",
    component: <CourseList/>
  },
  {
    path: "/bookings",
    component: <BookingList/>
  },
  {
    path: "/staffs",
    component: <StaffList/>
  }
];

export default appRoutes;