import React from 'react';
import { Link } from 'react-router-dom';
import './styles.css';

const Header = () => {
    return (
        <>
        
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">
                    <a className="navbar-brand">UpVote</a>
                    <form className="d-flex">
                        <Link to="/newPost" >
                            <button className="btn btn-outline-success" type="submit" href="/newPost">New Post</button>
                        </Link>
                    </form>
                </div>
            </nav>
            
        </>
    );
}

export default Header;