import { Component } from "react";
class ToDoList extends Component {
    constructor(props) {
        super();
        this.state = {
            list: [],
            item: ""
        }
    }
    handleChange(itemName) {
        this.setState({
            item: itemName
        })
    }

    addItem() {
        if (this.state.item.trim() !== "") {
            this.setState((pre) => ({
                list: [...pre.list, pre.item],
                item: ""
            }))
        }
    }

    render() {
        return (
            <main className="grid">
                <div className="content">
                    <h1 className="title"><b>My To-do-List</b></h1>
                    <div className="input-form">
                        <input value={this.state.item} onChange={(event) => this.handleChange(event.target.value)}></input>
                        <button onClick={() => this.addItem()}>Add</button>
                    </div>
                    <table>
                        <tr>
                            <th>My List</th>
                            <th>Status</th>
                        </tr>
                        {this.state.list.map((element, index) => (
                            <tr key={index}>
                                <td>{element}</td>
                                <td><input type="checkbox"></input></td>
                            </tr>
                        ))}
                    </table>
                </div>
            </main>
        )
    }
}

export default ToDoList;