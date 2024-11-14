## 项目环境搭建

通过 Maven 搭建一个多模块项目 wizwolf，并包含两个子模块 base 和 client，可以按照以下步骤进行：

1. 创建父项目（wizwolf）
   首先，创建一个父项目目录 wizwolf，然后在该目录中初始化 Maven 项目。我们将在父项目中配置 pom.xml 来管理整个多模块项目。

```bash
mkdir wizwolf
cd wizwolf
mvn archetype:generate -DgroupId=com.wizwolf -DartifactId=wizwolf -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
2. 设置父项目的 pom.xml
   在 wizwolf 项目中，父 pom.xml 文件的内容如下：

```xml
<!-- wizwolf/pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.7.18</version>
    </parent>
    <!-- 项目坐标 -->
    <groupId>com.wizwolf</groupId>
    <artifactId>wizwolf</artifactId>
    <version>1.0-SNAPSHOT</version>
    <packaging>pom</packaging>

    <modules>
        <module>base</module>
        <module>client</module>
    </modules>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-configuration-processor</artifactId>
                <optional>true</optional>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-cache</artifactId>
            </dependency>
            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-data-jpa</artifactId>
            </dependency>
            <dependency>
                <groupId>com.github.ben-manes.caffeine</groupId>
                <artifactId>caffeine</artifactId>
            </dependency>
            <dependency>
                <groupId>org.postgresql</groupId>
                <artifactId>postgresql</artifactId>
                <scope>runtime</scope>
            </dependency>
            <dependency>
                <groupId>org.projectlombok</groupId>
                <artifactId>lombok</artifactId>
                <optional>true</optional>
            </dependency>
            <dependency>
                <groupId>org.flywaydb</groupId>
                <artifactId>flyway-core</artifactId>
            </dependency>
            <dependency>
                <groupId>com.h2database</groupId>
                <artifactId>h2</artifactId>
                <scope>runtime</scope>
            </dependency>

            <dependency>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-starter-test</artifactId>
                <scope>test</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.flywaydb</groupId>
                    <artifactId>flyway-maven-plugin</artifactId>
                    <version>9.1.0</version>
                    <configuration>
                        <url>jdbc:postgresql://localhost:5432/wizwolf</url>
                        <user>wizwolf</user>
                        <password>wizwolf</password>
                        <locations>
                            <location>filesystem:src/main/resources/db/migration</location>
                        </locations>
                    </configuration>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>
</project>
```
3. 创建子模块 base，对应Compiere的base目录
在 wizwolf 目录下创建 base 子模块目录，并初始化该模块的 pom.xml。

```bash
mkdir base
cd base
mvn archetype:generate -DgroupId=com.wizwolf -DartifactId=base -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
4. 设置 base 子模块的 pom.xml
   子模块 base 的 pom.xml 文件如下：

```xml
<!-- wizwolf/base/pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.wizwolf</groupId>
        <artifactId>wizwolf</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>base</artifactId>

    <dependencies>
        <!-- 在这里添加 base 模块所需的依赖 -->
    </dependencies>
</project>
```
5. 创建子模块 client，对应Compiere的client目录
同样的，在 wizwolf 目录下创建 client 子模块目录，并初始化该模块的 pom.xml。

```bash
mkdir client
cd client
mvn archetype:generate -DgroupId=com.wizwolf -DartifactId=client -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```
6. 设置 client 子模块的 pom.xml
   子模块 client 的 pom.xml 文件如下：

```xml
<!-- wizwolf/client/pom.xml -->
<project xmlns="http://maven.apache.org/POM/4.0.0"
xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
<modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>com.wizwolf</groupId>
        <artifactId>wizwolf</artifactId>
        <version>1.0-SNAPSHOT</version>
        <relativePath>../pom.xml</relativePath>
    </parent>

    <artifactId>client</artifactId>

    <dependencies>
        <!-- 在这里添加 client 模块所需的依赖 -->
        <dependency>
            <groupId>com.wizwolf</groupId>
            <artifactId>base</artifactId>
            <version>1.0-SNAPSHOT</version>
        </dependency>
        <dependency>
            <groupId>org.swinglabs</groupId>
            <artifactId>swingx</artifactId>
            <version>1.6.1</version>
        </dependency>
        <dependency>
            <groupId>com.formdev</groupId>
            <artifactId>flatlaf</artifactId>
            <version>3.0</version>
        </dependency>

    </dependencies>
</project>
```
7. 目录结构
现在你的项目目录结构应该如下所示：
```
wizwolf/
│
├── base/
│   ├── pom.xml
│   └── src/
├── client/
│   ├── pom.xml
│   └── src/
└── pom.xml
```
8. 构建整个项目
   在 wizwolf 目录下运行以下 Maven 命令来构建整个项目：

```bash
mvn clean install
```
9. 子模块间的依赖
   如上所示，client 模块依赖于 base 模块。Maven 会自动处理这些依赖关系。

10. 示例代码
    你可以在 base 和 client 模块的 src/main/java 中分别编写自己的代码。例如，在 base 模块中编写一个简单的类：

```java
// base/src/main/java/com/wizwolf/base/BaseClass.java
package com.wizwolf.base;

public class BaseClass {
public void printMessage() {
System.out.println("Hello from Base module!");
}
}
```
然后在 client 模块中使用 base 模块中的类：

```java
// client/src/main/java/com/wizwolf/client/ClientApp.java
package com.wizwolf.client;

import com.wizwolf.base.BaseClass;

public class ClientApp {
public static void main(String[] args) {
BaseClass baseClass = new BaseClass();
baseClass.printMessage();
}
}
```
11. 总结
    到这里，你已经成功搭建了一个多模块的 Maven 项目，其中父项目 wizwolf 管理子模块 base 和 client。client 模块通过 Maven 的依赖管理使用了 base 模块中的类。通过 Maven 构建命令，你可以方便地构建整个项目并管理模块间的依赖关系。