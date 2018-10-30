package com.json.jdbcdemo.pojo;

import java.util.List;

public class SysRole {
    private String role; // 角色标识程序中判断使用,如"admin",这个是唯一的:
    private String description; // 角色描述,UI界面显示使用
    private List<SysPermission> permissions;//角色 -- 权限关系：多对多关系;
    private List<User> users;// 一个角色对应多个用户

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SysPermission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<SysPermission> permissions) {
        this.permissions = permissions;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", permissions=" + permissions +
                ", users=" + users +
                '}';
    }
}
