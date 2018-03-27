package fung.spring.core.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

public class ResourceTest {

    @Test
    public void testClassPathResource() {
        Resource resource = new ClassPathResource("resource-1", ResourceTest.class);
        Assert.assertEquals(resource.exists(), true);
        System.out.println(resource.getDescription());
    }

    @Test
    public void testFileSystemResource() {
        Resource resource = new FileSystemResource("E:/test/test.txt");
        Assert.assertEquals(resource.exists(), true);
        System.out.println(resource.getDescription());
    }

}
