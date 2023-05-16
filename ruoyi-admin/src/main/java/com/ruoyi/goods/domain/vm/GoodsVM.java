package com.ruoyi.goods.domain.vm;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoodsVM {
    /**
     * 商品id
     */
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private BigDecimal price;

    /**
     * 商品描述
     */
    private String description;

    /**
     * 商品图片
     */
    private String picture;

    /**
     * 商品库存
     */
    private Long stock;

    /**
     * 商品标签
     */
    private String tag;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户
     */
    private SysUser user;

    /**
     * apikey
     */
    private List<String> keys;
}
