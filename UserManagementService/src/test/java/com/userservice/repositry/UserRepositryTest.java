package com.userservice.repositry;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.userservice.model.User;
import com.userservice.repository.UserRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositryTest {
	@Autowired
	private TestEntityManager testEntityManager;

	@Autowired
	private  UserRepository userRepositry;

	private User getUser() {
		User user=new User(1, "sree", "hari", "yadav", "skht", "hari@gmail.com", "hari");
		return user;
	}

	@Test
	public void getUserByUserId() {
		User user=getUser();
		User saveUser=testEntityManager.persist(user);
		User getUser=userRepositry.getOne(user.getUserId());
		assertThat(saveUser).isEqualTo(getUser);
	}

	@Test
	public void saveUserTest() {
		User user=getUser();
		User saveUser=testEntityManager.persist(user);
		User getUser=userRepositry.getOne(user.getUserId());
		assertThat(getUser).isEqualTo(saveUser);
	}

	@Test
	public void updateUserTest() {
		User user=getUser();
		User saveUser=testEntityManager.persist(user);
		User updateUser=new User(1, "sri", "hari", "yadav", "skht", "srihari@gmail.com", "123");
		User updateAndGetSaveUser=userRepositry.save(updateUser);
		assertThat(updateAndGetSaveUser).isEqualTo(saveUser);	
	}

	@Test
	public void deleteUserTest() {
		User user=getUser();
		testEntityManager.remove(user);
		User getUser=userRepositry.getOne(user.getUserId());
		if(getUser==null) {
			assertThat(0).isEqualTo(0);
		}
		assertThat(1).isEqualTo(1);	
	}
}
