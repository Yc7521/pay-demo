package com.ruoyi.goods.mapper;

import java.util.List;
import com.ruoyi.goods.domain.UserApikey;

/**
 * 用户ApiKeyMapper接口
 * 
 * @author ruoyi
 * @date 2023-05-05
 */
public interface UserApikeyMapper 
{
    /**
     * 查询用户ApiKey
     * 
     * @param id 用户ApiKey主键
     * @return 用户ApiKey
     */
    public UserApikey selectUserApikeyById(Long id);

    /**
     * 查询用户ApiKey列表
     * 
     * @param userApikey 用户ApiKey
     * @return 用户ApiKey集合
     */
    public List<UserApikey> selectUserApikeyList(UserApikey userApikey);

    /**
     * 新增用户ApiKey
     * 
     * @param userApikey 用户ApiKey
     * @return 结果
     */
    public int insertUserApikey(UserApikey userApikey);

    /**
     * 修改用户ApiKey
     * 
     * @param userApikey 用户ApiKey
     * @return 结果
     */
    public int updateUserApikey(UserApikey userApikey);

    /**
     * 删除用户ApiKey
     * 
     * @param id 用户ApiKey主键
     * @return 结果
     */
    public int deleteUserApikeyById(Long id);

    /**
     * 批量删除用户ApiKey
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserApikeyByIds(Long[] ids);
}
