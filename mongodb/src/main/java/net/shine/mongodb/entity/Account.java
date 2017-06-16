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
    private Double totalAmount;  //总金额
    private Double cost;         //成本
    private Double profit;       //利润
    private String customer;     //顾客名字
    private Double profitSilk;
    private Double profitStone;
    private Date createDate;     //创建时间
    private Long createPerson; //创建人
    private Date updateDate;  //修改时间
    private Long updatePerson; //修改人
    private Integer isDelete;  //逻辑删除  0为删除
    private String remark;   //备注


    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

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

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getProfit() {
        return profit;
    }

    public void setProfit(Double profit) {
        this.profit = profit;
    }

    public Double getProfitSilk() {
        return profitSilk;
    }

    public void setProfitSilk(Double profitSilk) {
        this.profitSilk = profitSilk;
    }

    public Double getProfitStone() {
        return profitStone;
    }

    public void setProfitStone(Double profitStone) {
        this.profitStone = profitStone;
    }

}
