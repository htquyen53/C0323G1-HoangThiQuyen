import { React } from "react";
function EditServices() {
    return (
        <main className="grid">
           <div className="main-edit-title">
                <h1>EDIT IMFOMATION OF SERVICES</h1>
                <h2>EDIT DETAILS OF VILLA</h2>
            </div>
            <img src="https://cf.bstatic.com/xdata/images/hotel/max1024x768/207702593.jpg?k=7ba4deb7b3cbed3f35cbe8200023530aa315070a606cfcf8fabff8fb35f34003&o=&hp=1"
                alt=""/>
            <form action="#">
                <table>
                    <tr>
                        <th>Name of Villa: </th>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <th>Usable Area</th>
                        <td><input type="number"/></td>
                    </tr>
                    <tr>
                        <th>Rental cost</th>
                        <td><input type="number"/></td>
                    </tr>
                    <tr>
                        <th>Maximum number of people</th>
                        <td><input type="number"/></td>
                    </tr>
                    <tr>
                        <th>Type of retal</th>
                        <td><select name="typeRental" id="typeRental">
                                <option value="1">Year</option>
                                <option value="2">Month</option>
                                <option value="3">Day</option>
                                <option value="4">Hour</option>
                            </select></td>
                    </tr>
                    <tr>
                        <th>Standard Type</th>
                        <td><select name="standard" id="standard">
                                <option value="1">Luxury Villa Type 1</option>
                                <option value="2">Luxury Villa Type 2</option>
                                <option value="3">Luxury Villa Type 3</option>
                            </select></td>
                    </tr>
                    <tr>
                        <th>Other services</th>
                        <td><input type="text"/></td>
                    </tr>
                    <tr>
                        <th>Area of Pool</th>
                        <td><input type="number"/></td>
                    </tr>
                    <tr>
                        <th>Number of floors</th>
                        <td><input type="number"/></td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <button class="form-btn" type="submit"><b>Edit</b></button>
                        </td>
                    </tr>
                </table>
            </form>
        </main>
    )
}
export default EditServices;