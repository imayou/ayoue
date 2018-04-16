package io.ayoue.sso.resources.action;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.ayoue.common.model.User;
import io.ayoue.common.model.repository.UserRepository;

@RestController
public class UserAction {
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/user")
	public Map<String, Object> user(Principal puser) {
		User user = userRepository.findByName(puser.getName());
		Map<String, Object> userinfo = new HashMap<>();
		userinfo.put("id", user.getId());
		userinfo.put("name", user.getName());
		userinfo.put("email", user.getEmail());
		userinfo.put("department", user.getGroup().getName());
		userinfo.put("createdate", user.getCreateDate());
		return userinfo;
	}
}
