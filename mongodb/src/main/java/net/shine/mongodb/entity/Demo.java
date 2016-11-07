package net.shine.mongodb.entity;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;

/**
 * entity demo
 * Created by hq on 2016/7/15.
 */
public class Demo implements Serializable {

    public static final Class frame_clazz = Frame.class;

    private ObjectId sid;
    private Integer memberId;
    private Integer materialId;
    private String account;
    private String mms_title;
    private List<Frame> frame;
    private String auditStatus;
    private String remark;
    private Long time;
    private String timeCn;
    private Long receiptTime;//回执时间
    private String receiptTimeCn;//回执时间



    @Override
    public String toString() {
        return "MMSMaterial{" +
                "sid=" + sid +
                ", memberId=" + memberId +
                ", materialId=" + materialId +
                ", account=\"" + account + '\"' +
                ", mms_title=\"" + mms_title + '\"' +
                ", frame=\"" + frame + '\"' +
                ", auditStatus=\"" + auditStatus +'\"'+
                ", remark=\"" + remark + '\"' +
                ", time=" + time +
                ", timeCn=\"" + timeCn +'\"'+
                ", receiptTime=" + receiptTime +
                ", receiptTimeCn=\"" + receiptTimeCn + '\"' +
                '}';
    }

    public Demo() {
    }
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public List<Frame> getFrame() {
        return frame;
    }

    public void setFrame(List<Frame> frame) {
        this.frame = frame;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getTimeCn() {
        return timeCn;
    }

    public void setTimeCn(String timeCn) {
        this.timeCn = timeCn;
    }

    public Long getReceiptTime() {
        return receiptTime;
    }

    public void setReceiptTime(Long receiptTime) {
        this.receiptTime = receiptTime;
    }

    public String getReceiptTimeCn() {
        return receiptTimeCn;
    }

    public void setReceiptTimeCn(String receiptTimeCn) {
        this.receiptTimeCn = receiptTimeCn;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public String getMms_title() {
        return mms_title;
    }

    public void setMms_title(String mms_title) {
        this.mms_title = mms_title;
    }

    public ObjectId getSid() {
        return sid;
    }

    public void setSid(ObjectId sid) {
        this.sid = sid;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }


    /**
     * 帧
     */
    public static class Frame implements Serializable {
        private String base64;
        //    private String url;
        private String pictureType;
        private String content;

        @Override
        public String toString() {
            return "{" +
                    "base64=\""+base64+'\"'+
                    "pictureType=\""+pictureType+'\"'+
                    "content=\""+content+'\"'+
                    "}";
        }
        public Frame(){

        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPictureType() {
            return pictureType;
        }

        public void setPictureType(String pictureType) {
            this.pictureType = pictureType;
        }

        public String getBase64() {
            return base64;
        }

        public void setBase64(String base64) {
            this.base64 = base64;
        }

/*        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }*/

    }

}

