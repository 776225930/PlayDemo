package com.jhao.playdemo;

import android.graphics.drawable.Drawable;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

/*
 * 从PackageManager获取的应用程序的信息
 */
@Entity
public class AppInfo {
    //图标
    @Transient
    Drawable icon;
    //app名称
    @Property
    String name;
    //包名
    //否是系统应用;1代表是系统应用 0 代表是第三方应用
    @Property
    @Unique
    String packageName;
    @Property
    boolean isUser;
    //是否安装在手机
    @Property
    boolean isRom;
    //版本号
    @Property
    String appVersion;

    @Generated(hash = 187089010)
    public AppInfo(String name, String packageName, boolean isUser, boolean isRom,
            String appVersion) {
        this.name = name;
        this.packageName = packageName;
        this.isUser = isUser;
        this.isRom = isRom;
        this.appVersion = appVersion;
    }

    @Generated(hash = 1656151854)
    public AppInfo() {
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "icon=" + icon +
                ", name='" + name + '\'' +
                ", packageName='" + packageName + '\'' +
                ", isUser=" + isUser +
                ", isRom=" + isRom +
                ", appVersion='" + appVersion + '\'' +
                '}';
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public boolean getIsUser() {
        return this.isUser;
    }

    public void setIsUser(boolean isUser) {
        this.isUser = isUser;
    }

    public boolean getIsRom() {
        return this.isRom;
    }

    public void setIsRom(boolean isRom) {
        this.isRom = isRom;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
}
