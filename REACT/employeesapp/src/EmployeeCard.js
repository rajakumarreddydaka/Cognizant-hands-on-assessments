import React, { useContext, useState } from 'react';
import ThemeContext from './ThemeContext';

function EmployeeCard({ employee }) {
  // Get the theme from context
  const theme = useContext(ThemeContext);
  
  // Create a state variable to track if details are visible
  const [showDetails, setShowDetails] = useState(false);

  // Toggle function for the button
  const toggleDetails = () => {
    setShowDetails(!showDetails);
  };

  return (
    <div className="card">
      <h3>{employee.name}</h3>
      <p>{employee.designation}</p>
      
      {/* Conditionally render the extra data based on state */}
      {showDetails && (
        <div style={{ 
          margin: '15px 0', 
          padding: '10px', 
          backgroundColor: theme === 'light' ? '#f1f3f5' : '#495057',
          color: theme === 'light' ? '#000' : '#fff',
          borderRadius: '4px',
          fontSize: '0.9em'
        }}>
          <p style={{ margin: '5px 0' }}><strong>Email:</strong> {employee.email}</p>
          <p style={{ margin: '5px 0' }}><strong>Location:</strong> {employee.location}</p>
        </div>
      )}
      
      {/* Attach the onClick event to the button */}
      <button 
        className={`btn-${theme}`} 
        onClick={toggleDetails}
        style={{ marginTop: '10px' }}
      >
        {showDetails ? 'Hide Profile' : 'View Profile'}
      </button>
    </div>
  );
}

export default EmployeeCard;