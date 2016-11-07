package net.shine.mongodb.entity;

import org.bson.types.ObjectId;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by hq on 2016/11/3.
 */
public class InfoBean implements Serializable{

    private ObjectId sid;
    private String translationName;//译名
    private String name ;//片名
    private String years;//年代
    private String country;//国家
    private String type;//类别
    private String language;//语言
    private String subtitle;//字幕
    private String releaseTime;//上映时间
    private String dbScore;//豆瓣评分
    private String time;//片长
    private String director;//导演
    private String star;//主演
    private String introduction;//简介
    private String title;//题目
    private List photo;//图片
    private Map url;//下载地址

    @Override
    public String toString() {
        return "InfoBean{" +
                "sid=" + sid +
                ", translationName=\"" + translationName + '\"' +
                ", name=\"" + name + '\"' +
                ", years=\"" + years + '\"' +
                ", country=\"" + country + '\"' +
                ", type=\"" + type + '\"' +
                ", language=\"" + language +'\"'+
                ", subtitle=\"" + subtitle + '\"' +
                ", releaseTime=" + releaseTime +
                ", dbScore=\"" + dbScore +'\"'+
                ", time=" + time +
                ", director=\"" + director + '\"' +
                ", star=\"" + star +'\"'+
                ", introduction=" + introduction +
                ", title=\"" + title + '\"' +
                ", photo=" + photo +
                ", url=\"" + url + '\"' +
                '}';
    }

    public ObjectId getSid() {
        return sid;
    }

    public void setSid(ObjectId sid) {
        this.sid = sid;
    }
    public List getPhoto() {
        return photo;
    }

    public void setPhoto(List photo) {
        this.photo = photo;
    }

    public Map getUrl() {
        return url;
    }

    public void setUrl(Map url) {
        this.url = url;
    }

    public String getTranslationName() {
        return translationName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setTranslationName(String translationName) {
        this.translationName = translationName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getDbScore() {
        return dbScore;
    }

    public void setDbScore(String dbScore) {
        this.dbScore = dbScore;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
