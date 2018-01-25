package com.itch.user.service;

import com.itch.user.bean.User;

public interface UserService {

	User findByName(User user);

	void save(User user);

	User select(User user);

}
