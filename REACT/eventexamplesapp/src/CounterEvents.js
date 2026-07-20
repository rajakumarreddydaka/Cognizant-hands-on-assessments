import React, { useState } from 'react';

function CounterEvents() {
  const [count, setCount] = useState(0);

  // Method 1: Increment value
  const handleIncrement = () => {
    setCount(prevCount => prevCount + 1);
  };

  // Method 2: Decrement value
  const handleDecrement = () => {
    setCount(prevCount => prevCount - 1);
  };

  // Method 3: Say Hello with static message
  const sayHello = () => {
    alert("Hello! This is a static message triggered by the button.");
  };

  // Requirement: The "Increase" button invokes multiple methods
  const handleIncreaseMulti = (event) => {
    handleIncrement();
    sayHello();
  };

  // Requirement: Pass "welcome" as an argument
  const sayWelcome = (message) => {
    alert(`Message received: ${message}`);
  };

  // Requirement: Synthetic event demonstration
  const handleSyntheticEvent = (event) => {
    // React automatically wraps native events in a SyntheticEvent object
    alert(`I was clicked! \nEvent type: ${event.type}`);
  };

  return (
    <div style={{ marginBottom: '40px', padding: '20px', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h2>Event Handling & Counter</h2>
      <h3>Current Count: {count}</h3>
      
      <div style={{ display: 'flex', gap: '10px', flexWrap: 'wrap' }}>
        {/* Basic Decrement */}
        <button onClick={handleDecrement} style={{ padding: '8px 16px' }}>
          Decrement
        </button>

        {/* Multi-method Increment */}
        <button onClick={handleIncreaseMulti} style={{ padding: '8px 16px', backgroundColor: '#e6f7ff' }}>
          Increase (Multi-Method)
        </button>

        {/* Passing Arguments (requires an arrow function in onClick) */}
        <button onClick={() => sayWelcome("Welcome!")} style={{ padding: '8px 16px' }}>
          Say Welcome
        </button>

        {/* Synthetic Event */}
        <button onClick={handleSyntheticEvent} style={{ padding: '8px 16px' }}>
          Synthetic Event Test
        </button>
      </div>
    </div>
  );
}

export default CounterEvents;