import { React } from 'react';
export function EditCustomer() {
    return (
        <main className="grid">
            <div class="main-title">
                <img src="https://www.365travel.asia/images/tour/items/img2/furama-resort-danang-banner.jpg"
                    alt="furama  resort" />
                <h2>EDIT CUSTOMER</h2>
            </div>
            <form action="#">
                <table>
                    <tr>
                        <th>Full name: </th>
                        <td><input type="text" /></td>
                    </tr>
                    <tr>
                        <th>Birthday</th>
                        <td><input type="date" /></td>
                    </tr>
                    <tr>
                        <th>Gender</th>
                        <td>
                            <input className="radio-input" type="radio" value="Male" /> Male
                            <input className="radio-input" type="radio" value="Female" /> Female
                            <input className="radio-input" type="radio" value="Other" /> Other
                        </td>
                    </tr>
                    <tr>
                        <th>Citizen</th>
                        <td><input type="number" /></td>
                    </tr>
                    <tr>
                        <th>Number Phone</th>
                        <td><input type="number" /></td>
                    </tr>
                    <tr>
                        <th>Email</th>
                        <td><input type="number" /></td>
                    </tr>
                    <tr>
                        <th>Type of customer</th>
                        <td>
                            <select name="typeOfCustomer" id="typeOfCustomer">
                                <option value="Diamond">Diamond</option>
                                <option value="Platinium">Platinium</option>
                                <option value="Gold">Gold</option>
                                <option value="Silver">Silver</option>
                                <option value="Member">Member</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button class="form-btn" type="submit"><b>ADD NEW</b></button>
                        </td>
                    </tr>
                </table>
            </form>
        </main>
    )
}