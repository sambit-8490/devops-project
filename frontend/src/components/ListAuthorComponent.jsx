import { useState } from 'react'
import { useEffect } from 'react'
import { listAuthors } from '../services/AuthorsService';
import { useNavigate } from 'react-router-dom';


const ListAuthorComponent = () => {
    const [authors, setAuthors] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        listAuthors().then((response) => {
            setAuthors((response.data).data);
        }).catch((error) => {
            console.error(error);
        });
    }, [])

    function addAuthorMember() {
        navigate('/add-author');
    }
    return (
        <div className="container">
            <h2 className='text-center'>All Authors</h2>
            <button className='btn btn-primary' onClick={addAuthorMember}>Add Author</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr className='text-center'>
                        <th>Id</th>
                        <th>Author Name</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        authors.map(author =>
                            <tr key={author.id} className='text-center'>
                                <td>{author.id}</td>
                                <td>{author.name}</td>
                            </tr>)
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ListAuthorComponent;