import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './Home';
import TrainersList from './TrainersList';
import TrainerDetail from './TrainerDetails';
import trainersMock from './trainersMock';

function App() {
  return (
    <Router>
      <div style={{ fontFamily: 'sans-serif', margin: '20px' }}>
        
        {/* Main Application Header */}
        <h1>My Academy Trainers App</h1>
        
        {/* Navigation Links */}
        <nav style={{ marginBottom: '20px', fontSize: '18px' }}>
          <Link to="/">Home</Link> | <Link to="/trainers">Show Trainers</Link>
        </nav>
        
        {/* Route Definitions */}
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainersList trainers={trainersMock} />} />
          {/* Dynamic route passing the trainer ID */}
          <Route path="/trainers/:id" element={<TrainerDetail />} />
        </Routes>
        
      </div>
    </Router>
  );
}

export default App;