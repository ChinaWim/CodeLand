package com.wayming.codeland.jwt;

/**
 * JWT Header
 * @author m969130721@163.com
 * @date 18-6-20 下午7:15
 */
public class JWTHeader {
    /**
     * 加密算法
     */
    private String alg = "HS256";

    public String getAlg() {
        return alg;
    }

    public void setAlg(String alg) {
        this.alg = alg;
    }
    public String getTyp(){
        return "JWT";
    }

}
