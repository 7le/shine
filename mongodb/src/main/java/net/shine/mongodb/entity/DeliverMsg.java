package net.shine.mongodb.entity;

import org.bson.types.ObjectId;

import java.io.Serializable;


public class DeliverMsg implements Serializable {

    private ObjectId did;
    private String msgIdReport;
    private String stat;

    public DeliverMsg(){

    }

    public DeliverMsg(String msgIdReport, String stat) {
        this.msgIdReport = msgIdReport;
        this.stat = stat;
    }

    public ObjectId getDid() {
        return did;
    }

    public void setDid(ObjectId did) {
        this.did = did;
    }

    public String getMsgIdReport() {
        return msgIdReport;
    }

    public void setMsgIdReport(String msgIdReport) {
        this.msgIdReport = msgIdReport;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
