package fung.util.apkparser;

import org.junit.Test;

public class ParseSignApkTest {

    private static final String APK_PATH = "E:/test/my.apk";

    @Test
    public void testParseSign() {
        System.out.println(ParseSignApk.getApkSignInfo(APK_PATH));
    }

}
