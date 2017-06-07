package com.eyric.base.utils.wx;

import com.eyric.base.Json;
import com.eyric.base.utils.JsonUtils;
import com.eyric.base.utils.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 微信工具类
 *
 * @author lwt
 */
public class WxUtil {
    private static String appID = "YOUR APPID";

    private static String appsecret = "YOUR APPSECRET";

    //access_token
    private static String accessToken;

    //jsapi_ticket
    private static String jsapiTicket;

    //access_token过期时间戳
    private static Long passtime;

    //jsapi_ticket过期时间戳
    private static Long passtimeJsapiTicket;

    private WxUtil() {
    }

    /**
     * 获取access_token
     *
     * @return access_token
     */
    public static String getAccessToken() {
        Long now = System.currentTimeMillis();
        if (accessToken != null && accessToken.length() > 0 && passtime != null && passtime > now) {
            return accessToken;
        }
        String accessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appID + "&secret=" + appsecret;
        String result = HttpRequest.get(accessTokenUrl).body();
        Map<String, Object> resultMap = JsonUtils.toObject(result, Map.class);
        String access_token = (String) resultMap.get("access_token");
        Integer expires_in = (Integer) resultMap.get("expires_in");
        if (expires_in != 7200) {
            return null;
        }
        accessToken = access_token;
        passtime = now + 7200000;
        return access_token;
    }

    /**
     * 获取jsapi_ticket
     *
     * @return jsapi_ticket
     */
    public static String getJsapiTicket() {
        Long now = System.currentTimeMillis();
        if (jsapiTicket != null && jsapiTicket.length() > 0 && passtimeJsapiTicket != null && passtimeJsapiTicket > now) {
            return jsapiTicket;
        }
        String jsapiTicketUrl = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=" + getAccessToken() + "&type=jsapi";
        String result = HttpRequest.get(jsapiTicketUrl).body();
        Map<String, Object> resultMap = JsonUtils.toObject(result, Map.class);
        String ticket = (String) resultMap.get("ticket");
        Integer expires_in = (Integer) resultMap.get("expires_in");
        if (expires_in != 7200) {
            return null;
        }
        jsapiTicket = ticket;
        passtimeJsapiTicket = now + 7200000;
        return ticket;
    }

    public static Json getUserInfo(String openid) {
        Json json = new Json();
        String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + getAccessToken() + "&openid=" + openid + "&lang=zh_CN";
        String result = HttpRequest.get(url).body();
        Map<String, Object> resultMap = JsonUtils.toObject(result, Map.class);
        String nickName = (String) resultMap.get("nickname");
        String headImgUrl = (String) resultMap.get("headimgurl");
        Integer sex = (Integer) resultMap.get("sex");

        Map userInfo = new HashMap();
        userInfo.put("nickname", nickName);
        userInfo.put("headimgurl", headImgUrl);
        userInfo.put("sex", sex);

        if (resultMap.get("errcode") != null) {
            json.setSuccess(false);
            json.setMsg("获取用户信息失败");
        } else {
            json.setSuccess(true);
            json.setMsg("获取用户信息成功");
            json.setObj(userInfo);
        }
        return json;
    }
}
