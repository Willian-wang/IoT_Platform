package com.heiyu.register.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.*;

/**
 * @ClassName: ThreadPoolExecutorConfig
 * @Description: //TODO
 * @Author: WangYi
 * @Date: 10:49 2019/8/1
 * @Version: 1.0
 **/

@EnableAsync
@Configuration
public class ThreadPoolExecutorConfig {
    private static final int THREADS = Runtime.getRuntime().availableProcessors() + 1;
    final ThreadFactory threadFactory = new ThreadFactoryBuilder()
            // -%d不要少
            .setNameFormat("async-task-name-%d")
            .setDaemon(false)
            .build();

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        return new ThreadPoolExecutor(THREADS, 2 * THREADS,
                5, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1024),
                threadFactory, (r, executor) -> {
            // 打印日志,添加监控等
            System.out.println("task is rejected!");
        });
    }
}