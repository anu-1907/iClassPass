import React from 'react';
import FacebookLogin from 'react-facebook-login';
import { useHistory } from "react-router-dom";




const FbApi=()=>{
    const history = useHistory();

    const handleLogin = async FbApi => {
  
        const res = await fetch("http://iclasspasspipeline.us-east-2.elasticbeanstalk.com/fbApi", {
            method: "POST",
            body: JSON.stringify({
            token: FbApi
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
        <FacebookLogin  cssClass="social fb"
    appId="817055615648677"
    autoLoad={true}
    fields="name,email,picture"
    callback={handleLogin} />
</div>
</div>
</div>


        </>
    )
}
export default FbApi;