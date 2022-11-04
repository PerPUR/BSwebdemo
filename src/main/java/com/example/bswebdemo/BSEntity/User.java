package com.example.bswebdemo.BSEntity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {

    @TableField(value = "username")
    private String username;
    @TableField(value = "userphone")
    private String userphone;

}
