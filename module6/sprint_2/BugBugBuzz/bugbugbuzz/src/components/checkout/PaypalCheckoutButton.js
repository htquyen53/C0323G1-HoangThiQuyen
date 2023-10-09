import { PayPalButtons } from "@paypal/react-paypal-js";
import { useState } from "react";

const PaypalCheckoutButton = (props) => {
    const { product } = props;
    const [paidFor, setPayFor] = useState(false);
    const [error, setError] = useState(null);
    const handleApprove = (orderID) => {
        // Call backend function to fulfill order

        // If response is success
        setPayFor(true);
        // Refresh user's account or subcription status

        // If responsive is error
        // alert("Your payment was processed successfullt. However, we are unable fulfill your purchase. Please contact us as... ")
    };
    if (paidFor) {
        // Display the success message, modal or redirect user to success page
        alert("Thank you for your purchase!")
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
                    setError("You already bought this package. Gp to your account to view your package!");
                    return actions.reject();
                }
                return actions.resolve();

            }}
            createOrder={(data, actions) => {
                return (
                    actions.order.create({
                        purchase_units: [
                            {
                                description: product.description,
                                amount: { value: product.price }
                            }
                        ]
                    })
                )
            }}
            onApprove={async (data, actions) => {
                const order = await actions.order.capture();
                console.log("order", order);

                handleApprove(data.orderID);
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