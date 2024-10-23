import React, { useState } from 'react';
import Login from '../../components/login/Login'; // Ajuste o caminho conforme necessário
import ButtonMode from '../../components/buttons/ButtonMode'; // Importe o ButtonMode
import './LoginScreen.css'; // Importa o CSS para o LoginScreen

const LoginScreen = () => {
  const [isDarkMode, setIsDarkMode] = useState(false);

  const toggleTheme = () => {
    setIsDarkMode((prevMode) => !prevMode);
  };

  return (
    <main className={isDarkMode ? 'dark-mode' : 'light-mode'}>
      <div className="login-screen-container">
        <ButtonMode isDarkMode={isDarkMode} toggleTheme={toggleTheme} />
        <Login />
      </div>
    </main>
  );
};

export default LoginScreen;
