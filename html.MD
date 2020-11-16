# JVM
https://mp.weixin.qq.com/s?__biz=MzI4NDY5Mjc1Mg==&mid=2247483934&idx=1&sn=41c46eceb2add54b7cde9eeb01412a90&chksm=ebf6da61dc81537721d36aadb5d20613b0449762842f9128753e716ce5fefe2b659d8654c4e8&scene=21#wechat_redirect

# Spring循环依赖 & 懒加载
https://zhuanlan.zhihu.com/p/186212601?utm_source=wechat_session&utm_medium=social&utm_oi=662290030073090048
Spring通过三级缓存来解决循环依赖，第一级缓存初始化好的Bean，第二级缓存实例化后的Bean，第三级缓存存ObjectFactory。
依赖注入时依次寻找一级、二级、三级，三级只使用一次放入二级。
使用三级缓存主要是因为初始化有一些后续的processor，类似AOP，会改变这个对象的实例，导致二级缓存的实例和最终生成的不是一个。
如果修改在aop增强后批量替换比较复杂，因此增加三级缓存，通过factory封装此逻辑，并将注册的processor提前包装代理。

通过LazyProxy实现懒加载，只有在调用该类的方法时才会去初始化targetSource.

# Hystrix
https://www.jianshu.com/p/e07661b9bae8
隔离原理：线城池隔离、信号量隔离。信号量主要底层通过AQS实现，可以公平也可以非公平。
工作原理：判断是否熔断 -> 判断是否被限流 -> 记录metric信息

# G1
https://tech.meituan.com/2016/09/23/g1.html

G1目标：实现更高效的GC，GC时间可预测。
原理：内存划分多个region，通过衰减标准差模型来预测回收时间，在回收时间内，按最高效率回收。
GC过程：
1.youngGC: stw,回收全部年轻代，触发时间：young空间不足
2.ConcurrentMark：触发时机-> youngGC触发后，共用youngGC的root scan，通过SATB算法并发标记，计算出region的垃圾比率，只回收全部为垃圾的region
3.mixedGC：stw，回收全部年轻代，根据ConcurrentMark情况选择回收率高的region进行回收。触达时机：根据配置定，配置占比。
4.fullGC：使用SerialOld

# IO多路复用
https://blog.csdn.net/u014590757/article/details/79860766

# epoll原理
https://blog.csdn.net/armlinuxww/article/details/92803381

# DDD
DDD领域驱动设计的核心观点是基于领域知识进行建模，模型浓缩领域知识。适用于业务复杂的系统和支持面向对象编程范式的语言。
解决的问题：系统的可扩展性。
使用中我们更多的是使用这个思想，基于领域来建模，也会通过DDD中的实体、值对象、聚合根来分析模型。
通过server、manager、factory、repo等功能的话分来制定代码规范。

但是，架构设计或系统设计不能光使用DDD，一般复杂系统使用DDD主导，兼顾技术逻辑层面的细节。

# mysql
MySQL 三万字精华总结 + 面试100 问，和面试官扯皮绰绰有余（收藏系列） - 动力节点的文章 - 知乎
https://zhuanlan.zhihu.com/p/162048852

# JMM
https://zhuanlan.zhihu.com/p/258393139
内存模型 主存 -> 工作内存 -> 线程 主要操作lock - load - read - use - assign - write - store - unlock

#ZGC
https://tech.meituan.com/2020/08/06/new-zgc-practice-in-meituan.html

