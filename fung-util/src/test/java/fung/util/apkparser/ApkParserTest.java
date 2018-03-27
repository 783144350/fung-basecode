package fung.util.apkparser;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.ApkSigner;
import net.dongliu.apk.parser.bean.ApkV2Signer;
import net.dongliu.apk.parser.bean.CertificateMeta;
import net.dongliu.apk.parser.bean.UseFeature;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.List;

public class ApkParserTest {

    private static final String APK_PATH = "E:/test/my.apk";

    @Test
    public void testApkParser() throws IOException {
        try (ApkFile apkFile = new ApkFile(new File(APK_PATH))) {
            ApkMeta apkMeta = apkFile.getApkMeta();

            System.out.println(apkMeta.getPackageName());
            System.out.println(apkMeta.getVersionCode());

            for (UseFeature feature : apkMeta.getUsesFeatures()) {
                System.out.println(feature.getName());
            }
        }
    }

    @Test
    public void testManifest() throws IOException {
        try (ApkFile apkFile = new ApkFile(new File(APK_PATH))) {
            String manifestXml = apkFile.getManifestXml();
            System.out.println(manifestXml);
        }
    }

    @Test
    public void testSignInfo() throws IOException, CertificateException {
        try (ApkFile apkFile = new ApkFile(new File(APK_PATH))) {
            List<ApkSigner> signers = apkFile.getApkSingers(); // apk v1 signers
            List<ApkV2Signer> v2signers = apkFile.getApkV2Singers(); // apk v2 signers

            v2signers.forEach((signer) -> {
                CertificateMeta certificateMeta = signer.getCertificateMetas().get(0);
                System.out.println(certificateMeta.getCertMd5());
                System.out.println(certificateMeta.getSignAlgorithm());
                System.out.println(certificateMeta.getCertBase64Md5());
                System.out.println(certificateMeta.getSignAlgorithmOID());
            });

        }
    }

}
