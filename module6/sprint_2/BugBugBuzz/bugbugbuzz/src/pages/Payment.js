import { Typography, Container, Box, Stack } from "@mui/material";
import { useState } from "react";
import { Helmet } from "react-helmet-async";
import PaypalCheckoutButton from "../components/checkout/PaypalCheckoutButton";

export default function Payment() {
    const product = {
        description: "Basic Package",
        price: 6
    }

    return (
        <>
            <Helmet>
                <title>Payment | BugBugBuzz</title>
            </Helmet>
            <Container>
                <Stack direction="row" alignItems="center">
                    <Typography variant="h2">
                        Checkout Here!
                    </Typography>
                </Stack>
                <Stack>
                    <Typography variant="h4">Basic Package</Typography>
                    <Typography variant="h6">Update your level to up your power in BugBugBuzz!!</Typography>
                    <Typography variant="h6" >Price: 6</Typography>
                </Stack>
                <Box sx={{marginTop: 5}} display="flex" justifyContent="center">
                    <PaypalCheckoutButton product={product} />
                </Box>
            </Container>
        </>

    )
}