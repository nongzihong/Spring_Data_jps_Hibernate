package the_template_data_jpa;

        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.context.annotation.Import;
        import org.springframework.context.annotation.PropertySource;

@Configuration //声明当前配置类
@ComponentScan(basePackages = "the_template_data_jpa") // 扫描当前包 使用 spring 注解
@PropertySource("classpath:application.properties")//加载 资源文件
@Import({JDBCTemplateConfig.class})//扫描 使用 jpa 注解的接口
public class SpringConfig {
}
