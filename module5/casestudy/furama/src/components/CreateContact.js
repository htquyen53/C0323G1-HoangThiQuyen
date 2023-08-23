import {React} from 'react';
export function CreateContact() {
    return(
        <main class="grid">
            <div class="main-title">
                <img src="https://www.365travel.asia/images/tour/items/img2/furama-resort-danang-banner.jpg"
                    alt="furama  resort"/>
                <h1>CREATE NEW CONTRACT</h1>
            </div>
            <form action="#">
                <table>
                    <tr>
                        <th>No. : </th>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <th>Start-Day: </th>
                        <td><input type="date"/></td>
                    </tr>
                    <tr>
                        <th>End-Day: </th>
                        <td><input type="date"/></td>
                    </tr>
                    <tr>
                        <th>Deposit</th>
                        <td><input type="number"/></td>
                    </tr>
                    <tr>
                        <th>Total Payment</th>
                        <td><input type="number"/></td>
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