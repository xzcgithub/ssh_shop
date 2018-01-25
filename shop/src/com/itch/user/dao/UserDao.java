package com.itch.user.dao;

import com.itch.user.bean.User;
import com.itch.util.BaseDao;

public interface UserDao extends BaseDao<User>{

	User findByName(User user);

	User select(User user);

	

}
