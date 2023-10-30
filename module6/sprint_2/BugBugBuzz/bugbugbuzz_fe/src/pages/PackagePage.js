import { Box, Button, Grid, List, ListItem, ListItemButton, ListItemIcon, ListItemText, Stack, Typography } from "@mui/material";
import Paper from '@mui/material/Paper';
import { createTheme, ThemeProvider } from '@mui/material/styles';
import { teal, blueGrey, orange, grey } from '@mui/material/colors';
import DoneOutlineRoundedIcon from '@mui/icons-material/DoneOutlineRounded';
import { useNavigate } from "react-router-dom";
import { useState,useEffect } from "react";
import * as productService from "../service/ProductService"


const theme = createTheme({
    typography: {
        fontFamily: 'Public Sans, sans-serif, Arial',
    },
    palette: {
        primary: { main: teal[500] },
        secondary: { main: orange[300] },
        grey: { main: blueGrey[100] },
        dark: { main: grey[900] }
    },
});

export default function PackagePage() {
    const [packages, setPackages] = useState();
    const navigate = useNavigate();
    const getAllPackages = async () => {
        try {
            const response = await productService.getAllPackages();
            setPackages(response);
            console.log(response)
        } catch (e) {
            console.log(e)
        }

    }
    console.log(localStorage.getItem("JWT"))
    const handleBuyVip = (id) => {
        if (localStorage.getItem("JWT")) {
            navigate(`/bugbugbuzz/payment/${id}`)
        } else {
            navigate("/bugbugbuzz/login")
        }
    }
    useEffect(() => {
        getAllPackages();
    }, [])
    return (
        <ThemeProvider theme={theme}>

            <Box >
                <Stack padding={10} alignItems="center" sx={{ backgroundColor: "#008C5E", color: "white", height: 500 }}>
                    <Typography variant="h2" margin={1}>Get Premium free for 1 month</Typography>
                    <Typography variant="h5" margin={1}>Just 3$/month after. Cancel anytime.</Typography>
                    <Stack direction="row" spacing={2} margin={5}>
                        <Button variant="contained" color="dark"
                            sx={{ color: 'white', borderRadius: 5 }}
                        >Get Start</Button>
                        <Button variant="outlined" sx={{ color: 'white', borderRadius: 5 }} color="grey">View plan</Button>
                    </Stack>
                    <Typography paragraph margin={3}>Terms and conditions apply. 1 month free not available for users who have already tried Premium.
                    </Typography>
                </Stack>

                {/* ------------------------------------------------------ Product ------------------------------------------------- */}

                <Stack alignItems="center" spacing={2} margin={5} sx={{ backgroundColor: "AppWorkspace" }}>
                    <Typography variant="h3" margin={3} >Pick your Premium</Typography>
                    <Stack direction="row" spacing={3}>
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
                            {packages?.map((product, index) => (
                                <Paper elevation={3} sx={{ padding: "10px" }} key={index}>
                                    <Button variant="contained" sx={{ margin: 1, fontFamily: 'sans-serif' }} color="secondary">Three month free width subcription</Button>
                                    <Button variant="outlined" sx={{ margin: 1 }} color="secondary">Once time payment</Button>
                                    <Typography margin={1} variant="h5">{product.name}</Typography>
                                    <Typography margin={1} paragraph>{product.price} $/month after offer period  1 account</Typography>
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
                                    <Button
                                        variant="contained"
                                        color="dark" fullWidth
                                        sx={{ color: 'white' }}
                                        onClick={() => handleBuyVip(product?.id)}
                                    >
                                        Get started!
                                    </Button>
                                    <Typography margin={2} textAlign="start" paragraph sx={{ fontSize: 12 }}>Terms and conditions apply. Plan available for higher education students who haven't already tried Premium. After the trial period a monthly fee of 29,500₫/month will be charged. Offer ends on 21/10/2023
                                    </Typography>
                                </Paper>
                            ))}
                            {/* <Paper elevation={3} sx={{ padding: "10px" }}>
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
                                <Button
                                    variant="contained"
                                    color="dark" fullWidth
                                    sx={{ color: 'white' }}
                                    onClick={() => handleBuyVip(3)}
                                >
                                    Get started!
                                </Button>
                                <Typography margin={2} textAlign="start" paragraph sx={{ fontSize: 12 }}>Terms and conditions apply. Plan available for higher education students who haven't already tried Premium. After the trial period a monthly fee of 29,500₫/month will be charged. Offer ends on 21/10/2023
                                </Typography>
                            </Paper>
                            <Paper elevation={3} sx={{ padding: "10px" }}>
                                <Button variant="contained" sx={{ margin: 1, fontFamily: 'sans-serif' }} color="secondary">Three month free width subcription</Button>
                                <Button variant="outlined" sx={{ margin: 1 }} color="secondary">Once time payment</Button>
                                <Typography margin={1} variant="h5">VIP2</Typography>
                                <Typography margin={1} paragraph>5$/month after offer period  1 account</Typography>
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
                                <Button
                                    variant="contained"
                                    color="dark"
                                    fullWidth
                                    sx={{ color: 'white' }}
                                    onClick={() => handleBuyVip(5)}
                                >Get started!</Button>
                                <Typography margin={2} textAlign="start" paragraph sx={{ fontSize: 12 }}>Terms and conditions apply. Plan available for higher education students who haven't already tried Premium. After the trial period a monthly fee of 29,500₫/month will be charged. Offer ends on 21/10/2023
                                </Typography>
                            </Paper>
                            <Paper elevation={3} sx={{ padding: "10px" }}>
                                <Button variant="contained" sx={{ margin: 1, fontFamily: 'sans-serif' }} color="secondary">Three month free width subcription</Button>
                                <Button variant="outlined" sx={{ margin: 1 }} color="secondary">Once time payment</Button>
                                <Typography margin={1} variant="h5">VIP3</Typography>
                                <Typography margin={1} paragraph>7$/month after offer period  1 account</Typography>
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
                                <Button
                                    variant="contained"
                                    color="dark" fullWidth
                                    sx={{ color: 'white' }}
                                    onClick={() => handleBuyVip(7)}
                                >Get started!</Button>
                                <Typography margin={2} textAlign="start" paragraph sx={{ fontSize: 12 }}>Terms and conditions apply. Plan available for higher education students who haven't already tried Premium. After the trial period a monthly fee of 29,500₫/month will be charged. Offer ends on 21/10/2023
                                </Typography>
                            </Paper> */}
                        </Box>
                    </Stack>
                </Stack>
                <Stack direction="row" spacing={2} padding={3} alignItems="center" sx={{ backgroundColor: "#000000", color: "white", height: 400 }}>
                    <Grid container spacing={3}>
                        <Grid item xs={4} >
                            <Stack alignItems="center" margin={10}>
                                <Typography variant="h6">About us</Typography>
                                <Typography paragraph sx={{ margin: "2px", fontSize: 15, textAlign: "center" }}>Welcome to our my oasis for all dev in the world. Here, all your bugs will resolve by top dev master!</Typography>

                            </Stack>
                        </Grid>
                        <Grid item xs={4}>
                            <Stack alignItems="center" margin={10}>
                                <Typography variant="h6">About us</Typography>
                                <Typography paragraph sx={{ margin: "2px", fontSize: 15, textAlign: "center" }}>Welcome to our my oasis for all dev in the world. Here, all your bugs will resolve by top dev master!</Typography>
                            </Stack>
                        </Grid>
                        <Grid item xs={4}>
                            <Stack alignItems="center" margin={10}>
                                <Typography variant="h6">About us</Typography>
                                <Typography paragraph sx={{ margin: "2px", fontSize: 15, textAlign: "center" }}>Welcome to our my oasis for all dev in the world. Here, all your bugs will resolve by top dev master!</Typography>

                            </Stack>
                        </Grid>
                    </Grid>
                </Stack>
            </Box>
        </ThemeProvider>

    )
}