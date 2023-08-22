import useIncrease from "../hooks/useIncrease";
function Count2() {
    const [count, increase] = useIncrease();
    return (
        <div>
            <p>Count: {count} </p>
            <button onClick={() => increase(2)}>Add2</button>
        </div>
    )
}
export default Count2;