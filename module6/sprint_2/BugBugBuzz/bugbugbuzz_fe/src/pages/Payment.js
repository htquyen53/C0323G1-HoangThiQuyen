import { Typography, Container, Box, Stack, Paper, Button, List, ListItem, ListItemButton, ListItemIcon, ListItemText, Avatar } from "@mui/material";
import { Helmet } from "react-helmet-async";

import { useNavigate, useParams } from "react-router-dom";
import { useState, useEffect } from "react";
import DoneOutlineRoundedIcon from '@mui/icons-material/DoneOutlineRounded';
import Swal from "sweetalert2";

import PaypalCheckoutButton from "../components/checkout/PaypalCheckoutButton";
import * as packageService from "../service/ProductService";

export default function Payment() {
    const params = useParams();
    const navigate = useNavigate();
    const [selectedPackage, setSelectedPackage] = useState();
    const accessToken = localStorage.getItem("JWT");
    const username = localStorage.getItem("username");
    console.log("user", username)
    const vipStatus = localStorage.getItem("VipStatus");
    console.log("vips", vipStatus)

    const loadPackageInfo = async (accessToken, id) => {
        try {
            const res = await packageService.getPackageById(accessToken, id);
            if (res == null) {
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Connect Error',
                    text: 'Package not found!',
                    showConfirmButton: false,
                    timer: 1500
                });
                navigate(-1);
            }
            setSelectedPackage(res);
        } catch (e) {
            if (e.response?.status === 406) {
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Connect Error',
                    text: 'Not Acceptable ',
                    showConfirmButton: false,
                    timer: 1500
                });
                navigate(-1);
            }
        }
    }

    useEffect(() => {
        loadPackageInfo(accessToken, params.id);
    }, [params.id])

    if (!selectedPackage) {
        return null;
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
                    {
                        vipStatus !== "" ?
                            (
                                <Stack>
                                    <Typography>You being {vipStatus}! </Typography>
                                    {/* <Typography>Do you want to cancel your current package to sign up for a new package? </Typography> */}
                                </Stack>
                            )
                            :
                            (
                                selectedPackage != null ?

                                    (<Box
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
                                            <Button variant="contained" sx={{ margin: 1, fontFamily: 'sans-serif' }}>Three month free width subcription</Button>
                                            <Button variant="outlined" sx={{ margin: 1 }} >Once time payment</Button>
                                            <Typography margin={1} variant="h5">{selectedPackage?.name}</Typography>
                                            <Typography margin={1} paragraph>{selectedPackage?.price}$/Six month after offer period  1 account</Typography>
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
                                            <Box sx={{ marginTop: 2 }} display="flex" justifyContent="center">
                                                <Avatar style={{ width: 150, height: 150 }} src={localStorage.getItem("avatar")} alt='photoURL' />
                                            </Box>
                                        </Paper>
                                        <Box sx={{ marginTop: 5 }} display="flex" justifyContent="center">
                                            <PaypalCheckoutButton product={selectedPackage} />
                                        </Box>
                                    </Box>
                                    )
                                    :
                                    (<Stack>
                                        <Typography>You have no selections in your cart! please return to the product page to select!</Typography>
                                    </Stack>
                                    )
                            )}

                </Stack>
            </Container>
        </>

    )
}