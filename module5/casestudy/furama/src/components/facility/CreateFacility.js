import { useState } from "react";
import CreateVilla from "./villa/CreateVilla";
import CreateHouse from "./house/CreateHouse";
import CreateRoom from "./room/CreateRoom";
import "../../css/crudstyle.css";

function CreateFacility() {
    const [facilityTypes] = useState([
        {
            id: 1,
            value: "Villa",
            field: <CreateVilla />
        },
        {
            id: 2,
            value: "House",
            field: <CreateHouse />
        },
        {
            id: 3,
            value: "Room",
            field: <CreateRoom />
        }])
    const [option, setOption] = useState({
        show: false,
        value: null
    });

    return (
        <>
            <h2> CREATE FACILITY</h2>
            <h3>Woule you like to create the following facility?</h3>
            <div className="site-create">
                {facilityTypes.map((type) => (
                    <button type="button" className="btn btn-outline-dark" onClick={() => {
                        setOption({
                            show: true,
                            value: type.field
                        })
                    }}>{type.value}</button>
                ))} 
            </div>
            {console.log(option.value)}
            {option.show && (option?.value)}
        </>
    )
}
export default CreateFacility;