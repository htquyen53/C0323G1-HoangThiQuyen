import { Helmet } from 'react-helmet-async';
import { useNavigate } from 'react-router-dom';
// @mui
import { styled } from '@mui/material/styles';
import { Link, Container, Typography, Divider, Stack, Button } from '@mui/material';
// hooks
// import useResponsive from '../hooks/useResponsive';
// components
import Iconify from '../components/iconify';
// sections
import RegisterForm from '../sections/auth/register/RegisterForm';

// ----------------------------------------------------------------------

const StyledRoot = styled('div')(({ theme }) => ({
    [theme.breakpoints.up('md')]: {
        display: 'flex',
    },
}));


const StyledContent = styled('div')(({ theme }) => ({
    maxWidth: 480,
    margin: 'auto',
    minHeight: '100vh',
    display: 'flex',
    justifyContent: 'center',
    flexDirection: 'column',
    padding: theme.spacing(12, 0),
}));

// ----------------------------------------------------------------------

export default function Register() {
    const navigate = useNavigate();
    
    return (
        <>
            <Helmet>
                <title> Register | BugBugBuzz </title>
            </Helmet>

            <StyledRoot>

                <Container maxWidth="sm">
                    {/* <StyledContent> */}
                        <Typography variant="h3" gutterBottom sx={{ mb: 3 }}>
                            Sign Up to BugBugBuzz
                        </Typography>
                        <Typography variant="body2" sx={{ mb: 5 }}>
                            You have an account? {''}
                            <Link variant="subtitle2" href='/bugbugbuzz/login'>Get started</Link>
                        </Typography>
                        <Stack direction="row" spacing={2}>
                            <Button fullWidth size="large" color="inherit" variant="outlined">
                                <Iconify icon="eva:google-fill" color="#DF3E30" width={22} height={22} />
                            </Button>

                            <Button fullWidth size="large" color="inherit" variant="outlined">
                                <Iconify icon="eva:facebook-fill" color="#1877F2" width={22} height={22} />
                            </Button>

                            <Button fullWidth size="large" color="inherit" variant="outlined">
                                <Iconify icon="eva:twitter-fill" color="#1C9CEA" width={22} height={22} />
                            </Button>
                        </Stack>
                        <Divider sx={{ my: 3 }}>
                            <Typography variant="body2" sx={{ color: 'text.secondary' }}>
                                OR
                            </Typography>
                        </Divider>
                        <Stack direction='row' fullWidth>
                            <RegisterForm />
                        </Stack>
                    {/* </StyledContent> */}
                </Container>
            </StyledRoot>
        </>
    );
}
