import React from 'react';
import './App.css';

// Placeholder image (you can replace this with a local image path if needed)
const officeImage = "https://via.placeholder.com/300x200?text=Office+Space";

function App() {
  // Requirement: Create a list of Objects to display details like Name, Rent, and Address[cite: 22, 23].
  const officeSpaces = [
    { id: 1, Name: "DBS", Rent: 50000, Address: "Chennai" },
    { id: 2, Name: "Tech Hub", Rent: 75000, Address: "Bangalore" } 
  ];

  // Requirement: Create an element to display the heading[cite: 20].
  const headingElement = "Office Space";

  return (
    <div className="App" style={{ padding: '20px', fontFamily: 'Arial' }}>
      {/* Requirement: Loop through the office space item to display data. */}
      {officeSpaces.map((item) => {
        
        // Requirement: Display the color of Rent in Red if <= 60000, Green if > 60000[cite: 24].
        const rentColor = item.Rent <= 60000 ? 'red' : 'green';

        return (
          <div key={item.id} style={{ marginBottom: '40px' }}>
            <h1>{headingElement} , at Affordable Range</h1>
            
            {/* Requirement: Attribute to display the image of the office space[cite: 21]. */}
            <img 
              src={officeImage} 
              width="25%" 
              height="25%" 
              alt={`${item.Name} Office`} 
            />
            
            <h1>Name: {item.Name}</h1>
            
            {/* Requirement: Use inline CSS in JSX  to apply the calculated color[cite: 24]. */}
            <h3 style={{ color: rentColor, fontWeight: 'bold' }}>
              Rent: Rs. {item.Rent}
            </h3>
            
            <h3>Address: {item.Address}</h3>
            
            <hr style={{ width: '30%', marginLeft: '0' }} />
          </div>
        );
      })}
    </div>
  );
}

export default App;