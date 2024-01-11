import Home from "../pages/Home";
import LeanerSignup from "../pages/LeanerSignup";
import InstructorSignup from "../pages/InstructorSignup";
import Login from "../pages/Login";
import LearnerProfile from "../pages/LearnerProfile";
import InstructorProfile from "../pages/InstructorProfile";

interface RouteProp {
  path: string;
  component: JSX.Element;
  requireAuth?: boolean;
}

const appRoutes: Array<RouteProp> = [
  {
    path: '/',
    component: <Home/>
  },
  {
    path: '/learner-signup',
    component: <LeanerSignup/>
  },
  {
    path: '/login',
    component: <Login/>
  },
  {
    path: '/instructor-signup',
    component: <InstructorSignup/>
  },
  {
    path: '/learner-profile',
    component: <LearnerProfile/>,
    requireAuth: true
  },
  {
    path: '/instructor-profile',
    component: <InstructorProfile/>,
    requireAuth: true
  }
];

export default appRoutes;