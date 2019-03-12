关键字
synchronized
锁对象包含：this,临界资源对象，Class对象   临界资源对象:指线程共享
同步方法包含，继承   调用体现锁的重入
异常：同步方法出现异常自动释放锁资源

volatile cpu高速缓存，通知cpu计算使用变量时，判断是否变更，变更后使用内存刷新缓存  一般不用
atomic 原子性变量


CountDownLatch  可以和锁混合或替代锁使用
.await()等待门闩开放
.getCount()检测数量
.countDown()门闩减一


ReentrantLock
.lock() 加锁 synchronized 对象加标记信息
.unlock() finally中使用
isLocked = lock.tryLock();//尝试锁机制
isLocked = lock.tryLock(10, TimeUnit.SECONDS);
lock.lockInterruptibly();//尝试打断 阻塞等待锁
private static ReentrantLock static_lock = new ReentrantLock(true);//定义公平锁，公平分配cpu资源，sync非公平锁  等待时间长短来判断分配资源

阻塞状态：包括以下三种
普通阻塞：sleep，可interrupt打断阻塞，抛出异常
等待队列：wait调用需要notify唤醒，无法interrupt
锁池队列：无法获取锁标记，其中部分可打断，
        使用ReentrantLock的lock方法，获取锁标记的时候，需要阻塞等待锁标记，无法打断
        使用ReentrantLock的lockInterruptibly方法获取锁标记的时候，可以打断


.interrupt();打断线程休眠 相当于非正常结束阻塞状态

wait和notify 结合while配合 ，避免多线程判断逻辑失效


ThreadLock
Thread.getCurrentThread 做key,
内存问题：在高并发的时候，可能有内存溢出
使用时，要注意回收资源，将当前线程保存的变量删除
ThreadLocal.remove(); 不删除可能导致泄露问题


同步容器
Concurrent 包中的容器，大多使用系统底层技术实现的线程安全，类似于native,java8使用CAS
ConcurrentHashMap/Set
ConcurrentSkipListMap/Set


线程安全
Hashtable  Vector synchronized使用  不推荐
Collections.syncXXX
Collections.synchronizedCollection()
CopyOnWriteArrayList(); 读多，写少，可以用，


==============Queue
==============Queue
==============Queue
ConcurrentLinkedQueue 队列，fifo
.peek() 查看首数据
.poll() 数据出列，先入先出 返回首数据
.offer("") 添加数据


LinkedBlockingQueue
阻塞队列，队列容量不足自动阻塞，队列容量为0 自动阻塞

ArrayBlockingQueue
底层数组实现的有界队列，自动阻塞，api不同，不同特性
当前容量不足，有阻塞能力
add方法在容量不足时候，抛出异常
put在容量不足，阻塞等待
offer  单参数：不阻塞，容量不足返回false,新增放弃
        多参数，阻塞多长时间，容量不足返回false

DelayQueue
Delay泛型实现类Delay做比较
take()取出 小到大  计划任务，


LinkedTransferQueue
转移队列
add 保存数据，不阻塞等待
transfer 保存数据，阻塞等待，特有方法，消费者take(),处于即时消息


SynchronusQueue
同步队列，容量为0，特殊的tansferQueue,必须现有消费线程等待，才能使用队列
add
put 同transfer中



Java 线程池

ExecutorService
execute
Future submit
Future submit(Callable)  提供线程执行后的返回值
Callable类似runnable可以启动线程的接口，定义call类似run方法，有返回值
Future 线程执行后的结果，通过get获取，无参数，阻塞等待线程结束，有参数，固定时长阻塞等待，逾期抛出异常


状态：
    running 运行中
    shuttingDown 关闭过程中，不接受新任务，处理完本身任务，关闭   ==调用shutdown
    terminated 线程池关闭


Java通过Executors提供四种线程池，分别为：
newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程60s自动销毁空闲线程，若无可回收，则新建线程。


newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
BlockingQueue<Runnable>

newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行