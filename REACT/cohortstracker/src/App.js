import React from 'react';
import CohortDetails from './CohortDetails';

function App() {
  const cohortsData = [
    { id: "INTADMDF10 -.NET FSD", startDate: "22-Feb-2022", status: "Scheduled", coach: "Aathma", trainer: "Jojo Jose" },
    { id: "ADM21JF014 -Java FSD", startDate: "10-Sep-2021", status: "Ongoing", coach: "Apoorv", trainer: "Elisa Smith" },
    { id: "CDBJF21025 -Java FSD", startDate: "24-Dec-2021", status: "Ongoing", coach: "Aathma", trainer: "John Doe" }
  ];

  return (
    <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
      <h1>Cohorts Details</h1>
      <CohortDetails cohorts={cohortsData} />
    </div>
  );
}

export default App;