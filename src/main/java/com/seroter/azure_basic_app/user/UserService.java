package com.seroter.azure_basic_app.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	private final UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		Optional<User> userOptional = userRepository.findById(id);
		if (userOptional.isPresent()) {
			return userOptional;
		} else {
			throw new IllegalStateException("no user");
		}
	}

	public Optional<User> login(User user) {
		Optional<User> userOptional = userRepository.login(user.getEmail(), user.getPassword());

		if (userOptional.isPresent()) {
			return userOptional;
		} else {
			Optional<User> emailOptional = userRepository.findUserByEmail(user.getEmail());

			if (emailOptional.isPresent()) {
				throw new IllegalStateException("帳號或密碼錯誤");
			} else if (!emailOptional.isPresent()) {
				throw new IllegalStateException("帳號不存在");
			} else {
				throw new IllegalStateException("伺服器錯誤");
			}

		}

	}

	public Optional<User> register(User user) {
		Optional<User> emailOptional = userRepository.findUserByEmail(user.getEmail());
		if (emailOptional.isPresent()) {
			throw new IllegalStateException("電子郵件已被使用");
		} else {
			userRepository.save(user);
			Optional<User> newUserOptional = userRepository.findById(user.getId());
			return newUserOptional;
		}

	}
}
