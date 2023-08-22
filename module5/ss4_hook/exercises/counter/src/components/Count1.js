import useIncrease from "../hooks/useIncrease";
function Count1() {
    const [count, increase] = useIncrease();
    return (
        <div>
            <p>Count: {count} </p>
            <button onClick={() => increase(1)}>Add1</button>
        </div>
    )
}
export default Count1;