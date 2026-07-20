import React from 'react';

function CohortDetails({ cohort }) {
  if (!cohort) return <div>No Cohort Data</div>;
  
  return (
    <div className="cohort-container">
      {/* The h3 tag specifically requested in Test 3 */}
      <h3>{cohort.cohortCode}</h3>
      <p>Name: {cohort.name}</p>
      <p>Status: {cohort.status}</p>
    </div>
  );
}

export default CohortDetails;