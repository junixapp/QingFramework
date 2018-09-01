## QingFramework
基于Kotlin封装的Android快速开发框架！



## 框架组成

框架主要有MVVM架构和通用组件两大部分。



## MVVM架构

目前MVVM架构大概有几种实现：官方的DataBinding，官方的LiveData，基于Kotlin的代理封装。

DataBinding会侵入XML文件，而且需要掌握大堆注入语法。由于底层是反射，还有一定性能问题，故不是很喜欢。

LiveData底层是通过代理一套数据结构来实现数据变更通知UI。使用起来很简单，且灵活。

基于Kotlin代理封装，这个依赖于类库作者的实力，如果问题不大也可采用。不过目前并没有太成熟稳定的实现方案。

在MVVM架构中，VM是核心，负责管理UI状态，处理业务逻辑，通过响应式的机制来更新UI。基于LiveData的MVVM架构图如下所示：

![mvvm](http://ww1.sinaimg.cn/large/71b38f2cly1fuuhseqf39j20ru0lt401.jpg)



## 通用组件

- UI状态切换组件
- log组件
- http组件
- adapter组件
- dialog组件
- util模块