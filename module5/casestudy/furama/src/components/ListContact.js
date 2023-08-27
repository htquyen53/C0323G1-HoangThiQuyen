import { React } from 'react';
function ListContact() {
    return (
        <main className="grid">
            <img src="https://www.365travel.asia/images/tour/items/img2/furama-resort-danang-banner.jpg"
                alt="furama  resort" />
            <h1>Contracts List</h1>
            <div className="list">
                <table>
                    <tr>
                        <thead>
                            <th>No.</th>
                            <th>Start-Day</th>
                            <th>End-Day</th>
                            <th>Deposit</th>
                            <th>Total Payment</th>

                        </thead>
                        <tbody>
                            <tr>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                                <td>....</td>
                            </tr>
                        </tbody>
                    </tr>
                </table>
            </div>
        </main>
    )
}
export default ListContact;