import { put, takeLatest } from "redux-saga/effects";
import {
    GET_ALL_USERS, GET_ALL_USERS_SUCCESS,
    DELETE_USER, DELETE_USER_SUCCESS
} from "../redux/UserActions";
import * as userService from "../services/UserService";

function* getUsers(action) {
    try {
        const res = yield userService.getAll();
        yield put({type: GET_ALL_USERS_SUCCESS, payload: res})
    } catch (e) {
        console.log("error - getUsers : ", e);
    }
}

function* deleteUser(action) {
    try{
        yield userService.deleteUser(action.payload);
        yield put({type: GET_ALL_USERS})
    } catch (e) {
        console.log(e);
    }
}

export default function* rootSaga() {
    yield takeLatest(GET_ALL_USERS, getUsers);
    yield takeLatest(DELETE_USER, deleteUser);
}