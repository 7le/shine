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
    private Integer profit_silk;
    private Integer profit_stone;
    private Date createDate;     //创建时间
    private Integer createPerson; //创建人
    private Date updateDate;  //修改时间
    private Integer updatePerson; //修改人
    private Integer isDelete;  //逻辑删除  0为删除
    private String remark;   //备注

    public ObjectId getSid() {
        return sid;
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

    public Integer getProfit_silk() {
        return profit_silk;
    }

    public void setProfit_silk(Integer profit_silk) {
        this.profit_silk = profit_silk;
    }

    public Integer getProfit_stone() {
        return profit_stone;
    }

    public void setProfit_stone(Integer profit_stone) {
        this.profit_stone = profit_stone;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(Integer createPerson) {
        this.createPerson = createPerson;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdatePerson() {
        return updatePerson;
    }

    public void setUpdatePerson(Integer updatePerson) {
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
