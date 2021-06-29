import React, { Component } from 'react';
import api from '../services/api'
import {Link} from 'react-router-dom'


class NewPost extends Component {
    constructor(props) {
        super(props)

        this.state = {
            title: '',
            text: ''
        };
    }

    changeHandler = (e) => {
        this.setState({[e.target.name]: e.target.value})
    }

    goBanck() {
        this.props.history.push('/');
    }

    submitHandler = e => {
        e.preventDefault()
        console.log(this.state)
        api.post('posts', this.state).then(response => {
            console.log(response)
            alert("salvo com sucesso!");
        })
        .catch(error => {
            console.log(error)
        })
        
    }

    render(){
        const {title, text} = this.state
        return (
            <>
                <form onSubmit={this.submitHandler}>
                    <h1>Novo Poster</h1>

                    <div>
                        <h2>Title</h2>
                        <input type="text" name="title" value={title} onChange={this.changeHandler} />
                    </div>
                    <br/>
                    <div className="form-floating">
                        <h3>Description</h3>
                        <textarea className="form-control" type="text" name="text" value={text} onChange={this.changeHandler} ></textarea>
                    </div>
                    <br/>
                    <div className="buttons">
                        
                        <button  type="submit" className="btn btn-primary">
                            Salvar
                        </button>

                        <Link className="btn btn-danger" to="/">
                            Cancelar
                        </Link>
                    </div>


                </form>
            </>
        );
    }
}

export default NewPost;