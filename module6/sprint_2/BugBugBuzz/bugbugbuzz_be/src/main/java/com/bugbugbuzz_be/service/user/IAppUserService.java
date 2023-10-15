package com.bugbugbuzz_be.service.user;

import com.bugbugbuzz_be.auth.RegisterRequest;
import com.bugbugbuzz_be.dto.UserDto;
import com.bugbugbuzz_be.model.app.AppUser;

public interface IAppUserService {
    public AppUser registerUser(UserDto userDto);
}
