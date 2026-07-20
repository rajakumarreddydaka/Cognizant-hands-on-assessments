import React, { useState } from 'react';
import ThemeContext from './ThemeContext';
import EmployeesList from './EmployeesList';
import './App.css';

// Dummy data
const mockEmployees = [
  { id: 1, name: "Alice Johnson", designation: "Frontend Developer", email: "alice@example.com", location: "Bangalore" },
  { id: 2, name: "Bob Smith", designation: "Backend Developer", email: "bob@example.com", location: "Chennai" },
  { id: 3, name: "Charlie Davis", designation: "UI/UX Designer", email: "charlie@example.com", location: "Hyderabad" }
];

function App() {
  const [theme, setTheme] = useState('light');

  const toggleTheme = () => {
    setTheme(prevTheme => (prevTheme === 'light' ? 'dark' : 'light'));
  };

  return (
    <ThemeContext.Provider value={theme}>
      <div className="App">
        <h1>Employee Management</h1>
        <button className="toggle-btn" onClick={toggleTheme}>
          Switch to {theme === 'light' ? 'Dark' : 'Light'} Theme
        </button>
        
        <EmployeesList employees={mockEmployees} />
      </div>
    </ThemeContext.Provider>
  );
}

export default App;