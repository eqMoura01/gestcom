import React from 'react';
import PropTypes from 'prop-types';
import './Login.css';

const Login = ({ textColor, inputColor, buttonColor }) => {
  return (
    <div className="container">
      <div className="login-form">
        <form action="" className="login-form-content">
          
            <h1>Login</h1>
            <div className="login-form-inputs">
              <input type="text" placeholder="Email" />
              <input type="password" placeholder="Password" />
            </div>
          <div className="login-form-buttons">
            <button type="submit">Login</button>
            <button type="submit">Register</button>
            <button type="submit">Forgot Password</button>
          </div>
        </form>
      </div>
    </div>
  );
};

Login.propTypes = {
  textColor: PropTypes.string,
  inputColor: PropTypes.string,
  buttonColor: PropTypes.string,
};

Login.defaultProps = {
  textColor: '#fff',
  inputColor: '#212121',
  buttonColor: '#212121',
};

export default Login;
