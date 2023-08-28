import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
import { DELETE_USER, GET_ALL_USERS } from "../redux/UserActions";

function User() {
    const users = useSelector(state => state.users);
    const dispatch = useDispatch();
    useEffect(() => {
        getUsers();
    }, [])
    const getUsers = () => {
        dispatch({
            type: GET_ALL_USERS,
        })
    }
    const handleDeleteButton = (id) =>{
        dispatch({
            type: DELETE_USER,
            payload: id
        })
    }
    return (
        <>
            <div>
                <h1>User List</h1>
                <table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Website</th>
                            <th>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            users.map(user => (
                                <tr key={user.id}>
                                    <td>{user.id}</td>
                                    <td>{user.name}</td>
                                    <td>{user.email}</td>
                                    <td>{user.website}</td>
                                    <td><button type="button" onClick={()=> {handleDeleteButton(user.id)}}> Delete</button></td>
                                </tr>

                            ))
                        }
                    </tbody>
                </table>
            </div>
        </>
    )
}
export default User;