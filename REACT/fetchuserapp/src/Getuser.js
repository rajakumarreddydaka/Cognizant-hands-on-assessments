import React, { useState, useEffect } from 'react';

function Getuser() {
  // Define state to hold the person data and a loading status
  const [person, setPerson] = useState(null);
  const [loading, setLoading] = useState(true);

  // useEffect acts like componentDidMount when passed an empty array []
  useEffect(() => {
    // Define the async fetch function inside useEffect
    const fetchUserData = async () => {
      try {
        const url = "https://api.randomuser.me/";
        const response = await fetch(url);
        const data = await response.json();
        
        // Update state exactly as the hint suggested
        setPerson(data.results[0]);
        setLoading(false);
        
        // Log to console for debugging
        console.log(data.results[0]);
      } catch (error) {
        console.error("Error fetching data:", error);
        setLoading(false);
      }
    };

    // Invoke the function
    fetchUserData();
  }, []); // The empty array ensures this only runs once on mount

  // Conditional rendering: Show a loading message while waiting for the API
  if (loading) {
    return <div style={{ margin: '50px', fontSize: '20px' }}>Loading user data...</div>;
  }

  // Once loading is false, render the data
  // Using optional chaining (?) just in case data is missing
  return (
    <div style={{ margin: '50px', fontFamily: 'sans-serif' }}>
      <h1>{person?.name?.title} {person?.name?.first} {person?.name?.last}</h1>
      <img 
        src={person?.picture?.large} 
        alt="User Portrait" 
        style={{ borderRadius: '4px', boxShadow: '0 4px 8px rgba(0,0,0,0.1)' }}
      />
    </div>
  );
}

export default Getuser;