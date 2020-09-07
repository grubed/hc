package com.hongcheng.techinnovte.pojo.dto;

import lombok.Data;
import java.util.Date;
@Data
public class RolePermissionDTO {
    private Boolean required_permission;
    private Date create_time;
    private Integer permission_id;
    private String permission_code;
    private String permission_name;
    private String role_name;
    private Date update_time;
    private Integer role_id;
    private String delete_status;
    private String menu_name;
    private String menu_code;
    private Integer id;
    private Integer menu_id;
}
