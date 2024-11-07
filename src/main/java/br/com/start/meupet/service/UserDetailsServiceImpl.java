package br.com.start.meupet.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.start.meupet.domain.entities.User;
import br.com.start.meupet.domain.interfaces.Authenticable;
import br.com.start.meupet.domain.repository.OngRepository;
import br.com.start.meupet.domain.repository.UserRepository;
import br.com.start.meupet.domain.valueobjects.Email;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OngRepository ongRepository;

	@Override
	public UserDetails loadUserByUsername(String email) {
		User user = new User();
		user.setEmail(new Email(email));
		Optional<Authenticable> usuario = Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
		if (usuario.isPresent()) {
			return UserDetailsImpl.build(usuario.get());
		}
		usuario = Optional.ofNullable(ongRepository.findByEmail(email));
		if (usuario.isPresent()) {
			return UserDetailsImpl.build(usuario.get());
		}
		throw new UsernameNotFoundException("Usuario nao encontrado");

	}

}
