package com.userservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationStarterTest {

	@Test
	public void applicationStarts() {
		UserServicesApplication.main(new String[] {});
	}
}
