import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
// @mui
import { Link, Stack, IconButton, InputAdornment, TextField, Checkbox, FormControlLabel } from '@mui/material';
import { LoadingButton } from '@mui/lab';
// components
import Iconify from '../../../components/iconify';
// import * as appUserService from '../../../service/AppUserService';
// Swal
// import Swal from 'sweetaler'
// ----------------------------------------------------------------------

export default function LoginForm() {
  const [account, setAccount] = useState({
    username: "",
    password: ""
  })
  const [checked, setChecked] = useState(false);
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);

  const handleLogin = () => {
    navigate('/dashboard', { replace: true });
  };

  const handleUsernameChange = (e) => {
    const { value } = e.target;
    setAccount((prevAccount) => ({ ...prevAccount, username: value }));
  }
  const handlePasswordChange = (e) => {
    const { value } = e.target;
    setAccount((prevAccount) => ({ ...prevAccount, password: value }));

  }

  return (
    <>
      <Stack spacing={3}>
        <TextField name="email" label="Email address" onChange={handleUsernameChange} />

        <TextField
          name="password"
          label="Password"
          type={showPassword ? 'text' : 'password'}
          InputProps={{
            endAdornment: (
              <InputAdornment position="end">
                <IconButton onClick={() => setShowPassword(!showPassword)} edge="end">
                  <Iconify icon={showPassword ? 'eva:eye-fill' : 'eva:eye-off-fill'} />
                </IconButton>
              </InputAdornment>
            ),
          }}
          onChange={handlePasswordChange}
        />
      </Stack>

      <Stack direction="row" alignItems="center" justifyContent="space-between" sx={{ my: 2 }}>
        <FormControlLabel
          control={
            <Checkbox
              checked={checked}
              onChange={(event) => setChecked(event.target.checked)}
              name="checked"
              color="primary"
              size="small"
            />
          }
          label={'Remember me'}
        />
        <Link variant="subtitle2" underline="hover">
          Forgot password?
        </Link>
      </Stack>

      <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={handleLogin}>
        Login
      </LoadingButton>
    </>
  );
}
