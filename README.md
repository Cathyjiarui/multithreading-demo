# multithreading-demo

### 介绍
多线程演示

### 类说明
```
|____multithreadingdemo
| |____createThread -- 创建线程方式示例包
| | |____myThread.java -- 方式一:继承Thread类，重写run方法
| | |____PoolThread.java -- 方式五:线程池
| | |____LambdaThread.java -- 方式四:Lambda表达式
| | |____myRunnable.java -- 方式二:实现Runnable接口并实现run方法
| | |____anonymityThread.java -- 方式三:匿名内部类
| |____DesignPatterns -- 设计模式
| | |____Singleton -- 单例设计模式
| | | |____HungerSingleton -- 饿汉式
| | | |____LazySingleton -- 懒汉式
| |____hangAndRestore -- 挂起与恢复
| | |____SuspendDemo -- suspend方法挂起演示  
| | |____DeadSuspendDemo -- suspend死锁演示
| | |____WaitDemo -- wait挂起线程演示
| |____Interrupt -- 中断
| | |____InterruptDemo -- Interrupt中断演示
| | |____StopDemo -- stop线程不安全演示
| |____Lock -- 锁
| | |____MyLock -- 自定义实现锁
| | | |____MyLock -- 自定义实现Lock并实现重入功能
| | | |____MyLockDemo -- MyLock使用示例
| | | |____ReentrantMyLockDemo -- MyLock重入示例
| | |____LockDemo -- Lock示例
| | |____LockDowngradeDemo -- 锁降级演示
| | |____ReentrantLockDemo -- ReentrantLock示例
| | |____ReentrantReadWriteLockDemo -- ReentrantReadWriteLock演示
| |____MyBlockingQueue -- 简单队列实现
| | |____MyBlockingQueue -- 简单队列实现类
| | |____MyBlockingQueueDemo -- 简单队列演示
| |____synchronizedDemo -- synchronized演示
| | |____SynchronizedLockCodeBlock -- synchronized修饰代码块: 锁住一个对象
| | |____SynchronizedLockMethod -- synchronized修饰普通方法:锁住对象的示例
| | |____SynchronizedLockStaticMethod -- synchronized修饰静态方法:锁住整个类
| |____DeadLockDemo.java -- 死锁示例
| |____ThreadStatusDemo.java -- 线程状态示例
| |____UnSafeThread.java -- 线程不安全操作示例
|____MultithreadingDemoApplication.java -- SpringBoot主启动类
```