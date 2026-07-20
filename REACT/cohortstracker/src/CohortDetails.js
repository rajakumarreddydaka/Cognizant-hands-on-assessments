import React from 'react';
// Step 8: Import the CSS Module
import styles from './CohortDetails.module.css'; 

const CohortDetails = ({ cohorts }) => {
    return (
        <div>
            {cohorts.map((cohort, index) => (
                // Step 9: Apply the box class to the container div
                <div key={index} className={styles.box}>
                    
                    {/* Step 10: Define the style for <h3> element based on status */}
                    <h3 style={{ color: cohort.status === 'Ongoing' ? 'green' : 'blue' }}>
                        {cohort.id}
                    </h3>
                    
                    <dl>
                        <dt>Started On</dt>
                        <dd>{cohort.startDate}</dd>
                        
                        <dt>Current Status</dt>
                        <dd>{cohort.status}</dd>
                        
                        <dt>Coach</dt>
                        <dd>{cohort.coach}</dd>
                        
                        <dt>Trainer</dt>
                        <dd>{cohort.trainer}</dd>
                    </dl>
                </div>
            ))}
        </div>
    );
};

export default CohortDetails;