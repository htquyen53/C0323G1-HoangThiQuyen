import { apiSlice } from "../../../api/apiSlice";

export const authApiSlice = apiSlice.injectEndpoints({
    endpoints: builder => ({
        login: builder.mutation({
            query: credential => ({
                url: "/api/v1/auth/login-by-username",
                method: "POST",
                body: { ...credential }
            })
        }),
    })
})
export const {
    useLoginMutation
} = authApiSlice