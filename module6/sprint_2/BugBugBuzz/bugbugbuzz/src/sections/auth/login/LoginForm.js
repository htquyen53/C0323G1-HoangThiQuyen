import React, { useState, useRef, useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
// @mui
import { Stack, IconButton, InputAdornment, TextField, Checkbox, FormControlLabel } from '@mui/material';
import { LoadingButton } from '@mui/lab';
// import { useDispatch } from "react-redux";
// Swal
import Swal from "sweetalert2";
// import { setCredentials } from "../authSlice";
// import { useLoginMutation } from "./authApiSlice";
// import jwt_decode from "jwt-decode";

// components
import Iconify from '../../../components/iconify';
import * as appUserService from "../../../service/AppUserService";
// import { sub } from "date-fns";

// ----------------------------------------------------------------------

export default function LoginForm() {

  // --------------- Cách 1: Sử dụng Redux -----------------------------------
  // const userRef = useRef();
  // const errRef = useRef();
  // const [username, setUsername] = useState('')
  // const [password, setPassword] = useState('')
  // const [errMsg, setErrMsg] = useState('')
  // const [checked, setChecked] = useState(false);
  // const navigate = useNavigate();
  // const [showPassword, setShowPassword] = useState(false);

  // const [login, { isLoading }] = useLoginMutation();
  // const dispatch = useDispatch();


  // useEffect(() => {
  //   userRef.current.focus();
  // }, []);

  // useEffect(() => {
  //   setErrMsg('')
  // }, [user, pwd])

  // const handleLogin = async (e) => {
  //   e.preventDefault();
  //   console.log(e)
  //   console.log(username+password)
  //   try {
  //     const userData = await login({ user, pwd }).unwrap();
  //     console.log(userData);
  //     dispatch(setCredentials({ ...userData, user }))
  //     setUsername('');
  //     setPassword('');
  //     Swal.fire({
  //       title: "Đăng nhập thành công",
  //       icon: "success",
  //       timer: 1500,
  //     }).then(() => {
  //       navigate('/bugbugbuzz/home', { replace: true });
  //     });
  //   } catch (err) {
  //     if (!err?.originalStatus) {
  //       console.log(err)
  //       setErrMsg('No server Response aaaa');
  //     } else if (err.originalStatus === 400) {
  //       setErrMsg('Missing Username or Password');
  //     } else if (err.originalStatus === 401) {
  //       setErrMsg('Unauthorized');
  //     } else {
  //       setErrMsg('Login Failed');
  //     }
  //     //  errRef.current.focus();
  //     console.log(errMsg);
  //   }
  // };


  // -------------------- Cách 2: Sử dụng storage------------------

  const [account, setAccount] = useState({
    username: "",
    password: ""
  })
  const userRef = useRef();
  const [checked, setChecked] = useState(false);
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);

  const checkStatusVip = async (accessToken, username) => {
    try {
        const res = await appUserService.checkVipStatus(accessToken, username);
         // Lưu Vipstatus xuống LocalStorage
         localStorage.setItem("VipStatus", res);
    } catch (e) {
        console.log(e);
    }
}



  const handleUsernameChange = (e) => {
    const { value } = e.target;
    setAccount((prevAccount) => ({ ...prevAccount, username: value }));
  }
  const handlePasswordChange = (e) => {
    const { value } = e.target;
    setAccount((prevAccount) => ({ ...prevAccount, password: value }));

  }



  const loginByUserName = async () => {
    try {
      const result = await appUserService.loginByUserName(account);
      console.log(result)
      if (result?.status === 200) {
        // Lưu JWT token xuống LocalStorage
        appUserService.addJwtTokenToLocalStorage(result.data.access_token);
        const infoUser = appUserService.infoAppUserByJwtToken();
        localStorage.setItem("username", infoUser.sub);
        const avatar = await appUserService.getAvatarByUsername(localStorage.getItem("JWT"), infoUser.sub)
        localStorage.setItem("avatar", avatar); 
        checkStatusVip(localStorage.getItem("JWT"), infoUser.sub);
        Swal.fire({
          title: "Đăng nhập thành công",
          icon: "success",
          timer: 2500,
        }).then(() => {
          navigate('/bugbugbuzz/home', { replace: true });
        });
      }
    } catch (e) {
      console.log(e)
      if (e?.response?.status === 409) {
        Swal.fire({
          title: 'Lỗi đăng nhập',
          text: 'Thông tin đăng nhập không chính xác!',
          icon: 'error',
          timer: 2000
        })
        setAccount({
          username: "",
          password: ""
        })
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Đăng nhập thất bại',
          timer: 2000
        })
        setAccount({
          username: "",
          password: ""
        })
      }
    }
  }
  return (
    <>
      <Stack spacing={3}>
        <TextField name="username"
          ref={userRef}
          id="userName"
          label="Username"
          value={account?.username}
          onChange={handleUsernameChange}
        />

        <TextField
          name="password"
          id="password"
          label="Password"
          value={account?.password}
          type={showPassword ? 'text' : 'password'}
          InputProps={{
            endAdornment: (
              <InputAdornment position="end">
                <IconButton onClick={handlePasswordChange} edge="end">
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

      <LoadingButton fullWidth size="large" type="submit" variant="contained" onClick={loginByUserName}>
        Login
      </LoadingButton>
    </>
  );
}
