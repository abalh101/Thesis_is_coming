package com.example.thesis_is_coming.controllerTest.student;

import com.example.thesis_is_coming.controller.studentController.StudentController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(StudentController.class)
public class studentTest {

    @Autowired
    MockMvc mockMvc;
    @Disabled
    @DisplayName("the student-website is reachable")
    @Test
    void testStudentWebsiteIsReachable() throws Exception {
        mockMvc.perform(get("/student"))
                .andExpect(status().isOk());
    }
    @Disabled
    @Test
    void testViewName() throws Exception {
        mockMvc.perform(get("/student")).
                andExpect(view().name("student"));
    }
}
