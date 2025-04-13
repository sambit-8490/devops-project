import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createAuthor } from "../services/AuthorsService";

const AddAuthorComponent = () => {
    const [name, setName] = useState("");
    const navigate = useNavigate();
    return (
        <div>
            <div className="container">
                <div className="row">
                    <div className="card col-md-6 offset-md-3 offset-md-3">
                        <h3 className="text-center">Add Author</h3>
                        <div className="card-body">
                            <form>
                                <div className="form-group">
                                    <label>Name:</label>
                                    <input placeholder="Name" name="name" className="form-control"
                                        value={name} onChange={(e) => setName(e.target.value)} />
                                </div>

                                <button className="btn btn-success" onClick={(e) => {
                                    e.preventDefault();
                                    createAuthor({ name }).then(response => {
                                        console.log(response);
                                        alert("Member added successfully");
                                        navigate("/authors");
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

export default AddAuthorComponent