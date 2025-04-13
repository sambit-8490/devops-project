import { useState, useEffect } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { createMember } from "../services/MembersService";
import { getMemberById } from "../services/MembersService";
import { updateMember } from "../services/MembersService";


const AddMemberComponent = () => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [phone, setPhone] = useState("");
    const navigate = useNavigate();

    const { id } = useParams();//destructure id from the URL

    const [errors, setErrors] = useState({
        name: "",
        email: "",
        phone: ""
    });

    useEffect(() => {
        if (id) {
            getMemberById(id).then(response => {
                setName(response.data.data.name);
                setEmail(response.data.data.email);
                setPhone(response.data.data.phone);
            }).catch(error => {
                console.error(error);
            });
        }
    }, [id]);

    // save or update member
    function saveOrUpdateMember(e) {
        e.preventDefault();
        let member = { name, email, phone };

        if (validateForm()) {
            console.log(member);
            if (id) {
                //update
                const member2 = { id, name, email, phone };
                updateMember(member2).then(response => {
                    console.log(response.data);
                    alert("Member updated successfully");
                    navigate("/members");
                }).catch(error => {
                    console.error(error);
                    alert("An error occurred");
                }
                );
            } else {
                //save
                createMember(member).then(response => {
                    console.log(response);
                    alert("Member added successfully");
                    navigate("/members");
                }).catch(error => {
                    console.error(error);
                    alert("An error occurred");
                });
            }
        }
    }

    // validate form
    function validateForm() {
        let isValid = true;

        const errorCopy = { ...errors };

        if (name.trim()) {
            errorCopy.name = '';
        } else {
            errorCopy.name = 'Name is required';
            isValid = false;
        }

        if (email.trim()) {
            errorCopy.email = '';
        } else {
            errorCopy.email = 'Email is required';
            isValid = false;
        }

        if (phone.toString().trim()) {
            errorCopy.phone = '';
        } else {
            errorCopy.phone = 'Phone is required';
            isValid = false;
        }
        setErrors(errorCopy);
        return isValid;
    }

    function pageTitle() {
        if (id) {
            return <h3 className="text-center">Update Member</h3>;
        } else {
            return <h3 className="text-center">Add Member</h3>;
        }
    }

    return (
        <div>
            <div className="container">
                <br />
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        {pageTitle()}
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label>Name:</label>
                                    <input placeholder="Name" name="name" className={`form-control ${errors.name ? 'is-invalid' : ''}`}
                                        value={name} onChange={(e) => setName(e.target.value)} />
                                    {errors.name && <div className="invalid-feedback">{errors.name}</div>}
                                </div>
                                <div className="form-group">
                                    <label>Email:</label>
                                    <input placeholder="Email" name="email" className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                                        value={email} onChange={(e) => setEmail(e.target.value)} />
                                    {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                                </div>
                                <div className="form-group">
                                    <label>Phone:</label>
                                    <input placeholder="Phone" name="phone" className={`form-control ${errors.phone ? 'is-invalid' : ''}`}
                                        value={phone} onChange={(e) => setPhone(e.target.value)} />
                                    {errors.phone && <div className="invalid-feedback">{errors.phone}</div>}
                                </div>
                                <button className="btn btn-success" onClick={saveOrUpdateMember}>Save</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    )
}

export default AddMemberComponent;

