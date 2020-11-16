# 传统IO 直接IO
IO设备 (通过DMA) -> 内核缓冲 -> 用户缓冲 -> 内核缓冲 -> IO设备

4次IO，5次上下文切换，浪费CPU资源。

# mmap优化 缓冲IO
IO设备 (通过DMA) -> 内核缓冲(用户空间共享) -> socket缓冲 -> IO设备

减少一次IO，但是不减少上线文切换

RocketMQ使用mmap

#sendFile 不经过用户内核
硬盘 -> 内核缓冲 -> socket缓冲 -> 其他IO设备。

Kafka使用sendFile

3次IO 3次上下文切换

# 其他优化
linux2.4 硬盘 -> 内核缓冲 -> IO设备

# mmap vs sendFile
##1.mmap 适合小数据量读写，sendFile 适合大文件传输。
##2.mmap 需要 4 次上下文切换，3 次数据拷贝；sendFile 需要 3 次上下文切换，最少 2 次数据拷贝。
##3.sendFile 可以利用 DMA 方式，减少 CPU 拷贝，mmap 则不能（必须从内核拷贝到 Socket 缓冲区）。




 