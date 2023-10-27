import axios from "axios";

export const getAllPackages = async () => {
    const response = await axios.get("http://localhost:8080/api/packages/home/list");
    return response.data;
}

export const getPackageById = async (accessToken, id) => {
    const config = {
        headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${accessToken}`,
        },
        withCeredentials: true,
      };
    const response  = await axios.get(`http://localhost:8080/api/packages/${id}`, config);
    return response.data;
}
// Create a new payment
export const createPayment = async (accessToken, payment) => {
  const config = {
      headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${accessToken}`,
      },
      withCeredentials: true,
  };
  const response = await axios.post("http://localhost:8080/api/payment/createPayment", payment, config);
  return response;
}

// Get List Payment
export const getAllPayment = async (accessToken, username) => {
  const config = {
      headers: {
          "Content-Type": "application/json",
          Authorization: `Bearer ${accessToken}`,
      },
      withCeredentials: true,
  };
  const response = await axios.get(`http://localhost:8080/api/payment/list/${username}`, config);
  return response.data;
}