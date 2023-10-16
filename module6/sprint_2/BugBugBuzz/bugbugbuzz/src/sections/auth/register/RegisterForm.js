import React from 'react';
import { Paper, Grid, Avatar, Typography, TextField } from '@mui/material';
import ContactMailOutlinedIcon from '@mui/icons-material/ContactMailOutlined';
import Button from 'src/theme/overrides/Button';
import Radio from '@mui/material/Radio';
import RadioGroup from '@mui/material/RadioGroup';
import FormControlLabel from '@mui/material/FormControlLabel';
import FormControl from '@mui/material/FormControl';
import FormLabel from '@mui/material/FormLabel';
import Checkbox from '@mui/material/Checkbox';

const RegisterForm = () => {
    const paperStyle = { padding: '30px 20px', width: 300, margin: "20px" }
    const headerStyle = { margin: 0 }
    const avatarStyle = { backgroundColor: '#1bbd7e' }
    return (
        <Grid elevation={20} style={paperStyle}>
            <Paper>
                <Grid align='center'>
                    <Avatar style={avatarStyle}>
                        <ContactMailOutlinedIcon />
                    </Avatar>
                    <h2 style={headerStyle}> Sign Up</h2>
                    <Typography variant='caption'>Please fill this form to create an account!</Typography>
                </Grid>
                <form component>
                    <TextField fullWidth label='Name' placeholder='Enter your name' />
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
                            <FormControlLabel
                                value="disabled"
                                disabled
                                control={<Radio />}
                                label="other"
                            />
                        </RadioGroup>
                    </FormControl>
                    <TextField fullWidth label='Username' />
                    <TextField fullWidth label='Birthday' />
                    <TextField fullWidth label='Password' />
                    <TextField fullWidth label='Confirm Password' />
                    <TextField fullWidth label='Email ' />
                    <TextField fullWidth label='Phone Number' />
                    <TextField fullWidth label='Address' />
                    <TextField fullWidth label='CitizenId' />
                    <TextField fullWidth label='Career' />
                    <TextField fullWidth label='AcademicLevel' />
                    <TextField fullWidth label='Biography' />
                    <FormControlLabel
                        control={<Checkbox defaultChecked name='checkedRegisterForm' />} label="I accept the terms and conditions."
                    />
                    <Button type='submit' variant='contained' color='primary'>Sign Up</Button>
                </form>
            </Paper>
        </Grid>
    )
}
export default RegisterForm;