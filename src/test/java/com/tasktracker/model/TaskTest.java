package com.tasktracker.model;

import com.tasktracker.valueobject.TaskStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @Test
    void testTaskBuilderAndGetters() {
        Task task = Task.builder()
                .id(10L)
                .title("Test")
                .description("Desc")
                .status(TaskStatus.COMPLETED)
                .build();

        assertEquals(10L, task.getId());
        assertEquals("Test", task.getTitle());
        assertEquals("Desc", task.getDescription());
        assertEquals(TaskStatus.COMPLETED, task.getStatus());
    }

    @Test
    void testSetters() {
        Task task = new Task();
        task.setId(5L);
        task.setTitle("Setter Test");
        task.setDescription("Testing setters");
        task.setStatus(TaskStatus.PENDING);

        assertEquals(5L, task.getId());
        assertEquals("Setter Test", task.getTitle());
        assertEquals("Testing setters", task.getDescription());
        assertEquals(TaskStatus.PENDING, task.getStatus());
    }
}
