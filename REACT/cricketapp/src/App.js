import React from 'react';
import { ListOfPlayers, ScoreBelow70 } from './ListOfPlayers';
import { OddPlayers, EvenPlayers, ListOfIndianPlayers } from './IndianPlayers';

function App() {
  // 1. Array of 11 Players
  const players = [
    { name: "Jack", score: 50 }, { name: "Michael", score: 70 },
    { name: "John", score: 40 }, { name: "Ann", score: 61 },
    { name: "Elisabeth", score: 61 }, { name: "Sachin", score: 95 },
    { name: "Dhoni", score: 100 }, { name: "Virat", score: 84 },
    { name: "Jadeja", score: 64 }, { name: "Raina", score: 75 },
    { name: "Rohit", score: 80 }
  ];

  // 2. Destructuring Target Array
  const IndianTeam = ["Sachin1", "Dhoni2", "Virat3", "Rohit4", "Yuvaraj5", "Raina6"];

  // 3. Merging Arrays using ES6 Spread Operator (...)
  const T20Players = ['First Player', 'Second Player', 'Third Player'];
  const RanjiTrophyPlayers = ['Fourth Player', 'Fifth Player', 'Sixth Player'];
  const IndianPlayers = [...T20Players, ...RanjiTrophyPlayers];

  // CONDITIONAL FLAG (Change to false to see the other page layout)
  var flag = true;

  if (flag === true) {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>List of Players</h1>
        <ListOfPlayers players={players} />
        <hr />
        <h1>List of Players having Scores Less than 70</h1>
        <ScoreBelow70 players={players} />
      </div>
    );
  } else {
    return (
      <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
        <h1>Odd Players</h1>
        {/* Calling function components directly as per the lab hint */}
        {OddPlayers(IndianTeam)}
        <hr />
        <h1>Even Players</h1>
        {EvenPlayers(IndianTeam)}
        <hr />
        <h1>List of Indian Players Merged:</h1>
        <ListOfIndianPlayers IndianPlayers={IndianPlayers} />
      </div>
    );
  }
}

export default App;