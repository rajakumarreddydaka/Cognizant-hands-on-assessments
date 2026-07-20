import React, { useState } from 'react';

// --- Sub-components for Greetings ---
function UserGreeting(props) {
  return <h1>Welcome back</h1>;
}

function GuestGreeting(props) {
  return <h1>Please sign up.</h1>;
}

// --- The Conditional Greeting Component ---
function Greeting(props) {
  const isLoggedIn = props.isLoggedIn;
  if (isLoggedIn) {
    return <UserGreeting />;
  }
  return <GuestGreeting />;
}

// --- Button Components ---
function LoginButton(props) {
  return (
    <button onClick={props.onClick} style={{ padding: '5px 15px', cursor: 'pointer' }}>
      Login
    </button>
  );
}

function LogoutButton(props) {
  return (
    <button onClick={props.onClick} style={{ padding: '5px 15px', cursor: 'pointer' }}>
      Logout
    </button>
  );
}

// --- Main App Component ---
function App() {
  // State to track if the user is logged in or not
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // Click handlers to update the state
  const handleLoginClick = () => {
    setIsLoggedIn(true);
  };

  const handleLogoutClick = () => {
    setIsLoggedIn(false);
  };

  // --- Element Variables ---
  // We use a variable to store the element we want to render 
  // so we can conditionally assign it before the return statement.
  let button;
  if (isLoggedIn) {
    button = <LogoutButton onClick={handleLogoutClick} />;
  } else {
    button = <LoginButton onClick={handleLoginClick} />;
  }

  return (
    <div style={{ display: 'flex', flexDirection: 'column', alignItems: 'center', marginTop: '100px', fontFamily: 'sans-serif' }}>
      {/* Pass the current state as a prop to the Greeting component */}
      <Greeting isLoggedIn={isLoggedIn} />
      
      {/* Render the dynamically assigned button element */}
      {button}
    </div>
  );
}

export default App;