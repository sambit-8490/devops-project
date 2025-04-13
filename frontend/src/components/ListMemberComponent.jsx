import { useState } from 'react'
import { useEffect } from 'react'
import { listMembers } from '../services/MembersService';
import { useNavigate } from 'react-router-dom';
import { deleteMember } from '../services/MembersService';

const ListMemberComponent = () => {
    const [members, setMembers] = useState([]);
    const navigate = useNavigate();

    useEffect(() => {
        getAllEmployee();

    }, [])

    function getAllEmployee() {
        listMembers().then((response) => {
            setMembers((response.data).data);
        }).catch((error) => {
            console.error(error);
        });
    }
    
    function addNewMember() {
        navigate('/add-member');
    }


    function updateMember(id) {
        navigate(`/edit-member/${id}`);
    }

    //delete member
    function removeMember(id) {
        if (window.confirm("Are you sure you want to delete this member?")) {
            deleteMember(id).then(response => {
                console.log(response);
                alert("Member deleted successfully");
                navigate("/members");
                getAllEmployee();
            }
            ).catch(error => {
                console.error(error);
                alert("An error occurred");
            });
        }
    }
        return (
            <div className="container">
                <h2 className='text-center'>All Members</h2>
                <button className='btn btn-primary' onClick={addNewMember}>Add Member</button>
                <table className='table table-striped table-bordered'>
                    <thead>
                        <tr className='text-center'>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email ID</th>
                            <th>Phone</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            members.map(member =>
                                <tr key={member.id} className='text-center'>
                                    <td>{member.id}</td>
                                    <td>{member.name}</td>
                                    <td>{member.email}</td>
                                    <td>{member.phone}</td>
                                    <td>
                                        <button className='btn btn-info' onClick={() => updateMember(member.id)}>Update</button>
                                        <button className='btn btn-danger' onClick={()=> removeMember(member.id)} style={{marginLeft:'10px'}}>Delete</button>
                                    </td>
                                </tr>)
                        }
                    </tbody>
                </table>
            </div>
        )
    }
    export default ListMemberComponent;