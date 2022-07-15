package com.database.sevices;

import com.database.model.Employee;
import com.database.model.JwtRequest;
import com.database.model.JwtResponse;
import com.database.repo.EmployeeRepo;
import com.database.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class JwtService implements UserDetailsService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception{
        String userName = jwtRequest.getUserName();
        String userPassword = jwtRequest.getUserPassword();
        authenticate(userName,userPassword);
        final UserDetails userDetails = loadUserByUsername(userName);
        String newGeneratedToken = jwtUtil.generateToken(userDetails);
        Employee employee = employeeRepo.findById(userName).get();
        return new JwtResponse(employee,newGeneratedToken);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Employee employee = employeeRepo.findById(username).get();
        if(employee != null){
            return new org.springframework.security.core.userdetails.User(
                    employee.getUserName(),
                    employee.getUserPassword(),
                    getAuthorities(employee)
            );
        }else{
            throw new UsernameNotFoundException("Username is not valid");
        }
    }

    private Set getAuthorities(Employee employee) {
        Set authorities = new HashSet();

        authorities.add(new SimpleGrantedAuthority("ROLE_"+employee.getRole()));

        return authorities;
    }

    private void authenticate(String userName,String userPassword) throws Exception{
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,userPassword));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad credentials from user");
        }

    }
}

