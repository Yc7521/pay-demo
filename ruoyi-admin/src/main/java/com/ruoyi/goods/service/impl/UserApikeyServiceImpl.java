package com.ruoyi.goods.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.goods.mapper.UserApikeyMapper;
import com.ruoyi.goods.domain.UserApikey;
import com.ruoyi.goods.service.IUserApikeyService;

/**
 * 用户ApiKeyService业务层处理
 * 
 * @author ruoyi
 * @date 2023-05-05
 */
@Service
public class UserApikeyServiceImpl implements IUserApikeyService 
{
    @Autowired
    private UserApikeyMapper userApikeyMapper;

    /**
     * 查询用户ApiKey
     * 
     * @param id 用户ApiKey主键
     * @return 用户ApiKey
     */
    @Override
    public UserApikey selectUserApikeyById(Long id)
    {
        return userApikeyMapper.selectUserApikeyById(id);
    }

    /**
     * 查询用户ApiKey列表
     * 
     * @param userApikey 用户ApiKey
     * @return 用户ApiKey
     */
    @Override
    public List<UserApikey> selectUserApikeyList(UserApikey userApikey)
    {
        return userApikeyMapper.selectUserApikeyList(userApikey);
    }

    /**
     * 新增用户ApiKey
     * 
     * @param userApikey 用户ApiKey
     * @return 结果
     */
    @Override
    public int insertUserApikey(UserApikey userApikey)
    {
        userApikey.setCreateTime(DateUtils.getNowDate());
        return userApikeyMapper.insertUserApikey(userApikey);
    }

    /**
     * 修改用户ApiKey
     * 
     * @param userApikey 用户ApiKey
     * @return 结果
     */
    @Override
    public int updateUserApikey(UserApikey userApikey)
    {
        userApikey.setUpdateTime(DateUtils.getNowDate());
        return userApikeyMapper.updateUserApikey(userApikey);
    }

    /**
     * 批量删除用户ApiKey
     * 
     * @param ids 需要删除的用户ApiKey主键
     * @return 结果
     */
    @Override
    public int deleteUserApikeyByIds(Long[] ids)
    {
        return userApikeyMapper.deleteUserApikeyByIds(ids);
    }

    /**
     * 删除用户ApiKey信息
     * 
     * @param id 用户ApiKey主键
     * @return 结果
     */
    @Override
    public int deleteUserApikeyById(Long id)
    {
        return userApikeyMapper.deleteUserApikeyById(id);
    }
}
