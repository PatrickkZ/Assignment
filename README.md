# assign5
## 实验五设计方案
### 内容：在实验四的代码基础上，将Controller改成Restful API

+ src/main/java
    + course
        + Application.java
    + course.entity
        + Course.java
        + MyError.java
    + course.service
        + CourseService.java
    + course.view
        + CourseController.java
    + course.view.vo（没有使用这个package)
        + AddForm.java
+ src/main/resources
    + templates(没有使用视图)
        + add.ftl
        + add.ftl
        + findbyid.ftl
        + result.ftl
+ src
    + test/java/course/test
        + CourseControllerTest.java
        + CourseServiceTest.java
