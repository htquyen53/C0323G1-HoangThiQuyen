import { GET_ALL_USERS_SUCCESS, DELETE_USER_SUCCESS } from "./UserActions";

const initialState = {
    users: [],
}

const rootReducer = (state = initialState, action) => {
    switch (action.type) {
        case GET_ALL_USERS_SUCCESS:
            return { ...state, users: action.payload };
        case DELETE_USER_SUCCESS:
            return state.filter(user => user.id !== action.payload);
        default:
            return state;
    }
};  
export default rootReducer;