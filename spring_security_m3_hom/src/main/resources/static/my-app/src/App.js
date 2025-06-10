
import './App.css';

import LoginForm from './LoginForm'
import RegisterForm from './RegisterForm';

function App() {
    return(
        <div>
            <h1>Logowanie</h1>
            <LoginForm/>
            <hr />
            <h1>Rejestracja</h1>
            <RegisterForm />
        </div>
    );
}
export default App;
