import { useNavigate, Link } from 'react-router';
import { Formik, Form, ErrorMessage, Field } from 'formik';
import { useState, useEffect } from 'react';
import * as serviceContact from "../../service/ContactService";
import "../../css/crudstyle.css";

function CreateContact() {


    return (
        <main className='container'>
                <h1>Create New Contact</h1>
            <Formik
                initialValues={{
                    id: "",
                    startDay: "",
                    endDay: "",
                    deposit: 0,
                    totalPayment: 0,
                }}
            >
                <Form>
                    <table>
                        <tr>
                            <th><label htmlFor='code'>No. : </label></th>
                            <td><Field className="form-control" type="text" name="code" id="code" />
                                <small><ErrorMessage name='code' component="span" className='form-error' /></small>
                            </td>
                        </tr>
                        <tr>
                            <th><label htmlFor='nameService' className='form-label'>Start-Day:</label></th>
                            <td><Field className="form-control" type="date" name="startDay" id="startDay" />
                                <small><ErrorMessage className='form-error' component='span' name='startDay' id="startDayF" /></small>
                            </td>
                        </tr>
                        <tr>
                            <th><label htmlFor='endDay' className='form-label'>End-Day:</label></th>
                            <td><Field className="form-control" type="date" name="endDay" id="endDay" />
                                <small><ErrorMessage className='form-error' component='span' name='endDay' id="endDay" /></small>
                            </td>
                        </tr>
                        <tr>
                            <th><label htmlFor='deposit' className='form-label'>Deposit:</label></th>
                            <td><Field className="form-control" type="number" name="endDay" id="endDay" />
                                <small><ErrorMessage className='form-error' component='span' name='endDay' id="endDay" /></small>
                            </td>
                        </tr>
                        <tr>
                            <th><label htmlFor='totalPayment' className='form-label'>Total Payment:</label></th>
                            <td><Field className="form-control" type="number" name="totalPayment" id="totalPayment" />
                                <small><ErrorMessage className='form-error' component='span' name='totalPayment' id="totalPayment" /></small>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button class="btn btn-dark" type="submit"><b>Create</b></button>
                            </td>
                        </tr>
                    </table>
                </Form>
            </Formik>
        </main>
    )
}
export default CreateContact;