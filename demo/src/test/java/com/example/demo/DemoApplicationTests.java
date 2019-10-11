package com.example.demo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserMapper userMapper;
	@Test
	public void contextLoads() {
		List<User> users = userMapper.selectList(null);
		users.forEach(System.out::println);

	}

	@Test
	public void testInsert(){
		User user = new User();
		//user.setId(6);
		user.setName("xiong");
		user.setAge(29);
		user.setEmail("419799016@qq.com");
		int result = userMapper.insert(user);
		System.out.println(result);
	}
	@Test
	public void testSelectPagination(){
		Page<User> page = new Page<>(2,2);
		IPage<User> userIPage = userMapper.selectPage(page,null);
		long current = userIPage.getCurrent();
		long pages = userIPage.getPages();
		long size = userIPage.getSize();
		long total = userIPage.getTotal();
		List<User> records = userIPage.getRecords();
		System.out.println(current);
		System.out.println(pages);
		System.out.println(size);
		System.out.println(total);

		records.forEach(System.out::println);

	}

}
