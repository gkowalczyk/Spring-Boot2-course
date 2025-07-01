import React, {useState} from 'react'

const LoginForm = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [rememberDays, setRememberDays] = useState(7);

    const handleSubmit = async (e) => {
        e.preventDefault();
        const formData = new URLSearchParams();
        formData.append('username', username);
        formData.append('password', password);
        formData.append('remember-me', 'on');
        formData.append('remember-duration', rememberDays);

        const res = await fetch('https://localhost:443/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
            body: formData,
            credentials: 'include'
        });

        if (res.ok)  window.location.href = 'https://localhost:443/user';
    };

    return (
        <form onSubmit={handleSubmit}>
            <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} placeholder="Login" />
            <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} placeholder="Hasło" />
            <label>
                <br/>
                Zapamiętaj mnie na:
                <select value={rememberDays} onChange={(e) => setRememberDays(Number(e.target.value))}>
                    <option value={7}>7 dni</option>
                    <option value={21}>21 dni</option>
                    <option value={28}>28 dni</option>
                </select>
            </label>
            <button>Zaloguj</button>
        </form>
    );
};
export default LoginForm;