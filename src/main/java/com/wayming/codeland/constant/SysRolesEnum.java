package com.wayming.codeland.constant;

/**
 * @author m969130721@163.com
 * @date 18-6-22 下午5:12
 */
public enum SysRolesEnum {

    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN");
    private String name;
    SysRolesEnum(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
