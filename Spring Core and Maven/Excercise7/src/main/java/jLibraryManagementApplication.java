import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class jLibraryManagementApplication {
    public static void main(String[] args) {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        System.out.println("--- Testing Constructor Injection ---");
        BookService serviceConstructor = (BookService) context.getBean("bookServiceConstructor");
        serviceConstructor.manageBooks();

        System.out.println("\n--- Testing Setter Injection ---");
        BookService serviceSetter = (BookService) context.getBean("bookServiceSetter");
        serviceSetter.manageBooks();
    }
}