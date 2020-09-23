package com.example.greendaodemo.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.OrderBy;
import org.greenrobot.greendao.annotation.ToOne;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import androidx.annotation.IntDef;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Transient;
import com.example.greendaodemo.db.DaoSession;
import com.example.greendaodemo.db.UserBeanDao;
import com.example.greendaodemo.db.MediaBeanDao;

/**
 * @Description: 媒体属性
 * @Author: 刘
 * @CreateDate: 2020/9/18 9:41
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/9/18 9:41
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
@Entity
public class MediaBean {
    /**
     * 视频类型
     */
    public final static int VIDEO_TYPE = 1;
    /**
     * 图片类型
     */
    public final static int IMAGE_TYPE = 0;

    /**
     * 图片全部显示到屏幕
     */
    public final static int IMAGE_SCALE_FIT_CENTER = 0;

    @IntDef({VIDEO_TYPE, IMAGE_TYPE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface mediaType {
    }

    /**
     * 图片铺满屏幕
     */
    public final static int IMAGE_SCALE_MATRIX = 1;

    //图片缩放类型
    @IntDef({IMAGE_SCALE_MATRIX, IMAGE_SCALE_FIT_CENTER})

    @Retention(RetentionPolicy.SOURCE)
    public @interface scaleType {
    }

    @Id(autoincrement = true)
    private Long mId;//媒体id

    private String destFileName;//文件名称

    //媒体类型
    private @mediaType
    int mediaType = IMAGE_TYPE;

    private int isDisplay = 0;//当前内容是否显示，0显示，1不显示，默认显示

    private String title;//图像标题或者视频标题

    private Long userId;//用户id

    private String mediaPath;//媒体文件路径

    //视频是否自动播放 0自动播放，1不自动播放，针对视频,默认播放
    private int isAutoPlay = 0;
    //视频播放时长
    private long duration;
    //静音播放视频，默认0
    private int mute = 0;
    //当前图片显示类型
    private @scaleType
    int scaleType = IMAGE_SCALE_FIT_CENTER;

    private float maxScale;//最大显示缩放比例，最小边铺满屏幕

    private float minScale;//最小显示缩放比例，即图片全屏显示到屏幕上

    private float focusX;//缩放中心点x坐标，0-1之间

    private float focusY;//缩放中心点y坐标,0-1之间

    private String takenPicTime;//拍摄时间

    private String uploadTime;//上传时间

    @ToOne(joinProperty = "userId")
    private UserBean userBean;//用户
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 287814046)
    private transient MediaBeanDao myDao;

    @Generated(hash = 1516158344)
    private transient Long userBean__resolvedKey;

    @Transient
    private transient boolean checked = false;

    @Generated(hash = 220443680)
    public MediaBean(Long mId, String destFileName, int mediaType, int isDisplay,
                     String title, Long userId, String mediaPath, int isAutoPlay, long duration,
                     int mute, int scaleType, float maxScale, float minScale, float focusX,
                     float focusY, String takenPicTime, String uploadTime) {
        this.mId = mId;
        this.destFileName = destFileName;
        this.mediaType = mediaType;
        this.isDisplay = isDisplay;
        this.title = title;
        this.userId = userId;
        this.mediaPath = mediaPath;
        this.isAutoPlay = isAutoPlay;
        this.duration = duration;
        this.mute = mute;
        this.scaleType = scaleType;
        this.maxScale = maxScale;
        this.minScale = minScale;
        this.focusX = focusX;
        this.focusY = focusY;
        this.takenPicTime = takenPicTime;
        this.uploadTime = uploadTime;
    }

    @Generated(hash = 1767040727)
    public MediaBean() {
    }


    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public int getIsDisplay() {
        return isDisplay;
    }

    public void setIsDisplay(int isDisplay) {
        this.isDisplay = isDisplay;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public int getIsAutoPlay() {
        return isAutoPlay;
    }

    public void setIsAutoPlay(int isAutoPlay) {
        this.isAutoPlay = isAutoPlay;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public int getMute() {
        return mute;
    }

    public void setMute(int mute) {
        this.mute = mute;
    }

    public int getScaleType() {
        return scaleType;
    }

    public void setScaleType(int scaleType) {
        this.scaleType = scaleType;
    }

    public float getMaxScale() {
        return maxScale;
    }

    public void setMaxScale(float maxScale) {
        this.maxScale = maxScale;
    }

    public float getMinScale() {
        return minScale;
    }

    public void setMinScale(float minScale) {
        this.minScale = minScale;
    }

    public float getFocusX() {
        return focusX;
    }

    public void setFocusX(float focusX) {
        this.focusX = focusX;
    }

    public float getFocusY() {
        return focusY;
    }

    public void setFocusY(int focusY) {
        this.focusY = focusY;
    }

    public String getTakenPicTime() {
        return takenPicTime;
    }

    public void setTakenPicTime(String takenPicTime) {
        this.takenPicTime = takenPicTime;
    }

    public String getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(String uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * To-one relationship, resolved on first access.
     */
    @Generated(hash = 1937470662)
    public UserBean getUserBean() {
        Long __key = this.userId;
        if (userBean__resolvedKey == null || !userBean__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            UserBeanDao targetDao = daoSession.getUserBeanDao();
            UserBean userBeanNew = targetDao.load(__key);
            synchronized (this) {
                userBean = userBeanNew;
                userBean__resolvedKey = __key;
            }
        }
        return userBean;
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 556582001)
    public void setUserBean(UserBean userBean) {
        synchronized (this) {
            this.userBean = userBean;
            userId = userBean == null ? null : userBean.getUserId();
            userBean__resolvedKey = userId;
        }
    }

    public Long getMId() {
        return this.mId;
    }

    public void setMId(long mId) {
        this.mId = mId;
    }

    public void setFocusY(float focusY) {
        this.focusY = focusY;
    }

    public void setMId(Long mId) {
        this.mId = mId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    public String getDestFileName() {
        return this.destFileName;
    }

    public void setDestFileName(String destFileName) {
        this.destFileName = destFileName;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 557705576)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getMediaBeanDao() : null;
    }
}
