package com.ruoyi.goods.service.impl;

import com.github.pagehelper.Page;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.goods.domain.Goods;
import com.ruoyi.goods.domain.UserApikey;
import com.ruoyi.goods.domain.vm.GoodsVM;
import com.ruoyi.goods.mapper.GoodsMapper;
import com.ruoyi.goods.service.IGoodsService;
import com.ruoyi.goods.service.IUserApikeyService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 商品Service业务层处理
 *
 * @author ruoyi
 * @date 2023-05-05
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private ISysUserService userService;
    @Autowired
    private IUserApikeyService userApikeyService;

    /**
     * 查询商品
     *
     * @param id 商品主键
     * @return 商品
     */
    @Override
    public Goods selectGoodsById(Long id) {
        return goodsMapper.selectGoodsById(id);
    }

    /**
     * 查询商品列表
     *
     * @param goods 商品
     * @return 商品
     */
    @Override
    public List<Goods> selectGoodsList(Goods goods) {
        return goodsMapper.selectGoodsList(goods);
    }

    /**
     * 查询商品列表
     *
     * @param goods 商品
     * @return 商品
     */
    @Override
    public List<GoodsVM> selectGoodsVMList(Goods goods) {
        Page<Goods> page = (Page<Goods>) goodsMapper.selectGoodsList(goods);

        Page<GoodsVM> vmPage = new Page<>(page.getPageNum(), page.getPageSize());
        vmPage.setTotal(page.getTotal());
        vmPage.addAll(page.stream().map(g ->
            GoodsVM.builder()
                .id(g.getId())
                .name(g.getName())
                .price(g.getPrice())
                .description(g.getDescription())
                .picture(g.getPicture())
                .stock(g.getStock())
                .tag(g.getTag())
                .userId(g.getUserId())
                .user(userService.selectUserById(g.getUserId()))
                .keys(
                    userApikeyService.selectUserApikeyList(
                        UserApikey.builder()
                            .userId(g.getUserId())
                            .build()
                    ).stream()
                        .map(UserApikey::getApikey)
                        .collect(Collectors.toList())
                )
                .build())
            .collect(Collectors.toList()));

        return vmPage;
    }

    /**
     * 新增商品
     *
     * @param goods 商品
     * @return 结果
     */
    @Override
    public int insertGoods(Goods goods) {
        goods.setCreateTime(DateUtils.getNowDate());
        return goodsMapper.insertGoods(goods);
    }

    /**
     * 修改商品
     *
     * @param goods 商品
     * @return 结果
     */
    @Override
    public int updateGoods(Goods goods) {
        goods.setUpdateTime(DateUtils.getNowDate());
        return goodsMapper.updateGoods(goods);
    }

    /**
     * 批量删除商品
     *
     * @param ids 需要删除的商品主键
     * @return 结果
     */
    @Override
    public int deleteGoodsByIds(Long[] ids) {
        return goodsMapper.deleteGoodsByIds(ids);
    }

    /**
     * 删除商品信息
     *
     * @param id 商品主键
     * @return 结果
     */
    @Override
    public int deleteGoodsById(Long id) {
        return goodsMapper.deleteGoodsById(id);
    }
}
