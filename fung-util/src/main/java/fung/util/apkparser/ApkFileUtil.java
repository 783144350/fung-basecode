package fung.util.apkparser;

import net.dongliu.apk.parser.ApkFile;
import net.dongliu.apk.parser.bean.ApkMeta;
import net.dongliu.apk.parser.bean.ApkV2Signer;
import net.dongliu.apk.parser.bean.CertificateMeta;

import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.List;

/**
 * 获取Apk信息的工具类
 * 依赖于net.dongliu.apk.parser
 */
public class ApkFileUtil {

    private static final char HEX_DIGITS[] = { '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

    public static ApkMeta getApkMeta(String filePath) throws IOException {
        return getApkMeta(new File(filePath));
    }

    public static ApkMeta getApkMeta(File file) throws IOException {
        try(ApkFile apkFile = new ApkFile(file)) {
            return apkFile.getApkMeta();
        }
    }

    public static String getSignSha1(String filePath) throws CertificateException, NoSuchAlgorithmException, IOException {
        return getSignSha1(new File(filePath));
    }

    public static String getSignSha1(File file) throws IOException, NoSuchAlgorithmException, CertificateException {
        try(ApkFile apkFile = new ApkFile(file)) {
            List<ApkV2Signer> v2signers = apkFile.getApkV2Singers();

            MessageDigest digest = MessageDigest.getInstance("SHA-1");

            for (ApkV2Signer signer : v2signers) {
                for (CertificateMeta certificateMeta : signer.getCertificateMetas()) {
                    digest.update(certificateMeta.getData());
                }
            }

            return toHexString(digest.digest());

            // JDK >= 1.8
//            v2signers.forEach((signer) -> {
//                CertificateMeta certificateMeta = signer.getCertificateMetas().get(0);
//
//                digest.update(certificateMeta.getData());
//
//            });

            //Assert.assertEquals(toHexString(digest.digest()), "93272FE48B21680C4DE0AF45816BA86D6AD217CC");
        }
    }

    /**
     * 进行转换
     */
    private static String toHexString(byte[] bData) {
        StringBuilder sb = new StringBuilder(bData.length * 2);
        for (int i = 0; i < bData.length; i++) {
            sb.append(HEX_DIGITS[(bData[i] & 0xf0) >>> 4]);
            sb.append(HEX_DIGITS[bData[i] & 0x0f]);
        }
        return sb.toString();
    }

}
