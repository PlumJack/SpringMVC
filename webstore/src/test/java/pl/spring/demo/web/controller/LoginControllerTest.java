package pl.spring.demo.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.spring.demo.controller.LoginController;

public class LoginControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/templates/");
		viewResolver.setSuffix(".html");

		mockMvc = MockMvcBuilders.standaloneSetup(new LoginController()).setViewResolvers(viewResolver).build();
	}
	
	@Test
	public void shouldGoToLoginWhenLoginFailed() throws Exception {
		// given
		
		// when
		ResultActions resultActions = mockMvc.perform(get("/loginfailed"));
		// then
		resultActions.andExpect(view().name("login"));

	}
	
	@Test
	public void shouldGoToLoginWhenLogout() throws Exception {
		// given
		
		// when
		ResultActions resultActions = mockMvc.perform(get("/logout"));
		// then
		resultActions.andExpect(view().name("login"));
		
	}
	
	@Test
	public void shouldGoToLoginWhenLogin() throws Exception {
		// given
		
		// when
		ResultActions resultActions = mockMvc.perform(get("/login"));
		// then
		resultActions.andExpect(view().name("login"));
		
	}
	
	
}
