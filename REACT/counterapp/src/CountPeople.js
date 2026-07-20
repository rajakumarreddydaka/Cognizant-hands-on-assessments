import React from 'react';
import './CountPeople.css';

class CountPeople extends React.Component {
    constructor() {
        super();
        this.state = {
            entrycount: 0,
            exitcount: 0,
            c: 0
        };
    }

    updateEntry() {
        this.setState((prevState) => {
            return { entrycount: prevState.entrycount + 1 }
        });
    }

    updateExit() {
        // THE LOGIC FIX: Only update state if exitcount is strictly less than entrycount
        if (this.state.exitcount < this.state.entrycount) {
            this.setState((prevState) => {
                return { exitcount: prevState.exitcount + 1 }
            });
        } else {
            // Optional: Alert the user if they try to bypass the button
            alert("The mall is currently empty!");
        }
    }

    render() {
        // UX UPGRADE: Determine if the mall is completely empty
        const isMallEmpty = this.state.entrycount === 0 || this.state.exitcount >= this.state.entrycount;

        return (
            <div className="counter-container">
                
                <div className="counter-section">
                    <button onClick={this.updateEntry.bind(this)}>Login</button>
                    <span>{this.state.entrycount} People Entered!!!</span>
                </div>

                <div className="counter-section">
                    {/* The button will gray out and become unclickable when isMallEmpty is true */}
                    <button 
                        onClick={this.updateExit.bind(this)}
                        disabled={isMallEmpty}
                        style={{ cursor: isMallEmpty ? 'not-allowed' : 'pointer' }}
                    >
                        Exit
                    </button>
                    <span>{this.state.exitcount} People Left!!!</span>
                </div>

            </div>
        );
    }
}

export default CountPeople;