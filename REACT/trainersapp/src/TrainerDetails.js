import React from 'react';
import { useParams } from 'react-router-dom';
import trainersMock from './trainersMock';

const TrainerDetail = () => {
    // Retrieve the parameter named 'id' from the URL
    const { id } = useParams();
    
    // Query the mock data using the ID
    const trainer = trainersMock.find(t => t.trainerId === id);

    if (!trainer) return <div>Trainer not found</div>;

    return (
        <div>
            <h2>Trainers Details</h2>
            <br />
            <h3>{trainer.name} ({trainer.technology})</h3>
            <br />
            <p>{trainer.email}</p>
            <br />
            <p>{trainer.phone}</p>
            <br />
            <ul>
                {trainer.skills.map((skill, index) => (
                    <li key={index}>{skill}</li>
                ))}
            </ul>
        </div>
    );
};

export default TrainerDetail;