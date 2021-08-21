import React from 'react';
import  {useState,useEffect} from "react";
import { useHistory } from "react-router-dom";
import jwt_decode from "jwt-decode";


const Dashboard=()=>{
    const history = useHistory();

    const [body,setBody]=useState('')
    // const [token, setToken]=useState()


    const tokenString=sessionStorage.getItem('token')
    const token =  JSON.parse(tokenString);
    console.log(token)

    if(token==null){
        history.push('/login');
        return null;

    }
        let decoded= jwt_decode(tokenString);
        console.log(decoded.sub);

    
     const logout=userLogout=>{
            sessionStorage.setItem('token', null);
              history.push('/login');
              
        }
    
    return(
        <>
          <div className="container-fluid nav_bg">
           <div className="row">
               <div className="col-10 mx-auto">
                  welcome <h5>{decoded.sub}</h5> to your dashboard!
                   < button type='button' onClick={logout} className='btn btn-lg btn-primary' >Logout</button>

                   

               </div>
           </div>

       </div>

        </>

    );
    
}
export default Dashboard;