import { Typography, Container, Box, Stack, Paper, Button, List, ListItem, ListItemButton, ListItemIcon, ListItemText } from "@mui/material";
import { Helmet } from "react-helmet-async";
import DoneOutlineRoundedIcon from '@mui/icons-material/DoneOutlineRounded';
import PaypalCheckoutButton from "../components/checkout/PaypalCheckoutButton";

export default function Payment() {
    const product = {
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
                    <Box
                        sx={{
                            display: 'flex',
                            flexWrap: 'wrap',
                            '& > :not(style)': {
                                m: 3,
                                width: 350,
                                height: 500
                            },
                        }}
                    >
                        <Paper elevation={3} sx={{ padding: "10px" }}>
                            <Button variant="contained" sx={{ margin: 1, fontFamily: 'sans-serif' }} color="secondary">Three month free width subcription</Button>
                            <Button variant="outlined" sx={{ margin: 1 }} color="secondary">Once time payment</Button>
                            <Typography margin={1} variant="h5">VIP1</Typography>
                            <Typography margin={1} paragraph>3$/month after offer period  1 account</Typography>
                            <hr />
                            <List>
                                <ListItem disablePadding>
                                    <ListItemButton>
                                        <ListItemIcon>
                                            <DoneOutlineRoundedIcon />
                                        </ListItemIcon>
                                        <ListItemText primary="Ad-free post your problem" />
                                    </ListItemButton>
                                </ListItem>
                                <ListItem disablePadding>
                                    <ListItemButton>
                                        <ListItemIcon>
                                            <DoneOutlineRoundedIcon />
                                        </ListItemIcon>
                                        <ListItemText primary="Play anywhere - even offline" />
                                    </ListItemButton>
                                </ListItem>
                            </List>
                            <Typography margin={2} textAlign="start" paragraph sx={{ fontSize: 12 }}>Terms and conditions apply. Plan available for higher education students who haven't already tried Premium. After the trial period a monthly fee of 29,500₫/month will be charged. Offer ends on 21/10/2023
                            </Typography>
                        </Paper>
                        <Box sx={{ marginTop: 5 }} display="flex" justifyContent="center">
                            <PaypalCheckoutButton product={product} />
                        </Box>
                    </Box>

                </Stack>
            </Container>
        </>

    )
}