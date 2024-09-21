//package org.example.springboot.model.minitest;
//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//
//public class UserPrinciple implements UserDetails {
//    private static final long serialVersionUID = 1L;
//    private long id;
//    private String username;
//    private String password;
//
//    private Collection<? extends GrantedAuthority> role;
//
//    public UserPrinciple(long id, String username, String password, Collection<? extends GrantedAuthority> role) {
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.role = role;
//    }
//
//    public static UserPrinciple build(AppUser user) {
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        for (AppRole role : user.getRoles()) {
//authorities.add(new SimpleGrantedAuthority(role.getName()));
//        }
//        return new UserPrinciple(user.getId(), user.getEmail(), user.getPassword(), authorities);
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return role;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//}
