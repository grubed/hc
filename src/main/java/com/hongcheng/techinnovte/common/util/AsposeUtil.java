package com.hongcheng.techinnovte.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class AsposeUtil {

    private static boolean wordsLicensed;

    private static Logger logger = LoggerFactory.getLogger(AsposeUtil.class);

    static{
        wordsLicensed = setWordsLicense();
    }

    /**
     * 获取License的输入流
     *
     * @return
     */
    private static InputStream getLicenseInput() {
        try {
            return AsposeUtil.class.getClassLoader().getResourceAsStream("license.xml");
        } catch (Exception e) {
            logger.error("license not found!", e);
        }
        return null;
    }

    public static boolean wordsLicense(){
        return wordsLicensed;
    }

    /**
     * 设置License
     *
     * @return true表示已成功设置License, false表示失败
     */
    private static boolean setWordsLicense() {
        logger.error("开始验证License");
        InputStream licenseInput = getLicenseInput();
        if (licenseInput != null) {
            try {
                com.aspose.words.License aposeLic = new com.aspose.words.License();
                aposeLic.setLicense(licenseInput);
                return aposeLic.getIsLicensed();
            } catch (Exception e) {
                logger.error("set words license error!", e);
            } finally {
                try {
                    licenseInput.close();
                } catch (IOException e) {
                    logger.error("close stream error!", e);
                }
            }
        }
        logger.error("无法获取license.xml文件的流，验证失败");
        return false;
    }
}

