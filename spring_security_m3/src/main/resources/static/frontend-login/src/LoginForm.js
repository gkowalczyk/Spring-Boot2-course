import React, {useState} from 'react';

const LoginForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState(null);
    const[rememberMe, setRememberMe] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();

        const formData = new URLSearchParams();
        formData.append('username', username);
        formData.append('password', password);
        formData.append('remember-me', rememberMe ? 'on' : '');

        try {
            const response = await fetch('http://localhost:8080/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: formData,
                credentials: 'include'
            });
            if (response.ok) {
                window.location.href = 'http://localhost:8080/user';
            } else {
                setError(`Błąd logowania: ${response.status} ${response.statusText}`);
            }
        } catch (error) {
            setError(`Błąd połączenia: ${error.message}`);
        }
    };
    return (
        <form onSubmit={handleSubmit}>

            <input type ="text"
                     placeholder="Nazwa użytkownika"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
            />
            <input
                type="password"
                placeholder="Hasło"
                value={password}
                onChange={(e) => setPassword(e.target.value)}
            /><br />

            <label>
                <input
                    type="checkbox"
                    checked={rememberMe}
                    onChange={(e) => setRememberMe(e.target.checked)}
                />
                Zapamiętaj mnie
            </label><br />

            <button type="submit">Zaloguj</button>
        </form>
    );
};

export default LoginForm;