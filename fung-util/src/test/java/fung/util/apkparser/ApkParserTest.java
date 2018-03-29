package fung.util.apkparser;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.ApkSigner;
import net.dongliu.apk.parser.bean.ApkV2Signer;
import net.dongliu.apk.parser.bean.CertificateMeta;
import net.dongliu.apk.parser.bean.UseFeature;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

public class ApkParserTest {

    private static final String APK_PATH = "E:/test/my.apk";

    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

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
    public void testSignInfo() throws IOException, CertificateException, NoSuchAlgorithmException {
        try (ApkFile apkFile = new ApkFile(new File(APK_PATH))) {
            List<ApkSigner> signers = apkFile.getApkSingers(); // apk v1 signers
            List<ApkV2Signer> v2signers = apkFile.getApkV2Singers(); // apk v2 signers


            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            v2signers.forEach((signer) -> {

                System.out.println(signer.getCertificateMetas().size());

                CertificateMeta certificateMeta = signer.getCertificateMetas().get(0);

                digest.update(certificateMeta.getData());

                System.out.println(certificateMeta.getCertMd5());
                System.out.println(certificateMeta.getSignAlgorithm());
                System.out.println(certificateMeta.getCertBase64Md5());
                System.out.println(certificateMeta.getSignAlgorithmOID());
            });

            Assert.assertEquals(toHexString(digest.digest()), "93272FE48B21680C4DE0AF45816BA86D6AD217CC");

        }
    }

    /**
     * 进行转换
     */
    public static String toHexString(byte[] bData) {
        StringBuilder sb = new StringBuilder(bData.length * 2);
        for (int i = 0; i < bData.length; i++) {
            sb.append(HEX_DIGITS[(bData[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[bData[i] & 0x0f]);
        }
        return sb.toString();
    }

}
