package com.tasktracker.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tasktracker.model.Task;
import com.tasktracker.service.TaskService;
import com.tasktracker.valueobject.TaskStatus;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.*;

import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(TaskController.class)
class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    private Task task;

    @BeforeEach
    void setup() {
        task = Task.builder()
                .id(1L)
                .title("Task One")
                .description("Sample task")
                .status(TaskStatus.IN_PROGRESS)
                .build();
    }

    @Test
    void testGetAllTasks() throws Exception {
        Mockito.when(taskService.getAllTasks()).thenReturn(List.of(task));

        mockMvc.perform(get("/api/v1/tasks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Task One"));
    }

    @Test
    void testGetTaskById() throws Exception {
        Mockito.when(taskService.getTaskById(1L)).thenReturn(task);

        mockMvc.perform(get("/api/v1/task/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Task One"));
    }

    @Test
    void testCreateTask() throws Exception {
        Mockito.when(taskService.createTask(any(Task.class))).thenReturn(task);

        mockMvc.perform(post("/api/v1/task")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("IN_PROGRESS"));
    }

    @Test
    void testUpdateTask() throws Exception {
        Mockito.when(taskService.updateTask(eq(1L), any(Task.class))).thenReturn(task);

        mockMvc.perform(put("/api/v1/task/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(task)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Task One"));
    }

    @Test
    void testDeleteTask() throws Exception {
        mockMvc.perform(delete("/api/v1/task/1"))
                .andExpect(status().isOk());
    }
}
