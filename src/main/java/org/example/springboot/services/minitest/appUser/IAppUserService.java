package org.example.springboot.services.minitest.appUser;

import org.example.springboot.model.minitest.AppUser;
import org.example.springboot.services.minitest.IGenerateService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAppUserService extends IGenerateService<AppUser>, UserDetailsService {
}
