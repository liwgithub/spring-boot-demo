package cn.baiding.common;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by BaiDing on 2017/7/23.
 * “异步调用”对应的是“同步调用”，
 * 同步调用指程序按照定义顺序依次执行，每一行程序都必须等待上一行程序执行完成之后才能执行；
 * 异步调用指程序在顺序执行时，不等待异步调用的语句返回结果就执行后面的程序。
 *
 * 在Spring Boot中，我们只需要通过使用@Async注解就能简单的将原来的同步函数变为异步函数
 *
 * 注意要在启动类上开启异步功能@EnableAsync
 */
@Component
public class AsyncTest {

    //定义一个随机对象.
    private static Random random =new Random();

    //任务一;
    @Async
    public void doTaskOne() throws Exception {
        System.out.println("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务一，耗时：" + (end - start) + "毫秒");
    }

    //任务二;
    @Async
    public void doTaskTwo() throws Exception {
        System.out.println("开始做任务二");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务二，耗时：" + (end - start) + "毫秒");
    }

    //任务3;
    @Async
    public void doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
    }

}
