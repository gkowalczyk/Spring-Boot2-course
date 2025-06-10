import React, { useState } from 'react';

const RegisterForm = () => {
    const[username, setUsername] = useState('');
    const[password, setPassword] = useState('');
    const[message, setMessage] = useState('');


    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            const response = await fetch('http://localhost:8080/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({username, password}),
            });
            const result = await response.text();
            setMessage(result);
            if (response.ok) {
                alert("Registration successful! You can now log in.");
            }
        } catch (error) {
            setMessage(`Error: ${error.message}`);
            }
        };
    return (
        <form onSubmit={handleSubmit}> {}
            <h2>Rejestracja</h2>
            {}
            <input
                type="text"
                placeholder="Login"
                value={username}
                onChange={(e) => setUsername(e.target.value)}
            /><br />
            {}
            <input
                type="password"
                placeholder="Hasło"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            /><br />
            {}
            <button type="submit">Zarejestruj</button>
            {}
            {message && <p>{message}</p>}
        </form>
    );
};

export default RegisterForm;