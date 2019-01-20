package com.bwie.gejuan.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * 作者：gj
 * 时间：20190120
 * 商品类
 */
@Entity
public class Goods {
    @Id
    private long pid;
    private double bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private int itemtype;
    private double price;
    private int pscid;
    private int salenum;
    private int sellerid;
    private String subhead;
    private String title;

    @Generated(hash = 2035753956)
    public Goods(long pid, double bargainPrice, String createtime, String detailUrl,
            String images, int itemtype, double price, int pscid, int salenum,
            int sellerid, String subhead, String title) {
        this.pid = pid;
        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.itemtype = itemtype;
        this.price = price;
        this.pscid = pscid;
        this.salenum = salenum;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
    }

    @Generated(hash = 1770709345)
    public Goods() {
    }

    public double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getItemtype() {
        return itemtype;
    }

    public void setItemtype(int itemtype) {
        this.itemtype = itemtype;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getPscid() {
        return pscid;
    }

    public void setPscid(int pscid) {
        this.pscid = pscid;
    }

    public int getSalenum() {
        return salenum;
    }

    public void setSalenum(int salenum) {
        this.salenum = salenum;
    }

    public int getSellerid() {
        return sellerid;
    }

    public void setSellerid(int sellerid) {
        this.sellerid = sellerid;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
