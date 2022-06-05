package com.example.api;

import lombok.var;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
@Configuration
public class ThreadConfiguration {
     @Bean
        //Maximum 10 threads in parallel
        public TaskExecutor threadPoolTaskExecutor() {
            var executor = new ThreadPoolTaskExecutor();
            executor.setMaxPoolSize(10);
            executor.initialize();
            return executor;
        }

}

