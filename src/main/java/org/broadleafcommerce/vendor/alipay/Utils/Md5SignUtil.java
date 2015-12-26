package org.broadleafcommerce.vendor.alipay.Utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * Created by Mai on 2015/12/6.
 */
public class Md5SignUtil {

    public static String doSign(String readySignText, String key, String inputCharset) {
        readySignText = readySignText + key;
        return DigestUtils.md5Hex(getContentBytes(readySignText,inputCharset));

    }

    public static boolean vertifySignature(String vertifyText, String signatureText, String key , String inputCharset ) {
        vertifyText = vertifyText + key;
        String toVertifyText = DigestUtils.md5Hex(getContentBytes(vertifyText,inputCharset));
        if (toVertifyText.equals(signatureText))  {
            return true;
        } else {
            return false;
        }
    }

    private static byte[] getContentBytes(String content, String charset) {
        if (charset == null || "".equals(charset)) {
            return content.getBytes();
        }
        try {
            return content.getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw  new RuntimeException("Error on MD5 signature. Current charset is :" + charset);
        }
    }
}
