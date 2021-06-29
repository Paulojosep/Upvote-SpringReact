import React, { Component } from 'react';
import api from '../services/api';
import Header from "../Components/Header";

class Home extends Component {
    constructor(props) {
        super(props)
        this.state ={
            posts:[],
            count: 0
        }
    }

    async componentDidMount() {
        const response = await api.get('posts');
        console.log(response.data);

        this.setState({posts: response.data})
    }

    render() {

        const { posts } = this.state;

        return (
            <>
            <Header />

            {posts.map(post => (
                <li key={post.id}>
                    <h1>{post.title}</h1>
                    <h2>
                        <strong>Description: </strong>
                        {post.text}
                    </h2>

                    <button  type="submit">Curtir</button>
                    <a>{post.upvotes}</a>

                </li>
            ))}
            </>
        );
    }
}

export default Home;