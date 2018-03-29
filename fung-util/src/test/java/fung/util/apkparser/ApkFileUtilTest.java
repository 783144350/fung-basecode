package fung.util.apkparser;

import net.dongliu.apk.parser.bean.ApkMeta;

import org.junit.Test;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

public class ApkFileUtilTest {

    private static final String APK_PATH = "E:/test/my.apk";

    @Test
    public void testGetApkInfo() throws IOException {
        ApkMeta apkMeta = ApkFileUtil.getApkMeta(APK_PATH);
        System.out.println("Package name: " + apkMeta.getPackageName());
        System.out.println("Version name: " + apkMeta.getVersionName());
        System.out.println("Version code: " + apkMeta.getVersionCode());
    }

    @Test
    public void testGetSignSha1() throws CertificateException, NoSuchAlgorithmException, IOException {
        System.out.println(ApkFileUtil.getSignSha1(APK_PATH));
    }

}
