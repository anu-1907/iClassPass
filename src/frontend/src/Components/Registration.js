import React from 'react';
import { useState,useEffect } from 'react';
import {Link} from 'react-router-dom';
import './Style.css'

import { useHistory } from 'react-router';
import NewGapi from './GApi';
import FbApi from './FbApi';

const Registration=()=>{
    const history = useHistory();
   

    const [user,setUser]=useState({
       
        name:"",
        email:"",
        contact:"",
        password:""

    })
    function changeHandler(event){

        setUser( {...user,[event.target.name]:event.target.value})
    }
    const saveUser = async(event)=>{
        event.preventDefault();
       const res=  await fetch("http://localhost:5000/signup",{
            headers: {
                'Accept': "application/json, text/plain, */*",
                'Content-Type': "application/json;charset=utf-8"
            },
            credentials:'include',
            method:'POST',
            body:JSON.stringify(user)

        })
        let token = res.json()

        token.then(function (result){
        sessionStorage.setItem('token', JSON.stringify(result));
        const tokenString=sessionStorage.getItem('token')
        const users = JSON.parse(tokenString);
        let key=users;
        setApi(key);

        return key;

        })
    }
    const [api,setApi]=useState();
    if(api!=null){
        history.push('./');

    }
    return(
        <>
          <div className="container-fluid nav_bg main-container">
           <div className="row">
               <div className="col-6 mx-auto form-container">
                
               <form >
                        <div classname="mb-3">
                            <label for="exampleInputEmail1" classname="form-label">Name</label>
                            <input type="text"  className="form-control" value={user.username}  name='name' onChange={changeHandler} classname="form-control"  />
                        </div>
                        <div classname="mb-3">
                            <label for="exampleInputPassword1"  classname="form-label">Email</label>
                            <input type="email"  className="form-control" value={user.email}  name='email' onChange={changeHandler} classname="form-control"  />
                        </div>
                        <div classname="mb-3">
                            <label for="exampleInputPassword1"  classname="form-label">Contact</label>
                            <input type="number"  className="form-control" value={user.contact}  name='contact' onChange={changeHandler} classname="form-control" />
                        </div>
                        <div classname="mb-3">
                            <label for="exampleInputPassword1"  classname="form-label">Password</label>
                            <input type="password"  className="form-control" value={user.password}  name='password' onChange={changeHandler} classname="form-control" />
                        </div>
                        
                        <button type="submit" className="btn btn-md  btn-primary"  onClick={saveUser} >Submit</button>
                </form>
                        <div className='or-sec'><span className="or-text">or</span></div>
                        <div> <Link to="/login">Already a member? Sign In!</Link></div>
                        <div ><NewGapi/></div>
                        <div ><FbApi/></div>

                        
                        
                        </div>
               </div>
           </div>

       

        </>

    );
}
export default Registration;