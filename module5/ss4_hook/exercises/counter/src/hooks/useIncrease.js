import { useState } from 'react';
export default function useIncrease() {
    const [count, setCount] = useState(0);
    const increase = (addAmount) => {
        setCount((pre) => (pre + addAmount));
    }
    return [count, increase];
}