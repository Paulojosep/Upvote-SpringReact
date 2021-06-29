import Home from "./Page/Home";
import NewPost from "./Page/NewPost";
import { BrowserRouter, Route, Switch } from 'react-router-dom';

const Router = () => {
    return (
        <BrowserRouter>
            <Switch>
                <Route path="/" exact>
                    <Home />
                </Route>
                <Route path="/newPost">
                    <NewPost />
                </Route>
            </Switch>
        </BrowserRouter>
    );
}

export default Router;