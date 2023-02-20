package com.project.myblog.config.oauth.provider;

public interface OAuth2UserInfo {
    String getProviderID();

    String getProvider();

    String getEmail();

    String getName();
}
