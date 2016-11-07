package net.shine.mongodb.entity;

/**
 * 用于封装统计信息
 */
public class StatisticMsg {
    private String signature;
    private Integer count;


    @Override
    public String toString() {
        return "StatisticMsg{" +
                "signature='" + signature + '\'' +
                ", count=" + count +
                '}';
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
