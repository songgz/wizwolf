## 从零构建Compiere ERP项目

Compiere是非常优秀的开源应用类项目，涵盖了现代应用程序设计的方方面面，几乎不借助任何Java框架和工具。早在20多年前能有这样的设计理念，就更加难能可贵了，更应该是程序员学习的榜样。它基于Java1.4设计出如此完备和系统化的ERP，我是觉得非常不可思议，当然了作者本身也是大牛。

Compiere虽然兴起于2000年初，但近年却不那么活跃，其主要原因是技术陈旧和商业模式落后。

为了提升Java技能，深入学习Compiere项目设计，所以决定通过技术升级复刻Compiere项目，充分发挥技术在项目构建上的优势，同时也能有效简化项目的复杂度，更多的注意力关注到业务逻辑上。

新项目命名为Wizwolf，参照Compiere和Adempiere构建，去其糟粕，取其精髓。

#### 一期实现目标：
1. 使用Springboot，快速简单的构建项目。
2. 使用Java11模块化项目构建，后续升级到java17。
3. 使用flyway替代数据库迁移。
4. 使用caffeine替代本地缓存。
5. 使用服务依赖注入，后续升级为微服务。
6. 使用Jpa替代Orm映射，及数据访问。
7. 使用Springboot的多语言国际化。

#### 二期实现目标：
1. 在java17时，swing替换为JavaFX。
2. 创建Web Serve，前后端分离。
3. 创建微服务大规模化集成。

### 实施过程：
1. [项目环境搭建](doc/readme01.md)
2. [实现数据库迁移及对像关系映射](doc/readme02.md)
3. [集成Swing客户端与SpringBoot](doc/readme03.md)
4. [关于弃除MSort类和KeyNamePair类](doc/readme04.md)
5. [关于Swing](doc/readme05.md)