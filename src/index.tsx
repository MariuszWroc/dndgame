import React from 'react';
import ReactDOM from 'react-dom';
import App from './main/webapp/components/app';
import { Provider } from 'react-redux';
import store from './main/webapp/redux/store';

const rootElement = document.getElementById('root');

ReactDOM.render(
  <Provider store={store}>
    <App/>
  </Provider>,
  rootElement);
