import React, { useState } from 'react';

function CurrencyConvertor() {
  const [rupees, setRupees] = useState('');
  const [euros, setEuros] = useState(null);

  // Conversion rate (Approximate: 1 Euro = ~90 INR)
  const exchangeRate = 90; 

  // Handle input change
  const handleChange = (event) => {
    setRupees(event.target.value);
  };

  // Requirement: Invoke handleSubmit event to handle conversion
  const handleSubmit = (event) => {
    event.preventDefault(); // Prevents the page from reloading
    
    if (rupees && !isNaN(rupees)) {
      const convertedValue = (parseFloat(rupees) / exchangeRate).toFixed(2);
      setEuros(convertedValue);
    } else {
      alert("Please enter a valid number for Rupees.");
    }
  };

  return (
    <div style={{ padding: '20px', border: '1px solid #ccc', borderRadius: '8px' }}>
      <h2>Currency Convertor (INR to EUR)</h2>
      
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '15px' }}>
          <label style={{ marginRight: '10px', fontWeight: 'bold' }}>Indian Rupees (₹):</label>
          <input 
            type="number" 
            value={rupees} 
            onChange={handleChange} 
            placeholder="Enter amount in INR"
            style={{ padding: '5px' }}
          />
        </div>
        
        <button type="submit" style={{ padding: '8px 16px', cursor: 'pointer', backgroundColor: '#d4edda' }}>
          Convert to Euro
        </button>
      </form>

      {/* Conditionally display the result if 'euros' is not null */}
      {euros !== null && (
        <h3 style={{ color: 'green', marginTop: '20px' }}>
          Equivalent in Euros: €{euros}
        </h3>
      )}
    </div>
  );
}

export default CurrencyConvertor;