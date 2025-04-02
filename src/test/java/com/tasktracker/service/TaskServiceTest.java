package com.tasktracker.service;

import com.tasktracker.model.Task;
import com.tasktracker.repository.TaskRepository;
import com.tasktracker.valueobject.TaskStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;

    @InjectMocks
    private TaskService taskService;

    private Task sampleTask;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
        sampleTask = Task.builder()
                .id(1L)
                .title("Test Task")
                .description("Unit test task")
                .status(TaskStatus.PENDING)
                .build();
    }

    @Test
    void testGetAllTasks() {
        when(taskRepository.findAll()).thenReturn(List.of(sampleTask));
        List<Task> tasks = taskService.getAllTasks();
        assertEquals(1, tasks.size());
        assertEquals("Test Task", tasks.get(0).getTitle());
    }

    @Test
    void testGetTaskById() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        Task task = taskService.getTaskById(1L);
        assertEquals("Test Task", task.getTitle());
    }

    @Test
    void testCreateTask() {
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);
        Task created = taskService.createTask(sampleTask);
        assertNotNull(created);
        assertEquals(TaskStatus.PENDING, created.getStatus());
    }

    @Test
    void testUpdateTask() {
        when(taskRepository.findById(1L)).thenReturn(Optional.of(sampleTask));
        when(taskRepository.save(any(Task.class))).thenReturn(sampleTask);

        Task updatedDetails = Task.builder()
                .title("Updated Title")
                .description("Updated Description")
                .status(TaskStatus.COMPLETED)
                .build();

        Task updated = taskService.updateTask(1L, updatedDetails);
        assertEquals("Updated Title", updated.getTitle());
    }

    @Test
    void testDeleteTask() {
        doNothing().when(taskRepository).deleteById(1L);
        taskService.deleteTask(1L);
        verify(taskRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetTaskByIdNotFound() {
        when(taskRepository.findById(999L)).thenReturn(Optional.empty());
        RuntimeException ex = assertThrows(RuntimeException.class, () -> taskService.getTaskById(999L));
        assertTrue(ex.getMessage().contains("Task not found"));
    }
}
