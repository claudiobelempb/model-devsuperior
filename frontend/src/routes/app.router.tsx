import React, { lazy } from 'react';
import { useRoutes } from 'react-router-dom';
// import { NotFoundPage } from '../pages/404';
// import { DashBoardPage } from '../pages/Dashboard';
// import { HomePage } from '../pages/HomePage';
// import { RepoPage } from '../pages/RepoPage';

const HomePage = lazy(() => {
  return import(
    /* webpackPrefetch: true */
    /* webpackChunkname: "Home Page" */ '../pages/HomePage'
  );
});
const NotFoundPage = lazy(() => {
  return import(
    /* webpackPrefetch: true */
    /* webpackChunkname: "NotFound Page" */ '../pages/404'
  );
});

export const Routes: React.FC = () => {
  return useRoutes([
    { path: '/', element: <HomePage /> },
    {
      path: '*',
      element: <NotFoundPage />,
    },
  ]);
};
