package com.leogersen.looptasks.infrastructure.web.security;

public class SecurityConstants {

    public static final String SECRET_KEY =  "TheSecretKey!";
    public static  final long EXPIRATION_TIME = 86400000; // 1 day
    public static final String AUTHORIZATION_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

}
