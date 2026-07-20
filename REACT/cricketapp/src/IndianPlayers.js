import React from 'react';

// ES6 Destructuring (Extracting specific indexes from the array)
export function OddPlayers([first, , third, , fifth]) {
    return (
        <ul>
            <li>First : {first}</li>
            <li>Third : {third}</li>
            <li>Fifth : {fifth}</li>
        </ul>
    );
}

export function EvenPlayers([, second, , fourth, , sixth]) {
    return (
        <ul>
            <li>Second : {second}</li>
            <li>Fourth : {fourth}</li>
            <li>Sixth : {sixth}</li>
        </ul>
    );
}

// Rendering the merged array
export function ListOfIndianPlayers({ IndianPlayers }) {
    return (
        <ul>
            {IndianPlayers.map((player, index) => (
                <li key={index}>Mr. {player}</li>
            ))}
        </ul>
    );
}