import { useState } from 'react'
import { useEffect } from 'react'
import { listLoans } from '../services/LoansService';
import { useNavigate } from 'react-router-dom';

const ListBookComponent = () => {
    const [loans, setLoans] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        listLoans().then((response) => {
            setLoans((response.data).data);
        }).catch((error) => {
            console.error(error);
        });
    }, [])

    function addNewLoan() {
        navigate('/add-loan');
        }
    return (
        <div className="container">
            <h2 className='text-center'>All Loans</h2>
            <button className='btn btn-primary' onClick={addNewLoan}>Add Loan</button>
            <table className='table table-striped table-bordered'>
                <thead>
                    <tr className='text-center'>
                        <th>Id</th>
                        <th>Member Name</th>
                        <th>Book Name</th>
                        <th>Loan Date</th>
                        <th>Return Date</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        loans.map(loan =>
                            <tr key={loan.id} className='text-center'>
                                <td>{loan.id}</td>
                                <td>{loan.member.name}</td>
                                <td>{loan.book.title}</td>
                                <td>{loan.loanDate}</td>
                                <td>{loan.returnDate}</td>
                            </tr>)
                    }
                </tbody>
            </table>
        </div>
    )
}
export default ListBookComponent;