import { useNavigate } from "react-router-dom";
import '../styles/HomeComponent.css';
import NavbarComponent from './NavbarComponent';
import FooterComponent from './FooterComponent';
const HomeComponent = () => {

    const navigate = useNavigate();

    function viewMembers() {
        navigate("/members");
    }

    function viewAuthors() {
        navigate("/authors");
    }

    function viewBooks() {
        navigate("/books");
    }

    function viewLoans() {
        navigate("/loans");
    }
    return (
        <>
            <div className="hom-container">
                <NavbarComponent />
                <div className='home'>
                    <h1>Welcome to the Library Management System</h1><br />
                    <button className='btn btn-primary' onClick={viewMembers}>Members</button> <br />
                    <button className='btn btn-primary' onClick={viewAuthors}>Authors</button><br />
                    <button className='btn btn-primary' onClick={viewBooks}>View Books</button><br />
                    <button className='btn btn-primary' onClick={viewLoans}>View Loans</button><br />
                    <h2>Click on the links above to navigate</h2>
                </div>
                <FooterComponent />
            </div>
        </>
    );
}
export default HomeComponent;