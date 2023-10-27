import { PayPalButtons } from "@paypal/react-paypal-js";
import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createPayment } from "../../service/ProductService";

const PaypalCheckoutButton = (props) => {
    const navigate = useNavigate();
    const { product } = props;
    const [paidFor, setPayFor] = useState(false);
    const [error, setError] = useState(null);
    const [payload, setPayload] = useState({
        username: localStorage.getItem("username"),
        packageId: product.id,
        orderId: ""
    });
    const accessToken = localStorage.getItem("JWT");
    const handleApprove = async (payload) => {
        try {
            const res = await createPayment(accessToken, payload);
        } catch (e) {
            console.log(e);
        }

        // Call backend function to fulfill order

        // If response is success
        setPayFor(true);
        localStorage.setItem("VipStatus",product.name);
        navigate("/bugbugbuzz/home")
        // Refresh user's account or subcription status

        // If responsive is error
        // alert("Your payment was processed successfull. However, we are unable fulfill your purchase. Please contact us as... ")
    };
    if (paidFor) {
        // Display the success message, modal or redirect user to success page
        alert("Thank you for your purchase!");
    }
    if (error) {
        // Display error message, modal or redirect user to error page
        alert(error);
    }
    return (
        <PayPalButtons
            onClick={(data, actions) => {
                // Validate on button click, client or server side
                const hasAlreadyBought = false;
                if (hasAlreadyBought) {
                    setError("You already bought this package. Go to your account to view your package!");
                    return actions.reject();
                }
                return actions.resolve();

            }}
            createOrder={(data, actions) =>
            (
                actions.order.create({
                    purchase_units: [
                        {
                            description: product.name,
                            amount: { value: product.price }
                        }
                    ]
                })
            )
            }
            onApprove={async (data, actions) => {
                const order = await actions.order.capture();
                console.log(order.id)
                setPayload({ ...payload, orderId: order.id })
                handleApprove({ ...payload, orderId: order.id });
            }}
            onCancel={() => {
                // Display cancel message, modal or redirect user to cancel page
            }}
            onError={(err) => {
                setError(err);
                console.error("Paypal checout onError", err)
            }}
        />
    )
}
export default PaypalCheckoutButton;