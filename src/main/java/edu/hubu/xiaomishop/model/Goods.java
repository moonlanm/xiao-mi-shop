package edu.hubu.xiaomishop.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * goods
 *
 * @author moonlan
 */
public class Goods implements Serializable {
    private String goodsId;

    private String goodsName;

    private String goodsImg;

    private Double goodsPrice;

    private Integer goodsNum;

    private String goodsDesc;

    private String goodsDetail;

    private String goodsTypeId;

    private Type goodsType;

    private static final long serialVersionUID = 1L;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImg() {
        return goodsImg;
    }

    public void setGoodsImg(String goodsImg) {
        this.goodsImg = goodsImg;
    }

    public Double getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Double goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsTypeId() {
        return goodsTypeId;
    }

    public void setGoodsTypeId(String goodsTypeId) {
        this.goodsTypeId = goodsTypeId;
    }

    public Type getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(Type goodsType) {
        this.goodsType = goodsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) && Objects.equals(goodsName, goods.goodsName) && Objects.equals(goodsImg, goods.goodsImg) && Objects.equals(goodsPrice, goods.goodsPrice) && Objects.equals(goodsNum, goods.goodsNum) && Objects.equals(goodsDesc, goods.goodsDesc) && Objects.equals(goodsDetail, goods.goodsDetail) && Objects.equals(goodsTypeId, goods.goodsTypeId) && Objects.equals(goodsType, goods.goodsType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, goodsImg, goodsPrice, goodsNum, goodsDesc, goodsDetail, goodsTypeId, goodsType);
    }

    @Override
    public String toString() {
        return "Goods{" + "goodsId='" + goodsId + '\'' + ", goodsName='" + goodsName + '\'' + ", goodsImg='" + goodsImg + '\'' + ", goodsPrice=" + goodsPrice + ", goodsNum=" + goodsNum + ", goodsDesc='" + goodsDesc + '\'' + ", goodsDetail='" + goodsDetail + '\'' + ", goodsTypeId='" + goodsTypeId + '\'' + ", goodsType=" + goodsType + '}';
    }
}