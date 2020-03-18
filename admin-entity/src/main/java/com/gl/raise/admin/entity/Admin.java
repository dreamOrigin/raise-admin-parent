package com.gl.raise.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Table: tb_admin
 * @description 后台用户实体类
 * @author gl
 * @date 2020-03-18 21:58:04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_admin")
public class Admin {
    /**
     * Table:     tb_admin
     * Column:    id
     * Nullable:  false
     */
    @Id
    private Integer id;

    /**
     * 登录账号
     *
     * Table:     tb_admin
     * Column:    account
     * Nullable:  false
     */
    private String account;

    /**
     * 登录密码
     *
     * Table:     tb_admin
     * Column:    password
     * Nullable:  false
     */
    private String password;

    /**
     * 用户昵称
     *
     * Table:     tb_admin
     * Column:    username
     * Nullable:  false
     */
    private String username;

    /**
     * 手机号码
     *
     * Table:     tb_admin
     * Column:    mobile
     * Nullable:  false
     */
    private String mobile;

    /**
     * 邮箱地址
     *
     * Table:     tb_admin
     * Column:    email
     * Nullable:  false
     */
    private String email;

    /**
     * 创建时间
     *
     * Table:     tb_admin
     * Column:    create_time
     * Nullable:  false
     */
    @Column(name = "create_time")
    private Integer createTime;

    /**
     * 更新时间
     *
     * Table:     tb_admin
     * Column:    update_time
     * Nullable:  false
     */
    @Column(name = "update_time")
    private Integer updateTime;
}