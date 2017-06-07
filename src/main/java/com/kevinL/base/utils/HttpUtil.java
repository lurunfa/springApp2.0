package com.eyric.base.utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {

    private static Logger logger = Logger.getLogger(HttpUtil.class);

    /**
     * 发送POST请求
     *
     * @param url  请求地址
     * @param json 请求参数，格式为标准json格式{"key1":"value1","key2":"value2"}
     * @return 响应结果
     */
    public static String sendPost(String url, String json) {
        PrintWriter printWriter = null;
        BufferedReader bufferedReader = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection urlConnection = realUrl.openConnection();
            urlConnection.setRequestProperty("accept", "*/*");
            //发送POST请求必须设置如下两行
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);
            printWriter = new PrintWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"));
            printWriter.print(json);
            printWriter.flush();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                result += line;
            }
        } catch (IOException e) {
            logger.error("发送POST请求出现异常");
            e.printStackTrace();
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (IOException e) {
                logger.error("发送POST请求出现异常");
                e.printStackTrace();
            }
        }
        return result;
    }

}