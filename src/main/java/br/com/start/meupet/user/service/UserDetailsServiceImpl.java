package br.com.start.meupet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.start.meupet.domain.entities.User;
import br.com.start.meupet.domain.interfaces.Authenticable;
import br.com.start.meupet.domain.repository.UserRepository;
import br.com.start.meupet.domain.valueobjects.Email;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {
        User userEntity = new User();
        userEntity.setEmail(new Email(email));
        Optional<Authenticable> user = Optional.ofNullable(userRepository.findByEmail(userEntity.getEmail()));
        if (user.isPresent()) {
            return UserDetailsImpl.build(user.get());
        }
        throw new UsernameNotFoundException("Usuario nao encontrado");
    }

}