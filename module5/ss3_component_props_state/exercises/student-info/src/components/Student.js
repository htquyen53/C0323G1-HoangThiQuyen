import {Component} from "react";
class Student extends Component {
    constructor() {
        super();
        this.state = {
            studentList: [
                {   id: 1,
                    name: "Hoàng Thị Quyên",
                    age: 18,
                    adress: "Đà Nẵng"
                },
                {   id: 2,
                    name: "Bùi Bích Anh",
                    age: 18,
                    adress: "Đà Nẵng"

                }
            ]
        }
    }
    render() {
        return (
            <>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Adress</th>
                    </tr>
                    {this.state.studentList.map((element, index) => (
                        <tr key={index}>
                            <td>{element.id}</td>
                            <td>{element.name}</td>
                            <td>{element.age}</td>
                            <td>{element.adress}</td>
                        </tr>
                    ))}
                </table>
            </>
        )
    }
}
export default Student;