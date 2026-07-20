import React from 'react';
import Post from './Post';

class Posts extends React.Component {
    constructor(props) {
        super(props);
        // Initialize the component with a list of Posts in state
        this.state = {
            posts: []
        };
    }

    // Method to fetch data and assign it to state
    loadPosts() {
        fetch('https://jsonplaceholder.typicode.com/posts')
            .then(response => response.json())
            .then(data => {
                // Convert the raw JSON data into instances of our Post class
                const fetchedPosts = data.map(item => new Post(item.id, item.title, item.body));
                
                // Update the state with the new posts
                this.setState({ posts: fetchedPosts });
            })
            .catch(error => {
                console.error("Error fetching data:", error);
            });
    }

    // Lifecycle hook that runs after the component is added to the DOM
    componentDidMount() {
        this.loadPosts();
    }

    // Lifecycle hook to catch errors in child components
    componentDidCatch(error, info) {
        alert("An error occurred in the component: " + error.toString());
    }

    // Method to display the title and body of posts
    render() {
        return (
            <div style={{ padding: '20px', fontFamily: 'sans-serif' }}>
                <h1>Latest Blog Posts</h1>
                <hr />
                {this.state.posts.map(post => (
                    <div key={post.id} style={{ marginBottom: '20px', borderBottom: '1px solid #ccc', paddingBottom: '10px' }}>
                        <h2 style={{ color: '#0056b3' }}>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;