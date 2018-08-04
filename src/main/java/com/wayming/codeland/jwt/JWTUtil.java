package com.wayming.codeland.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author m969130721@163.com
 * @date 18-6-20 下午7:15
 */
public class JWTUtil {
    private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);

    /**
     * 生成JWT
     *
     * @param header  头
     * @param payload 载荷
     * @param secret  　密码
     * @throws UnsupportedEncodingException 　不支持的编码异常
     * @return　JWT 字符串
     */
    public static String generateJWT(JWTHeader header, JWTPayload payload, String secret) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        Map<String, Object> headerMap = new HashMap<>();
        headerMap.put(PublicClaims.ALGORITHM, header.getAlg());
        headerMap.put(PublicClaims.TYPE, header.getTyp());

        return JWT.create()
                .withHeader(headerMap)
                .withIssuer(payload.getIss())
                .withIssuedAt(payload.getIat())
                .withExpiresAt(payload.getNbf())
                .withJWTId(payload.getJti())
                .withAudience(payload.getAud())
                .withSubject(payload.getSub())
                .withClaim("userId", payload.getUserId())
                .withClaim("loginName", payload.getLoginName())
                .withClaim("icon", payload.getIcon())
                .withArrayClaim("roleIdList", payload.getRoleIdList())
                .sign(algorithm);
    }

    /**
     * 校验JWT
     *
     * @param token  　JWT
     * @param secret 　密钥
     * @return
     * @throws UnsupportedEncodingException
     */
    public static DecodedJWT verifyToken(String token, String secret) throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256(secret);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        return jwtVerifier.verify(token);
    }

    /**
     * 根据token解析出Payload数据
     *
     * @param token
     * @return
     */
    public static String getPayloadStringByToken(String token) {
        String[] split = token.split(".");
        String payLoadString = split[1];
        byte[] bytes = Base64.decodeBase64(payLoadString);
        try {
            return new String(bytes, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String getPayloadStringByToken(String token, String secret) {
        String payloadString = "";
        DecodedJWT decodedJWT;
        try {
            decodedJWT = JWTUtil.verifyToken(token, secret);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return payloadString;
        }
        String payloadBase64 = decodedJWT.getPayload();
        byte[] decodeBase64 = Base64.decodeBase64(payloadBase64);
        try {
            payloadString = new String(decodeBase64, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return payloadString;
    }


}