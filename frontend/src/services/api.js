import axios from 'axios';

const api = axios.create({
    baseURL: "https://db-upvotes.herokuapp.com/"
});

export default api;