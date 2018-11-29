package com.maimai.mybatisApp;

import com.maimai.mybatisApp.config.ConfigurationPropertiesEntity;
import com.maimai.mybatisApp.config.UserInfo;
import com.maimai.mybatisApp.config.YamlGrammarConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(value = { "name=javastack-test", "sex=1" })
@ActiveProfiles("dev")
@TestPropertySource(properties  = {"name=TestPropertySource"})
public class MybatisAppApplicationTests {

	@Value("${name}")
	private String name;

	@Autowired
	private YamlGrammarConfig yamlgrammar;

	@Autowired
	private UserInfo userInfo;

	@Autowired
	private ConfigurationPropertiesEntity configurationPropertiesEntity;

	@Test
	public void contextLoads() {
		System.out.println("name is " + name);
		System.out.println("YamlGrammarConfig : " + yamlgrammar);

		System.out.println("UserInfo : " + userInfo);

		System.out.println("ConfigurationProperties Grammar : " + configurationPropertiesEntity);
	}

}
