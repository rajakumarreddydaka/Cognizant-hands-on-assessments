import React from 'react';
import './App.css';

// --- Data Sources ---
const courses = [
  { id: 1, name: 'Angular', date: '4/5/2021' },
  { id: 2, name: 'React', date: '6/3/2021' } 
];

const books = [
  { id: 101, bname: 'Master React', price: 670 },
  { id: 102, bname: 'Deep Dive into Angular 11 ', price: 800 },
  { id: 103, bname: 'Mongo Essentials', price: 450 },
];

const blogs = [
  { id: 1, title: 'React Learning', author: 'Stephen Biz', text: 'Welcome to learning React!' },
  { id: 2, title: 'Installation', author: 'Schewzdenier', text: 'You can install React from npm.' }
];


function App() {
  // ---------------------------------------------------------
  // Conditional Rendering Way 1: Element Variables (If/Else)
  // ---------------------------------------------------------
  let coursedet;
  if (courses.length > 0) {
    coursedet = (
      <ul>
        {courses.map(course => (
          <div key={course.id}>
            <h2>{course.name}</h2>
            <h4>{course.date}</h4>
          </div>
        ))}
      </ul>
    );
  } else {
    coursedet = <h4>No courses available at the moment.</h4>;
  }

  // Extracting Book Details Component (From the Hint)
  const bookdet = (
    <ul>
      {books.map((book) => (
        <div key={book.id}>
          <h3>{book.bname}</h3>
          <h4>{book.price}</h4>
        </div>
      ))}
    </ul>
  );

  return (
    <div className="container">
      
      {/* Column 1: Courses */}
      <div className="mystyle1">
        <h1>Course Details</h1>
        {/* Rendered via Element Variable */}
        {coursedet}
      </div>

      <div className="divider"></div>

      {/* Column 2: Books */}
      <div className="st2">
        <h1>Book Details</h1>
        {/* --------------------------------------------------------- */}
        {/* Conditional Rendering Way 2: Logical && Operator          */}
        {/* If books exist, render bookdet; otherwise render nothing. */}
        {/* --------------------------------------------------------- */}
        {books.length > 0 && bookdet}
      </div>

      <div className="divider"></div>

      {/* Column 3: Blogs */}
      <div className="v1">
        <h1>Blog Details</h1>
        {/* --------------------------------------------------------- */}
        {/* Conditional Rendering Way 3: Ternary Operator (? :)       */}
        {/* --------------------------------------------------------- */}
        {blogs.length > 0 ? (
          <ul>
            {blogs.map(blog => (
              <div key={blog.id}>
                <h2>{blog.title}</h2>
                <h4>{blog.author}</h4>
                <p>{blog.text}</p>
              </div>
            ))}
          </ul>
        ) : (
          <h4>No blogs found.</h4>
        )}
      </div>

    </div>
  );
}

export default App;