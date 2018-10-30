package course.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import course.service.CourseService;
import course.view.*;

@RunWith(SpringRunner.class) //表示使用SpringRunner组件进行单元测试
@WebMvcTest(CourseController.class) //表示要测试的类是CourseController
public class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseService;
	
	//测试getAllCourse的get请求
	//mockMvc调用perform,返回操作结果
	//andDo(print())表示将返回的结果打印出来
	//andExpect(status().isOk())表示确认返回的http请求状态是否OK
	@Test
	public void testGetAllCourse() throws Exception {
		this.mockMvc.perform(get("/course/getall")).andDo(print()).andExpect(status().isOk());
	}

	//测试getCourseNameById的get请求
	@Test
	public void testGetCourseNameByIdSuccess() throws Exception {
		this.mockMvc.perform(get("/course/query/{id}",1)).andDo(print()).andExpect(status().isOk());
	}

	
	//测试AddCourse的post请求
	//contentType设置请求头部的ContentType参数
	//accept设置请求头部的Accept参数
	//content中是post请求body中的内容
	@Test
	public void testAddProcess() throws Exception{
		this.mockMvc.
		perform(post("/course/add")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content("{\"id\":\"2\", \"name\":\"J2EE\", \"teacher_name\":\"王美红\", \"location\":\"海韵202\"}")
				)
		.andExpect(status().isOk()).andDo(print());
	}

	//测试updateCourse的put请求
	//content是put请求body中的内容
	@Test
	public void testUpdateCourse()throws Exception{
		this.mockMvc.perform(put("/course/update/{id}",1)
		.contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON)
		.content("{\"id\":\"1\", \"name\":\"OOAD\", \"teacher_name\":\"邱明\", \"location\":\"海韵208\"}")
		).andExpect(status().isOk()).andDo(print());
	}

	//测试deleteCourse的delete请求
	@Test
	public void testDeleteCourse()throws Exception{
		this.mockMvc.perform(delete("/course/delete/{id}",1)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
		).andExpect(status().isOk()).andDo(print());
	}
}
