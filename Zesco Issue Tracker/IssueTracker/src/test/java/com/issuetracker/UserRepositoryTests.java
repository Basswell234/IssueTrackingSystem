package com.issuetracker;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.issuetracker.model.User;
import com.issuetracker.repository.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	//testing 
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setFirstname("Basswell");
		user.setLastname("Mbilima");
		user.setRole("Supervisor");
		user.setEmail("basswelbiotechmbilima@gmail.com");
		user.setPassword("098765");
		
		User savedUser = repo.save(user);
		User existUser = entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	}

	//testing find user by email
	@Test
	public void testFindUserByEmail(){
		String email = "basswellbiotechmbilima@gmail.com";
		User user = repo.findByEmail(email);
		assertThat(user).isNotNull();
	}
}