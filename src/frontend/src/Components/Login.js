import React from 'react';
import  {useState,useEffect} from "react";
import { useHistory } from "react-router-dom";
import NewGapi from './GApi';
import {Link} from 'react-router-dom';
import FbApi from './FbApi';
import './Style.css'


const Login=()=>{
    const history = useHistory();
   

    const [user,setUser]=useState({
       
        email:"",
        password:""

    })
    function changeHandler(event){

        setUser( {...user,[event.target.name]:event.target.value})


    }

    const saveUser = async(event)=>{
        event.preventDefault();
       const res=  await fetch("http://localhost:8080/authenticate",{
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
        history.push('./')
    }
    return(
        <>
          <div className="container-fluid nav_bg main-container">
           <div className="row">
               <div className="col-6 container-fluid mx-auto form-container ">

               <form>
                        <div className="mb-3">
                            <label for="exampleInputEmail1" className="form-label">Email address</label>
                            <input type="email"  className="form-control " value={user.email}  name='email' onChange={changeHandler} id="exampleInputEmail1" />
                            
                        </div>
                        <div className="mb-3">
                            <label for="exampleInputPassword1" className="form-label">Password</label>
                            <input type="password"  className="form-control" value={user.password}  name='password' onChange={changeHandler} id="exampleInputPassword1"/>
                        </div>
                        
                        <button type="submit" className="btn btn-md btn-primary" onClick={saveUser}>Login</button>
                </form>
                        <div className='or-sec'><span className="or-text">or</span></div>
                        <div> <Link to="/registration">Register Now!</Link></div>

                        <div ><NewGapi/></div>
                        <div ><FbApi/></div>


               </div>
           </div>

       </div>

        </>

    );
}
export default Login;