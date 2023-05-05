package com.ruoyi.goods.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.goods.domain.UserApikey;
import com.ruoyi.goods.service.IUserApikeyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户ApiKeyController
 * 
 * @author ruoyi
 * @date 2023-05-05
 */
@RestController
@RequestMapping("/goods/apikey")
public class UserApikeyController extends BaseController
{
    @Autowired
    private IUserApikeyService userApikeyService;

    /**
     * 查询用户ApiKey列表
     */
    @PreAuthorize("@ss.hasPermi('goods:apikey:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserApikey userApikey)
    {
        startPage();
        List<UserApikey> list = userApikeyService.selectUserApikeyList(userApikey);
        return getDataTable(list);
    }

    /**
     * 导出用户ApiKey列表
     */
    @PreAuthorize("@ss.hasPermi('goods:apikey:export')")
    @Log(title = "用户ApiKey", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserApikey userApikey)
    {
        List<UserApikey> list = userApikeyService.selectUserApikeyList(userApikey);
        ExcelUtil<UserApikey> util = new ExcelUtil<UserApikey>(UserApikey.class);
        util.exportExcel(response, list, "用户ApiKey数据");
    }

    /**
     * 获取用户ApiKey详细信息
     */
    @PreAuthorize("@ss.hasPermi('goods:apikey:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(userApikeyService.selectUserApikeyById(id));
    }

    /**
     * 新增用户ApiKey
     */
    @PreAuthorize("@ss.hasPermi('goods:apikey:add')")
    @Log(title = "用户ApiKey", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserApikey userApikey)
    {
        return toAjax(userApikeyService.insertUserApikey(userApikey));
    }

    /**
     * 修改用户ApiKey
     */
    @PreAuthorize("@ss.hasPermi('goods:apikey:edit')")
    @Log(title = "用户ApiKey", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserApikey userApikey)
    {
        return toAjax(userApikeyService.updateUserApikey(userApikey));
    }

    /**
     * 删除用户ApiKey
     */
    @PreAuthorize("@ss.hasPermi('goods:apikey:remove')")
    @Log(title = "用户ApiKey", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userApikeyService.deleteUserApikeyByIds(ids));
    }
}
