package com.example.greendaodemo.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * @Description: java类作用描述
 * @Author: 刘
 * @CreateDate: 2020/9/17 19:15
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/17 19:15
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity
public class UserBean {
    @Id(autoincrement = true)
    private Long userId;//id自增长

    private String addFriendsKey;//添加id时候的key

    private String userName;//用户名称

    private String headUrl;//用户头像

    private int userState;//用户状态,0离线  1在线

    private String addDate;//添加时间

    private String communicationId;//与手机端通信id

    @Generated(hash = 1230857318)
    public UserBean(Long userId, String addFriendsKey, String userName,
            String headUrl, int userState, String addDate, String communicationId) {
        this.userId = userId;
        this.addFriendsKey = addFriendsKey;
        this.userName = userName;
        this.headUrl = headUrl;
        this.userState = userState;
        this.addDate = addDate;
        this.communicationId = communicationId;
    }

    @Generated(hash = 1203313951)
    public UserBean() {
    }
    
    public Long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getAddFriendsKey() {
        return addFriendsKey;
    }

    public void setAddFriendsKey(String addFriendsKey) {
        this.addFriendsKey = addFriendsKey;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getUserState() {
        return userState;
    }

    public void setUserState(int userState) {
        this.userState = userState;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getCommunicationId() {
        return communicationId;
    }

    public void setCommunicationId(String communicationId) {
        this.communicationId = communicationId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
