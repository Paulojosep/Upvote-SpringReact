import axios from 'axios';

const api = axios.create({
    baseURL: "http://localhost:8080/"
});

export function postUpVote(params) {
    return axios.post('/posts/upvote',params);
}

export default api;