package the_template_data_jpa;

        import org.springframework.context.annotation.AnnotationConfigApplicationContext;

        import java.util.List;
        import java.util.Map;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext Ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDAO bean = Ioc.getBean(BookDAO.class);
        List<Map<String, Object>> toList = bean.getToList();
        System.out.println(toList);
        
    }
}
