import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.library.service.BookService;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        
        // 1. Load the Spring application context from the XML file
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        // 2. Retrieve the BookService bean from the container
        BookService service = (BookService) context.getBean("bookService");
        
        // 3. Call the method to verify that BookRepository was injected successfully
        service.manageBooks();
    }
}