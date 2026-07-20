import React from 'react';

class Cart extends React.Component {
    render() {
        return (
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Price</th>
                    </tr>
                </thead>
                <tbody>
                    {/* Looping through the array passed down via props */}
                    {this.props.item.map((item, index) => {
                        return (
                            <tr key={index}>
                                <td> {item.itemname} </td>
                                <td> {item.price} </td>
                            </tr>
                        );
                    })}
                </tbody>
            </table>
        );
    }
}

export default Cart;