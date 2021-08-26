// import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.bundle';
import {BrowserRouter as Router, Route,Switch} from 'react-router-dom';
import Registration from './Components/Registration';
import Login from './Components/Login';
import Dashboard from './Components/Dashboard';


function App() {
  return (
    <div className="App">
      <Router>
        <Switch>
          <Route exact path='/'>
            <Dashboard/>
          </Route>
          <Route exact path='/registration'>
            <Registration/> 
          </Route>
          <Route exact path='/login'>
            <Login/> 
          </Route>
        </Switch>
      </Router>
      
    </div>
  );
}

export default App;
