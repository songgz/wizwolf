## 集成Swing客户端与SpringBoot

#### 步骤 1：创建服务类（AuthernService）实现登录功能，对应Compiere的Login类。
```java
@Service
public class AuthenService {
    private final ADUserRepository userRepo;    
    private ADUser user = null;
    private boolean authenticated;

    @Autowired
    public AuthenService(ADUserRepository userRepo, ADRoleRepository roleRepo) {
        this.userRepo = userRepo;        
    }

    @Transactional
    public Optional<ADUser> login(String name, String password) {
        Optional<ADUser> userOptional = userRepo.findByName(name);
        if (userOptional.isPresent()) {
            this.user = userOptional.get();
            if (user.getPassword().equals(password)) {
                Hibernate.initialize(this.user.getRoles());
                return Optional.of(this.user);
            }
        }
        return Optional.empty();
    }

    public boolean isAuthenticated() {
        if (!this.authenticated) {
            if (this.user.getRoles().size() > 0 && this.user.getClient() != null) {
                this.authenticated = true;
            }
        }
        return this.authenticated;
    }
}
```

#### 步骤 2：创建 Swing 登录窗口
在Swing中创建一个登录窗口，允许用户输入用户名和密码。
```java
@Component
public class ALogin extends JFrame implements ChangeListener {
    @Autowired
    private AuthenService authenSrv;

    private CLabel userLabel = new CLabel();
    private CTextField userTextField = new CTextField();
    private CLabel passwordLabel = new CLabel();
    private JPasswordField passwordField = new JPasswordField();

    public void login(String name, String password) {
        Optional<ADUser> o = authenSrv.login(name, password);
        o.ifPresent(user -> {
            if (authenSrv.isAuthenticated()) {
                
            }
        });
    }
}
```
1. ALogin类上加上了@Component注解，这样Spring会自动将它注册为一个Spring Bean，并管理它的生命周期。
2. 当Spring启动时，它会自动实例化ALogin，并且自动注入AuthenService（因为构造函数中有AuthenService作为参数，Spring会根据类型自动注入）。
#### 步骤 3：启动SpringBoot应用
```java
@SpringBootApplication
public class ClientApp {

    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder(ClientApp.class);
        ApplicationContext ctx = builder.headless(false).web(WebApplicationType.NONE).run(args);

        ALogin login = ctx.getBean(ALogin.class);
        login.setVisible(true);
    }
}
```
#### 优点
1. 解耦：ALogin由Spring管理，避免了显式创建对象的代码，遵循了依赖注入（DI）原则。
2. 更好的扩展性：如果以后需要修改或增加其他组件（如其他服务），可以通过 Spring 容器自动管理它们，而不需要手动创建。
3. 代码简洁：通过 Spring 管理 Bean，减少了手动创建对象的冗余代码，使得代码更加简洁。
#### 总结
将ALogin类注解为@Component使得它成为Spring管理的Bean，这样可以充分利用SpringBoot的依赖注入特性，使得整个应用的组件更加解耦和模块化，提升了代码的可维护性和扩展性。这种做法使得整个应用更加符合Spring的设计理念。