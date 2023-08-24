import { React, useEffect, useState } from 'react';
import * as toDoListService from "./ToDoService"
import { toast } from "react-toastify";
import { Field, Formik, Form } from 'formik';
import { useNavigate } from 'react-router';
export function ToDoList() {
    const [toDolist, setToDoList] = useState([]);
    const navigate = useNavigate();
    useEffect(() => {
        getAll();
    }, [])
    const getAll = async () => {
        const result = await toDoListService.getAll();
        setToDoList((prev) => result);
    }

    //Thêm mới
    const addNew = async (values) => {
        const result = await toDoListService.addNew(values);
        alert("thêm mới thành công");
        // toast(`Thêm mới thành công!`)
        // navigate("/my-to-do-list")
        getAll();
    }
    return (
        <>
            <main className="grid">
                <div className="content">
                    <h1 className="title"><b>My To-do-List</b></h1>
                    <hr></hr>
                    <Formik
                        initialValues={{
                            userId: '',
                            title: '',
                            completed: false
                        }}
                    >
                        <div className="input-form">
                            <Form
                                onSubmit={
                                    async (values) => {
                                        await addNew(values);
                                    }
                                }>
                                <label>Nhập User Name:</label>
                                <Field type="text" name="userId" id="userId" />
                                <label>Nhiệm vụ:</label>
                                <Field type='text' name='title' id="title"/>
                                <button type='submit'>Add</button>
                            </Form>
                        </div>
                    </Formik>
                    <table>
                        <tr>
                            <th>To-do List</th>
                            <th>Detail</th>
                            <th>Status</th>
                        </tr>
                        {toDolist.map((todo) => (
                            <tr key={todo.userId}>
                                <td>{todo.id}</td>
                                <td>{todo.title}</td>
                                <td><input type="checkbox" checked={todo.completed}></input>
                                </td>
                            </tr>
                        ))}
                    </table>
                </div>
            </main >
        </>
    )
}