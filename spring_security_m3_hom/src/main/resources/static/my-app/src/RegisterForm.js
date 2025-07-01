import React, {useState} from 'react'

const RegisterForm = () => {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [role, setRole] = useState('USER');

    const handleSubmit = async (e) => {
        e.preventDefault();
        const res = await fetch('https://localhost:443/register', {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({ username: email, password, requestedRole: role })
        });
        if (res.ok) alert('Zarejestrowano! Sprawdź maila');
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder="Email"/>
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Hasło"/>
            <br/>
            <label>
                <input type="radio" value="USER" checked={role === 'USER'} onChange={() => setRole('USER')}/> User
            </label>
            <label>
                <input type="radio" value="ADMIN" checked={role === 'ADMIN'} onChange={() => setRole('ADMIN')}/> Admin
            </label>
            <br/>
            <button type="submit">Zarejestruj</button>
        </form>
    );
};

export default RegisterForm;