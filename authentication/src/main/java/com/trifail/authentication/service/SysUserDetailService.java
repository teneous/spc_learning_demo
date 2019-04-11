package com.trifail.authentication.service;

import com.trifail.authentication.model.SysUser;
import com.trifail.authentication.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SysUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SysUser> optional = sysUserRepository.findByUsername(username);
        return optional.map(ele -> new User(ele.getUsername(),ele.getPassword(),
                    AuthorityUtils.createAuthorityList("ADMIN")))
                .orElseThrow(() -> new UsernameNotFoundException("Could not find " + username));
    }
}
