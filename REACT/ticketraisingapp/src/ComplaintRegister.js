import React, { useState } from 'react';

function ComplaintRegister() {
  // Managing form state using the modern useState hook
  const [formData, setFormData] = useState({
    ename: '',
    complaint: ''
  });

  // Equivalent to the handleChange hint
  const handleChange = (event) => {
    const { name, value } = event.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value // Dynamically updates the state property based on input name
    }));
  };

  // Equivalent to the handleSubmit hint
  const handleSubmit = (event) => {
    // Prevents the default browser refresh on form submit
    event.preventDefault(); 
    
    // Generate a random transaction ID (e.g., between 1 and 100)
    const NumberHolder = Math.floor(Math.random() * 100) + 1; 
    
    // Construct and display the alert message
    const msg = `Thanks ${formData.ename}\nYour Complaint was Submitted.\nTransaction ID is: ${NumberHolder}`;
    alert(msg);
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '40px', fontFamily: 'sans-serif' }}>
      <h2 style={{ color: 'red' }}>Register your complaints here!!!</h2>
      
      {/* Attach the handleSubmit function to the form */}
      <form onSubmit={handleSubmit} style={{ display: 'inline-block', textAlign: 'left' }}>
        
        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'inline-block', width: '100px' }}>Name:</label>
          <input
            type="text"
            name="ename"
            value={formData.ename}
            onChange={handleChange}
            required
            style={{ width: '180px', padding: '3px' }}
          />
        </div>

        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'inline-block', width: '100px', verticalAlign: 'top' }}>Complaint:</label>
          <textarea
            name="complaint"
            value={formData.complaint}
            onChange={handleChange}
            required
            style={{ width: '180px', height: '60px', padding: '3px' }}
          />
        </div>

        <div style={{ textAlign: 'center' }}>
          <button type="submit" style={{ padding: '4px 15px', cursor: 'pointer' }}>
            Submit
          </button>
        </div>

      </form>
    </div>
  );
}

export default ComplaintRegister;