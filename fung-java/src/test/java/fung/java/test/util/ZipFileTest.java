package fung.java.test.util;

import org.junit.Test;

import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileTest {

    @Test
    public void testZin() {
        try (ZipFile zipFile = new ZipFile("E:/test/t.zip")) {
            Enumeration enumeration = zipFile.entries();

            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = (ZipEntry) enumeration.nextElement();
                System.out.println(zipEntry);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
