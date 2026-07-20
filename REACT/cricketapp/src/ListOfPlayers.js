import React from 'react';

// ES6 Map Feature
export function ListOfPlayers({ players }) {
    return (
        <ul>
            {players.map((item, index) => (
                <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
            ))}
        </ul>
    );
}

// ES6 Arrow Function & Filtering
export function ScoreBelow70({ players }) {
    // We filter the array first, then map it
    const players70 = players.filter(item => item.score <= 70);
    
    return (
        <ul>
            {players70.map((item, index) => (
                <li key={index}>Mr. {item.name} <span>{item.score}</span></li>
            ))}
        </ul>
    );
}