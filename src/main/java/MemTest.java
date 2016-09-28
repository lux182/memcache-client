import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <p></p>
 *
 * @author Louis
 * @version $Id:PACKAGE_NAME, v 0.1 2016/9/28 11:08 liuxuesi Exp $
 */
public class MemTest {
    public static void main(String[] args) {
        MemcachedClient memcachedClient = null;
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        try

        {
            memcachedClient = (MemcachedClient) applicationContext.getBean("memcachedClient");
            memcachedClient.set("spring", 0, "3.0.0.RELEASE");
            System.out.println("spring: "+memcachedClient.get("spring"));
            memcachedClient.replace("spring", 0, "4.0.0.RELEASE is coming");
            System.out.println("spring: "+memcachedClient.get("spring"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
