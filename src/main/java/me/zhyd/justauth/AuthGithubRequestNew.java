package me.zhyd.justauth;

import com.alibaba.fastjson.JSONObject;
import me.zhyd.oauth.cache.AuthStateCache;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.enums.AuthResponseStatus;
import me.zhyd.oauth.model.AuthResponse;
import me.zhyd.oauth.model.AuthToken;
import me.zhyd.oauth.request.AuthGithubRequest;

/**
 * @author xiaoxuxuy
 * @date 2022/11/15 16:46
 */
public class AuthGithubRequestNew extends AuthGithubRequest {

    public AuthGithubRequestNew(AuthConfig config, AuthStateCache authStateCache) {
        super(config, authStateCache);
    }

    @Override
    public AuthResponse revoke(AuthToken authToken) {
        System.out.println("tt");
        String response = this.doGetRevoke(authToken);
        JSONObject object = JSONObject.parseObject(response);
        AuthResponseStatus status = object.getIntValue("result") == 1 ? AuthResponseStatus.SUCCESS : AuthResponseStatus.FAILURE;
        return AuthResponse.builder().code(status.getCode()).msg(status.getMsg()).build();
    }
}
