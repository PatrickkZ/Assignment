package course.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import course.entity.Course;
import course.service.CourseService;

@RunWith(SpringRunner.class)
public class CourseServiceTest {
	
	//测试函数getCourseNameById
	@Test
	public void testGetCourseNameById() {
		//实例化一个CourseService
		CourseService courseService = mock(CourseService.class);
		//调用getCourseNameById函数,提供测试数据"1"
		Course course = courseService.getCourseNameById(1);
		//验证Mock对象函数是否执行,执行次数(默认执行次数为1)
		verify(courseService).getCourseNameById(1);
		
	}
	
	//测试函数addCourse
	@Test
	public void testAddCourse() {
		//创建Mock对象
		CourseService courseService = mock(CourseService.class);
		
		Course course = new Course("1", "J2EE", "邱明", "海韵104");
		courseService.addCourse(course);
		
		//验证Mock对象函数是否执行,执行次数(默认执行次数为1)
		verify(courseService).addCourse(course);
	}

	//测试updateCourse
	@Test
	public void testUpdateCourse(){
		//创建Mock对象
		CourseService courseService = mock(CourseService.class);
		//将id为1的课程地点修改为"海韵202"
		Course course = new Course("1", "J2EE", "邱明", "海韵104");
		courseService.updateCourse(course,1);

		//验证Mock对象函数是否执行,执行次数(默认执行次数为1)
		verify(courseService).updateCourse(course,1);
	}
	
	//测试函数getAllCourses
	@Test
	public void getAllCourses() {
		//创建Mock对象
		CourseService courseService = mock(CourseService.class);
		
		courseService.getAllCourses();
		
		//验证Mock对象函数是否执行,执行次数(默认执行次数为1)
		verify(courseService).getAllCourses();
	}

	//测试deleteCourse
	@Test
	public void testDeleteCourse(){
		//创建Mock对象
		CourseService courseService = mock(CourseService.class);

		courseService.deleteCourse(1);

		//验证Mock对象函数是否执行,执行次数(默认执行次数为1)
		verify(courseService).deleteCourse(1);
	}

}
