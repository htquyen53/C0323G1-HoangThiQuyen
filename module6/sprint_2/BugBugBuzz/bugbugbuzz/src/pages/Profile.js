import * as React from 'react';
import { useState, useEffect } from 'react';
import { Link as RouterLink } from 'react-router-dom';
import { styled } from '@mui/material/styles';
import Box from '@mui/material/Box';
import Paper from '@mui/material/Paper';
import Grid from '@mui/material/Grid';
import { Stack, Typography, Avatar, Button } from '@mui/material';
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import * as paymentService from '../service/ProductService';

const Item = styled(Paper)(({ theme }) => ({
    backgroundColor: theme.palette.mode === 'dark' ? '#1A2027' : '#fff',
    ...theme.typography.body2,
    padding: theme.spacing(1),
    textAlign: 'center',
    color: theme.palette.text.secondary,
}));

export default function Profile() {
    const [payments, setPayments] = useState();
    const accessToken = localStorage.getItem("JWT");
    const username = localStorage.getItem("username");
    const getAllPayment = async (accessToken, username) => {
        try {
            const res = await paymentService.getAllPayment(accessToken, username);
            setPayments(res);
        } catch (e) {
            console.log(e)
        }
    }
    useEffect(() => {
        getAllPayment(accessToken, username);
    }, [])

    return (
        <Box sx={{ flexGrow: 1, margin: 7 }}>
            <Grid container spacing={3}>
                <Grid item xs={8}>
                    <Item>
                        <Stack>
                            <Typography variant='h3' sx={{ margin: 1 }}>Payment History</Typography>
                            {!payments ? (<Stack>
                                <Typography> You don't have payment yet!</Typography>
                            </Stack>) : (
                                <TableContainer component={Paper}>
                                    <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
                                        <TableHead>
                                            <TableRow>
                                                <TableCell>No.</TableCell>
                                                <TableCell align="right">Payment Date</TableCell>
                                                <TableCell align="right">Order code</TableCell>
                                                <TableCell align="right">Status</TableCell>
                                                <TableCell align="right">Package Name</TableCell>
                                            </TableRow>
                                        </TableHead>
                                        <TableBody>
                                            {payments?.map((row, index) => (
                                                <TableRow
                                                    key={row?.id}
                                                    sx={{ '&:last-child td, &:last-child th': { border: 0 } }}
                                                >
                                                    <TableCell component="th" scope="row">
                                                        {index + 1}
                                                    </TableCell>
                                                    <TableCell align="right">{row?.paymentDate}</TableCell>
                                                    <TableCell align="right">{row?.orderId}</TableCell>
                                                    <TableCell align="right">{row?.status ? ('ON') : ('OFF')}</TableCell>
                                                    <TableCell align="right">{row?.aPackage.name}</TableCell>
                                                </TableRow>
                                            ))}
                                        </TableBody>
                                    </Table>
                                </TableContainer>)}
                        </Stack>
                    </Item>
                </Grid>
                <Grid item xs>
                    <Item>
                        <Stack margin={5}>
                            <Typography variant='h3' sx={{ margin: 3 }}>Account Information</Typography>
                            <Box sx={{ marginTop: 5 }} display="flex" justifyContent="center">
                                <Avatar style={{ width: 150, height: 150 }} src={localStorage.getItem("avatar")} alt='photoURL' />
                            </Box>
                            <Typography variant='h5' sx={{ margin: 3 }}>{localStorage.getItem("username")}</Typography>
                            <Typography variant='h5' sx={{ margin: 3, color: "orange", backgroundColor: "#6EC3C9", borderRadius: 6, padding: 2 }}>{localStorage.getItem("VipStatus") !== "" ? (localStorage.getItem("VipStatus")) : ('Standard')}</Typography>
                        </Stack>
                    </Item>
                </Grid>
            </Grid>
        </Box>
    )
}