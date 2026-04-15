import React, { useState } from 'react'
import adminLogin from '../../api/adminLogin';

const AdminLoginPage = () => {

    //React useState hooks

    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");

    const handleLogin = () => {
        const res = adminLogin(email, pass);
        if(res === "Login Success"){
            //redirect to dashboard
        }else{
            //show login error
        }
    }

    
    return (
        <div>
            <form onSubmit={handleLogin}>
                <input type="email"
                    name="adminEmail"
                    id=""
                    onChange={(e) => setEmail(e.target.value)}
                />
                <input type="password"
                    name="adminPass"
                    id=""
                    onChange={(e) => setPass(e.target.value)}
                />
                <button type="submit">Login Now</button>
            </form>
        </div>
    )
}

export default AdminLoginPage