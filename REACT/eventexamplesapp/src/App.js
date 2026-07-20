import React from 'react';
import CounterEvents from './CounterEvents';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  return (
    <div style={{ padding: '30px', fontFamily: 'sans-serif', maxWidth: '800px', margin: '0 auto' }}>
      <h1 style={{ textAlign: 'center', color: '#333' }}>React Events Lab</h1>
      <hr style={{ marginBottom: '30px' }} />
      
      <CounterEvents />
      <CurrencyConvertor />
    </div>
  );
}

export default App;