import { useState } from 'react'
import { useEffect } from 'react'
import { listBooks } from '../services/BooksService';
import { useNavigate } from 'react-router-dom';

const ListBookComponent = () => {
    const [books, setBooks] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        listBooks().then((response) => {
            setBooks((response.data).data);
        }).catch((error) => {
            console.error(error);
        });
    }, [])

    function addNewBook() {
        navigate('/add-book');
    }
    return (
        <div className="container">
            <h2 className='text-center'>All Books</h2>
            <button className='btn btn-primary' onClick={addNewBook}>Add Book</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr className='text-center'>
                        <th>Id</th>
                        <th>Book Title</th>
                        <th>Book Genre</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        books.map(book =>
                            <tr key={book.id} className='text-center'>
                                <td>{book.id}</td>
                                <td>{book.title}</td>
                                <td>{book.genre}</td>
                            </tr>)
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ListBookComponent;