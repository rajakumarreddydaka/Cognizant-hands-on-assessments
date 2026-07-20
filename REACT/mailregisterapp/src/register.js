import React, { useState } from 'react';

// Email validation Regex
const validEmailRegex = RegExp(
  /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i
);

// Helper function to check if the errors object contains any strings
const validateForm = (errors) => {
  let valid = true;
  Object.values(errors).forEach((val) => val.length > 0 && (valid = false));
  return valid;
};

function Register() {
  // State for form inputs
  const [formData, setFormData] = useState({
    fullName: '',
    email: '',
    password: ''
  });

  // State for validation errors
  const [errors, setErrors] = useState({
    fullName: '',
    email: '',
    password: ''
  });

  // NEW: State to keep track of successfully registered users
  const [registeredList, setRegisteredList] = useState([]);

  const handleChange = (event) => {
    const { name, value } = event.target;
    let localErrors = { ...errors };

    switch (name) {
      case 'fullName':
        localErrors.fullName =
          value.length < 5 ? 'Full Name must be 5 characters long!' : '';
        break;
      case 'email':
        localErrors.email = validEmailRegex.test(value)
          ? ''
          : 'Email is not valid!';
        break;
      case 'password':
        localErrors.password =
          value.length < 8 ? 'Password must be 8 characters long!' : '';
        break;
      default:
        break;
    }

    setErrors(localErrors);
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (event) => {
    event.preventDefault();

    // 1. Check for empty fields
    if (!formData.fullName || !formData.email || !formData.password) {
      alert('Please fill out all fields before submitting.');
      return;
    }

    // 2. Check if the form has any validation errors
    if (validateForm(errors)) {
      
      // NEW: Check for duplicates using the array .some() method
      // We check if the current email already exists in our registeredList
      const isDuplicate = registeredList.some(
        (user) => user.email === formData.email
      );

      if (isDuplicate) {
        alert('Registration Failed: A user with this email is already registered!');
        return; 
      }

      // If it is not a duplicate, add the new user to our list
      setRegisteredList([...registeredList, formData]);
      
      alert('Valid Form - Registration Successful!');
      
      // Optional: Clear the form after successful registration
      setFormData({ fullName: '', email: '', password: '' });

    } else {
      // Alert specific errors sequentially
      if (errors.fullName !== '') {
        alert(errors.fullName);
      } else if (errors.email !== '') {
        alert(errors.email);
      } else if (errors.password !== '') {
        alert(errors.password);
      }
    }
  };

  return (
    <div style={{ textAlign: 'center', marginTop: '50px', fontFamily: 'sans-serif' }}>
      <h1 style={{ color: 'red' }}>Register Here!!!</h1>
      
      <form onSubmit={handleSubmit} style={{ display: 'inline-block', textAlign: 'left' }}>
        
        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'inline-block', width: '80px', fontWeight: 'bold' }}>Name:</label>
          <input
            type="text"
            name="fullName"
            value={formData.fullName}
            onChange={handleChange}
            style={{ width: '200px', padding: '4px' }}
          />
        </div>

        <div style={{ marginBottom: '10px' }}>
          <label style={{ display: 'inline-block', width: '80px', fontWeight: 'bold' }}>Email:</label>
          <input
            type="text"
            name="email"
            value={formData.email}
            onChange={handleChange}
            style={{ width: '200px', padding: '4px' }}
          />
        </div>

        <div style={{ marginBottom: '15px' }}>
          <label style={{ display: 'inline-block', width: '80px', fontWeight: 'bold' }}>Password:</label>
          <input
            type="password"
            name="password"
            value={formData.password}
            onChange={handleChange}
            style={{ width: '200px', padding: '4px' }}
          />
        </div>

        <div style={{ paddingLeft: '80px' }}>
          <button type="submit" style={{ padding: '4px 15px', cursor: 'pointer' }}>
            Submit
          </button>
        </div>

      </form>
    </div>
  );
}

export default Register;