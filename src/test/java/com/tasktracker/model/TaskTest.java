package com.tasktracker.model;

import com.tasktracker.valueobject.TaskStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testTaskBuilderAndGetters() {
        // arrange & act
        Task task = Task.builder()
                .id(10L)
                .title("Test")
                .description("Desc")
                .status(TaskStatus.COMPLETED)
                .build();

        // assert
        assertEquals(10L, task.getId());
        assertEquals("Test", task.getTitle());
        assertEquals("Desc", task.getDescription());
        assertEquals(TaskStatus.COMPLETED, task.getStatus());
    }

    @Test
    void testSetters() {
        // arrange & act
        Task task = new Task();
        task.setId(5L);
        task.setTitle("Setter Test");
        task.setDescription("Testing setters");
        task.setStatus(TaskStatus.PENDING);

        // assert
        assertEquals(5L, task.getId());
        assertEquals("Setter Test", task.getTitle());
        assertEquals("Testing setters", task.getDescription());
        assertEquals(TaskStatus.PENDING, task.getStatus());
    }
    @Test
    void testToStringMethod() {
        // arrange & act
        Task task = Task.builder()
                .id(100L)
                .title("Swagger Setup")
                .description("Add Swagger to the Task API")
                .status(TaskStatus.IN_PROGRESS)
                .build();

        String result = task.toString();

        // assert
        System.out.println(result.contains("Swagger Setup"));
        assertTrue(result.contains("Swagger Setup"));
        assertTrue(result.contains("IN_PROGRESS"));
        assertTrue(result.contains("100"));
    }
}
