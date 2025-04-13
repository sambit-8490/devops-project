import '../styles/NavbarComponent.css';
import {useNavigate} from 'react-router-dom';
const NavbarComponent = () => {
  const navigate = useNavigate();

  const home = () => {
    navigate('/')
  }
  const login = () => {
    navigate('/login')
  }
  return (
    <div>
    <header>
        <nav className='navbar navbar-dark bg-dark'>
        <a className="navbar-brand" href="https://rajnishrv.github.io/Portfolio/">Profile</a>
        <button className='btn btn-primary' onClick={home}>Home</button>
        <button className="btn btn-primary" type="button" onClick={login}>Login</button>

        </nav>
    </header>
</div>
  )
}

export default NavbarComponent