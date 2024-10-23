import React from 'react';
import PropTypes from 'prop-types';
import './Login.css';

const Login = ({ textColor, inputColor, buttonColor }) => {
  return (
    <div className="container">
      <input type="checkbox" id="signup_toggle" />
      <form className="form">
        <div className="form_front" style={{ color: textColor }}>
          <div className="form_details">Login</div>
          <input
            placeholder="Username"
            className="input"
            type="text"
            style={{ backgroundColor: inputColor }}
          />
          <input
            placeholder="Password"
            className="input"
            type="text"
            style={{ backgroundColor: inputColor }}
          />
          <button className="btn" style={{ backgroundColor: buttonColor }}>
            Login
          </button>
          <span className="switch">
            Don't have an account? 
            <label className="signup_tog" htmlFor="signup_toggle">
              Sign Up
            </label>
          </span>
        </div>
        <div className="form_back" style={{ color: textColor }}>
          <div className="form_details">SignUp</div>
          <input
            placeholder="Firstname"
            className="input"
            type="text"
            style={{ backgroundColor: inputColor }}
          />
          <input
            placeholder="Username"
            className="input"
            type="text"
            style={{ backgroundColor: inputColor }}
          />
          <input
            placeholder="Password"
            className="input"
            type="text"
            style={{ backgroundColor: inputColor }}
          />
          <input
            placeholder="Confirm Password"
            className="input"
            type="text"
            style={{ backgroundColor: inputColor }}
          />
          <button className="btn" style={{ backgroundColor: buttonColor }}>
            Signup
          </button>
          <span className="switch">
            Already have an account? 
            <label className="signup_tog" htmlFor="signup_toggle">
              Sign In
            </label>
          </span>
        </div>
      </form>
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
