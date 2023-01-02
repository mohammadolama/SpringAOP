package com.example.springaopspring.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JwtExtractor {

    public static String username(String token){
        String replace = token.replace(Constants.TOKEN_PREFIX, "");
        DecodedJWT decode = JWT.decode(replace);
        return decode.getClaim("user_name").asString();
    }
}
