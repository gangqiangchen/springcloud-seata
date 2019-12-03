# springcloud-seata
## 基于springcloud的seata使用分布式事务框架(Seata)介绍

#### Seata:Simple Extensible Autonomous Transaction Architecture，简易可扩展的自治式分布式事务管理框架，其前身是fescar。阿里巴巴GTS的开源版实现，是一种分布式事务的解决方案，详情请参看seata官方文档。
#### seata主要由三个重要组件组成：
#### Transaction Coordinator(TC)：管理全局的分支事务的状态，用于全局性事务的提交和回滚。
#### Transaction Manager(TM)：事务管理器，用于开启全局事务、提交或者回滚全局事务，是全局事务的开启者。
### Resource Manager(RM)：资源管理器，用于分支事务上的资源管理，向TC注册分支事务，上报分支事务的状态，接受TC的命令来提交或者回滚分支事务。


