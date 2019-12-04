# springcloud-seata
## 基于springcloud的seata使用分布式事务框架(Seata)介绍

> Seata:Simple Extensible Autonomous Transaction Architecture，简易可扩展的自治式分布式事务管理框架，其前身是fescar。阿里巴巴GTS的开源版实现，是一种分布式事务的解决方案，详情请参看seata官方文档。
## seata主要由三个重要组件组成： ##
1. Transaction Coordinator(TC)：管理全局的分支事务的状态，用于全局性事务的提交和回滚。
1. Transaction Manager(TM)：事务管理器，用于开启全局事务、提交或者回滚全局事务，是全局事务的开启者。
1. Resource Manager(RM)：资源管理器，用于分支事务上的资源管理，向TC注册分支事务，上报分支事务的状态，接受TC的命令来提交或者回滚分支事务。

*springCloud api [https://cloud.spring.io/spring-cloud-static/Finchley.SR4/single/spring-cloud.html](https://cloud.spring.io/spring-cloud-static/Finchley.SR4/single/spring-cloud.html)*


```
eureka-server 注册中心 -> 可扩展为高可用注册注册中心
user 用户中心
bonus_ppints_01 积分系统 01
bonus_ppints_02 积分系统 02
```
> 1. 推荐学习 [https://www.cnblogs.com/haizai/p/11924175.html](https://www.cnblogs.com/haizai/p/11924175.html)*
> 2. 推荐学习 [https://blog.csdn.net/gududedabai/article/details/82993594](https://blog.csdn.net/gududedabai/article/details/82993594)*
> 3. 推荐学习 [https://blog.csdn.net/zyndev/article/details/79604395](https://blog.csdn.net/zyndev/article/details/79604395)*

> 数据源 mysql 阿里云

> Seata

1. github地址 [https://github.com/seata/seata](https://github.com/seata/seata)
2. 官方文档 [http://seata.io/zh-cn/](http://seata.io/zh-cn/) 中文文档
3. 新手入门部署指南 [http://seata.io/zh-cn/docs/ops/deploy-guide-beginner.html](http://seata.io/zh-cn/docs/ops/deploy-guide-beginner.html)
```
maven jar 引入
<seata.version>0.9.0</seata.version>
<dependency>
    <groupId>io.seata</groupId>
    <artifactId>seata-all</artifactId>
    <version>${seata.version}</version>
</dependency>
```

## TODO 因为本地jdk原因，分布式事务实现方式采用 LCN分布式事务框架

> 1. LCN分布式事务框架原理详解4.0 https://blog.csdn.net/gududedabai/article/details/83012487
> 2. http://www.txlcn.org/zh-cn/
> 3. LCN并不生产事务，LCN只是本地事务的协调者

> txlcn 的使用
```
// 事务开启者使用
@LcnTransaction
@Transactional
// 事务参与者使用
@TxcTransaction(propagation = DTXPropagation.SUPPORTS)
@Transactional
``` 

测试Ribbon 使用 RestTemplate 为请求，做txlcn分布式事务，经过两个小时测试，推测RestTemplate 无法正常进行分布式事务。 报错：有null指针，初步推测是RestTemplate 请求时候，无法把全部事务数据专递到位，再使用Feign 测试完成后，做最后结论。
