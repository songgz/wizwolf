## 关于Swing
Swing 是 Java 中用于构建图形用户界面 (GUI) 的工具包，尽管它自从 1998 年被引入以来已经非常成熟，但自 Java 6 以后，Swing 的更新相对较少。Swing 本身在 Java 8 及以后版本中并没有大幅度的更新或新的重大功能引入，主要的改进和修复集中在性能优化、bug 修复和对现代硬件支持上。

#### Java 最新版本对 Swing 的改进（Java 9 及以后）：
1. JDK 9：模块化（Java Platform Module System, JPMS）

* Java 9 引入了模块化系统，也就是 Java Platform Module System (JPMS)，这对 Swing 有一定的影响。
* Swing 的模块化： Swing 被分为一个模块：java.desktop。这意味着如果你只需要使用 Swing 相关功能，而不需要完整的 JDK，你可以在构建应用时选择性地引入这个模块。
2. Java 9/10/11：性能优化和 bug 修复

* 性能提升：随着 JDK 的优化，Swing 的一些渲染和性能方面有所改进，但这并不是重大变化。例如，JDK 9 改进了基于硬件加速的图形渲染。
* Bug 修复：Swing 仍然会定期修复一些长期存在的问题，尤其是一些 UI 控件的显示问题、跨平台兼容性问题等。
3. Java 11：对现代硬件的支持

* Java 11 引入了对新的显示技术的更好支持。例如，在高分辨率显示器上的支持有了一些增强，Swing 组件在处理 DPI（每英寸点数）时更加精确。
* JEP 330：Launch Single-File Source-Code Programs：使得用户可以通过命令行直接启动 Java 源代码（如 Swing 程序），这对开发者的使用体验有所提升，但 Swing 本身并没有新的 API 或控件被引入。
4. Java 12 - 17：没有大的 Swing 改动

* 这几个版本主要集中在增强 Java 核心功能、垃圾回收优化、性能改进等方面。Swing 本身没有显著的新特性加入。
* 例如，Java 14 引入了 JEP 358: ZGC (Z Garbage Collector)，虽然这影响了 Java 应用程序的性能，但并不直接影响 Swing 组件本身。
5. Java 16 - 17：JEP 396 - Strong Encapsulation of JDK Internals

* 对 JDK 内部类和方法的封装进一步加强，减少了对外部应用程序的直接访问，但这对于 Swing 的影响也较小。
#### Swing 与 JavaFX 的对比：
* 尽管 Swing 没有大幅的新增特性，JavaFX（另一个用于构建 GUI 的 Java 库）自 Java 8 起得到了更积极的开发支持，成为 Java GUI 的新标准。JavaFX 提供了更现代的 UI 控件、动画、CSS 样式和更强的硬件加速支持。JavaFX 在很多方面已经超越了 Swing，尤其是在图形和多媒体的支持上。
* 尽管如此，Swing 仍然广泛用于遗留项目和老旧的桌面应用程序，因为它有着庞大的用户基础和成熟的生态系统。
#### 总结：
1. Swing 本身没有重大新特性：自 Java 8 后，Swing 并未得到大规模的新特性或重构，更多的是修复了性能和兼容性问题，尤其是在高分辨率显示器的支持上。
2. 对现代硬件的支持有所增强：在 Java 9 以后，Swing 在硬件加速和显示技术（如高 DPI 屏幕）的支持上做了一些优化。
3. Swing 与 JavaFX 的共存：尽管 JavaFX 提供了更现代的功能，Swing 仍然是 Java GUI 开发的一个重要部分，特别是在老旧应用中。

如果你需要构建现代化的 Java GUI 应用，建议使用 JavaFX，因为它拥有更多的控件、动画效果以及对现代硬件的优化支持。而如果你是在维护一个老旧的 Swing 应用，Swing 依然是一个有效的选择，特别是在其长久以来积累的稳定性和丰富的控件库的支持下。
所以最终要替换Swing 为 JavaFX。


#### 泛型的引入：
Java 5 引入了对泛型的支持，这意味着在 JDK 1.5 及之后的版本中，你可以使用 JComboBox<T> 来指定 JComboBox 中存储的元素类型。

例如：

```java
JComboBox<String> comboBox = new JComboBox<>();
```
在这个例子中，JComboBox 中的元素被限制为 String 类型。

在没有泛型的情况下，你可能会看到这样的写法：

```java
JComboBox comboBox = new JComboBox();
```
这里，comboBox 可以存储任何类型的数据，但你在使用时可能需要进行类型转换，这也是Compiere的做法，因为那是JDK1.4的时代。

#### 总结：
泛型类型是在Java5 (JDK 1.5) 中引入的。如果你使用的是更高版本的Java（如 Java5 或以上），你可以使用泛型版本的Swing组件，如 JComboBox<T>。
所以我们要把Compiere组件改为泛型组件，如CComboBox改为CComboBox<T>，避免在使用中手动进行类型转换。