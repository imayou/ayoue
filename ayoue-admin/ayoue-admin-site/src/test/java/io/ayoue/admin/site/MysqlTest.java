package io.ayoue.admin.site;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.ayoue.admin.site.config.JpaConfiguration;
import io.ayoue.admin.site.repository.GroupRepository;
import io.ayoue.admin.site.repository.RoleRepository;
import io.ayoue.admin.site.repository.UserRepository;
import io.ayoue.common.model.Group;
import io.ayoue.common.model.Role;
import io.ayoue.common.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JpaConfiguration.class })
@EnableAutoConfiguration(exclude = { JpaRepositoriesAutoConfiguration.class })// 禁止springboot自动加载持久化bean
public class MysqlTest {
	private static Logger logger = LoggerFactory.getLogger(MysqlTest.class);

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	GroupRepository groupRepository;

	@Before
	public void initDate() {
		userRepository.deleteAll();
		roleRepository.deleteAll();
		groupRepository.deleteAll();

		Group group = new Group();
		group.setName("开发部");
		groupRepository.save(group);
		Assert.assertNotNull(group.getId());

		Role role = new Role();
		role.setName("admin");
		roleRepository.save(role);
		Assert.assertNotNull(role.getId());

		User user = new User();
		user.setName("user");
		user.setCreateDate(new Date());
		user.setGroup(group);
		List<Role> roles = roleRepository.findAll();
		Assert.assertNotNull(roles);
		user.setRoles(roles);

		userRepository.save(user);
		Assert.assertNotNull(user.getId());
	}

	@Test
	public void findPage() {
		System.out.println("...");
		Pageable pageable = new PageRequest(0, 10, new Sort(Sort.Direction.ASC, "id"));
		Page<User> page = userRepository.findAll(pageable);
		Assert.assertNotNull(page);
		page.getContent().forEach(user -> {
			logger.info("user name:{}, group name:{}, role name:{}", user.getName(), user.getGroup(), user.getRoles());
		});
	}

}
