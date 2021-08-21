import React from 'react';
import { GoogleLogin } from 'react-google-login';
import { useHistory } from "react-router-dom";




const NewGapi=()=>{
    const clientId="897936785153-9nvngsr3m32mbal4sm7h9m3fiotj7u7r.apps.googleusercontent.com"
    const history = useHistory();

    const handleLogin = async googleData => {
  
        const res = await fetch("http://localhost:8080/", {
            method: "POST",
            body: JSON.stringify({
            token: googleData.tokenId
          }),
          headers: {
            "Content-Type": "application/json"
          }
        })

        const data = await res.json();
        sessionStorage.setItem('token', JSON.stringify(data));
        if(data.jwtToken!=null){
            history.push('./')
        }



        
    }
    

    return(
        <>
        <div className="container-fluid nav_bg">
           <div className="row">
               <div className="col-10 mx-auto"></div>
        <div >
        <GoogleLogin className="social"
    clientId={clientId}
    buttonText="Log in with Google"
    onSuccess={handleLogin}
    onFailure={handleLogin}
    cookiePolicy={'single_host_origin'}
/>
</div>
</div>
</div>


        </>
    )
}
export default NewGapi;