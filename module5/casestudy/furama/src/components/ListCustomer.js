import { React } from 'react';
export function ListCustomer() {
    return (
        <main className="grid">
            <img src="https://www.365travel.asia/images/tour/items/img2/furama-resort-danang-banner.jpg" alt="furama  resort" />
            <div className="list">
                <h2>Customer List</h2>
                <table>
                    <tr>
                        <thead>
                            <th>No.</th>
                            <th>Full Name</th>
                            <th>Birthday</th>
                            <th>Gender</th>
                            <th>Citizen</th>
                            <th>Numberphone</th>
                            <th>Email</th>
                            <th>Type of Customer</th>
                            <th>Email</th>
                            <th>Function</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                                <td>.....</td>
                                <td>.....</td>
                                <td>.....</td>
                                <td>
                                    <button type="button">Detail</button>
                                    <button type="button">Edit</button>
                                    <button type="button">Delete</button>
                                </td>
                            </tr>

                        </tbody>
                    </tr>
                </table>
            </div>
        </main>
    )
}