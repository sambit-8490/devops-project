import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createMember } from "../services/MembersService";

const AddLoanComponent = () => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const navigate = useNavigate();
    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Add Member</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label>Name:</label>
                                    <input placeholder="Name" name="name" className="form-control"
                                        value={name} onChange={(e) => setName(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label>Email:</label>
                                    <input placeholder="Email" name="email" className="form-control"
                                        value={email} onChange={(e) => setEmail(e.target.value)} />
                                </div>
                                <div className="form-group">
                                    <label>Phone:</label>
                                    <input placeholder="Phone" name="phone" className="form-control"
                                        value={phone} onChange={(e) => setPhone(e.target.value)} />
                                </div>
                                <button className="btn btn-success" onClick={(e) => {
                                    e.preventDefault();
                                    createMember({ name, email, phone }).then(response => {
                                        console.log(response);
                                        alert("Member added successfully");
                                        navigate("/members");
                                    }).catch(error => {
                                        console.error(error);
                                        alert("An error occurred");
                                    });
                                }}>Save</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddLoanComponent;

