<<<<<<< HEAD
// import './App.css';
import '../node_modules/bootstrap/dist/css/bootstrap.min.css';
import '../node_modules/bootstrap/dist/js/bootstrap.bundle';
import {BrowserRouter as Router, Route,Switch} from 'react-router-dom';
import Registration from './Components/Registration';
import Login from './Components/Login';
import Dashboard from './Components/Dashboard';

=======
import logo from './logo.svg';
import './App.css';
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3

function App() {
  return (
    <div className="App">
<<<<<<< HEAD
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
      
=======
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
>>>>>>> 174258d294c2c787554ed0cfe8d7433712b038e3
    </div>
  );
}

export default App;
