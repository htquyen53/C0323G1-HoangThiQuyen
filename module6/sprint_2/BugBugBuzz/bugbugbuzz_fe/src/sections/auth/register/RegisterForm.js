import React from 'react';
import { Paper, Grid, Typography, TextField, Stack } from '@mui/material';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Checkbox from '@mui/material/Checkbox';
import { LoadingButton } from '@mui/lab';


const RegisterForm = () => {
    
    return (
        <Grid elevation={20} >
            <Paper>
                <Grid align='center'>
                    <Typography variant='caption'>Please fill this form to create an account!</Typography>

                </Grid>
                <form>
                    <Stack direction={'row'} spacing={3} margin={3}>
                        <TextField fullWidth label='Name' placeholder='Enter your name' />
                        <TextField fullWidth label='Birthday' />
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>

                        <FormControl component='fieldset'>
                            <FormLabel id="demo-row-radio-buttons-group-label">Gender</FormLabel>
                            <RadioGroup
                                row
                                aria-labelledby="demo-row-radio-buttons-group-label"
                                name="row-radio-buttons-group"
                            >
                                <FormControlLabel value="female" control={<Radio />} label="Female" />
                                <FormControlLabel value="male" control={<Radio />} label="Male" />
                                <FormControlLabel value="other" control={<Radio />} label="Other" />
                            </RadioGroup>
                        </FormControl>
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>
                        <TextField fullWidth label='Username' />
                        <TextField fullWidth label='Password' />
                        <TextField fullWidth label='Confirm Password' />

                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>

                        <TextField fullWidth label='Email ' />
                        <TextField fullWidth label='Phone Number' />
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>
                        <TextField fullWidth label='Address' />
                        <TextField fullWidth label='CitizenId' />
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>
                        <TextField fullWidth label='Career' />
                        <TextField fullWidth label='AcademicLevel' />
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>
                        <TextField fullWidth label='Biography' />
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>
                        <FormControlLabel
                            control={<Checkbox defaultChecked name='checkedRegisterForm' />} label="I accept the terms and conditions."
                        />
                    </Stack>
                    <Stack direction={'row'} spacing={3} margin={3}>
                    <LoadingButton fullWidth size="large" type="submit" variant="contained" >
                        Sign up
                    </LoadingButton>
                    </Stack>
                </form>
            </Paper>
        </Grid>
    )
}
export default RegisterForm;    