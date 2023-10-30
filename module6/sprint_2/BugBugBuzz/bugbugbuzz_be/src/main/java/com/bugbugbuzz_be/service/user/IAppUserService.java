package com.bugbugbuzz_be.service.user;

import com.bugbugbuzz_be.auth.RegisterRequest;
import com.bugbugbuzz_be.dto.UserDto;
import com.bugbugbuzz_be.model.app.AppUser;

public interface IAppUserService {
    AppUser registerUser(UserDto userDto);
    AppUser getAppUserByUsername (String username);
    String checkVipStatusByUsername(String username);

}
