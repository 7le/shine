package net.shine.mongodb.entity;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 7le
 * @since 2017/4/13 0013.
 */
public class Account implements Serializable{

    private ObjectId sid;
    private String name;          //项目名
    private Integer totalAmount;  //总金额
    private Integer cost;         //成本
    private Integer profit;       //利润
    private Integer profitSilk;
    private Integer profitStone;
    private Date createDate;     //创建时间
    private Long createPerson; //创建人
    private Date updateDate;  //修改时间
    private Long updatePerson; //修改人
    private Integer isDelete;  //逻辑删除  0为删除
    private String remark;   //备注

    public String getSid() {
        return sid.toString();
    }

    public void setSid(ObjectId sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getProfit() {
        return profit;
    }

    public void setProfit(Integer profit) {
        this.profit = profit;
    }

    public Integer getProfitSilk() {
        return profitSilk;
    }

    public void setProfitSilk(Integer profitSilk) {
        this.profitSilk = profitSilk;
    }

    public Integer getProfitStone() {
        return profitStone;
    }

    public void setProfitStone(Integer profitStone) {
        this.profitStone = profitStone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Long createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Long updatePerson) {
        this.updatePerson = updatePerson;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
