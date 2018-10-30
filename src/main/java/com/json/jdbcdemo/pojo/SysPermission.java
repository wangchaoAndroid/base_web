package com.json.jdbcdemo.pojo;

import java.util.List;

public class SysPermission {

    private String permissionName;//名称.
    private String permission; //权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
    private List<SysRole> roles;

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "SysPermission{" +
                "permissionName='" + permissionName + '\'' +
                ", permission='" + permission + '\'' +
                ", roles=" + roles +
                '}';
    }
}
