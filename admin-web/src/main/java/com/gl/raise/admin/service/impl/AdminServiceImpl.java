package com.gl.raise.admin.service.impl;

import com.gl.raise.admin.entity.Admin;
import com.gl.raise.admin.mapper.AdminMapper;
import com.gl.raise.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author gl
 */


@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    @Override
    public void saveAdmin(Admin admin) {
        adminMapper.insertSelective(admin);
    }
}
