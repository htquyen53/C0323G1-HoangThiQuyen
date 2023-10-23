import axios from "axios";
import jwtDecode from "jwt-decode";

export const loginByUserName = async (appUser) => {
  const result = await axios.post(
    `http://localhost:8080/api/v1/auth/login-by-username`,
    appUser
  );
  console.log(result);

  return result;
};

export const registerAppUser = async (appUser) => {
  const result = await axios.post(
    `http://localhost:8080/api/v1/auth/register`,
    appUser
  );
  return result;
};

export const loginWithFacebook = async (facebookMail) => {
  const result = await axios.post(
    `http://localhost:8080/api/v1/auth/login-by-facebook`,
    facebookMail
  );
  return result;
};

export const addJwtTokenToLocalStorage = (jwtToken) => {
  localStorage.setItem("JWT", jwtToken);
};

export const infoAppUserByJwtToken = () => {
  const jwtToken = localStorage.getItem("JWT");
  if (jwtToken) {
    const result = jwtDecode(jwtToken);
    return result;
  }
  return undefined;
};

export const getIdByUserName = async (userName) => {
  const id = await axios.get(
    `http://localhost:8080/api/user/get-id-app-user/${userName}`
  );
  return id;
};

export const getAvatarByUsername = async (accessToken, userName) => {
  const config = {
    headers: {
      "Content-Type": "application/json",
      Authorization: `Bearer ${accessToken}`,
    },
    withCeredentials: true,
  };
  const response = await axios.get(`http://localhost:8080/api/user/get-avatar?username=${userName}`, config);
  return response.data;
}

export const checkRoleAppUser = (roleName) => {
  const jwtToken = localStorage.getItem("JWT");
  if (jwtToken) {
    const roleList = jwtDecode(jwtToken).roleList;
    const checkRole = roleList.some((role) => role.authority === roleName);
    return checkRole;
  }
  return undefined;

};
