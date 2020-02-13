package com.ky2009666.apps.nio;
import java.util.List;


public class ZdKnowLedge{

    private String pDocId;

    private String knowledgeName;

    private String knowledgeDesc;

    private String createtime;

    private String knowledgetypeId;

    private String knowledgetypeName;

    private String version;

    private String docId;

    private String fileName;

    private String updatetime;

    private String deleteflag;
   

    private String xmlContent;

    private String viewUrl;

    private String jtDocId;

    private String cities;
    

    private String isCreateIndex;
    

    private String wtChannelId;

    private String zhidaoChannelid;
    
    
    
    private String channelId;


    private String videoId;
    private List<String> videoNames;
    private List<String> videoOldPaths;
    private String videoCreateTime;
    private String updateTime;
    private String videoStatus;
    private String videoDocId;
    private String videoHandleTime;
    private String videoPDocId;
    private String videoShortPath;

    
    
    public String getVideoShortPath() {
		return videoShortPath;
	}

	public void setVideoShortPath(String videoShortPath) {
		this.videoShortPath = videoShortPath;
	}

	public String getVideoPDocId() {
        return videoPDocId;
    }

    public void setVideoPDocId(String videoPDocId) {
        this.videoPDocId = videoPDocId;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public String getVideoName() {
        String videoName="";
        for (String name:videoNames){
            videoName += name+",";
        }
        return videoName;
    }

    public void setVideoName(List<String> videoNames) {
        this.videoNames = videoNames;
    }

    public String getVideoOldPath() {
        String oldPath="";
        for (String path:videoOldPaths){
            oldPath += path+",";
        }
        return  oldPath;
    }

    public void setVideoOldPath(List<String> videoOldPaths) {
        this.videoOldPaths = videoOldPaths;
    }

    public String getVideoCreateTime() {
        return videoCreateTime;
    }

    public void setVideoCreateTime(String videoCreateTime) {
        this.videoCreateTime = videoCreateTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVideoStatus() {
        return videoStatus;
    }

    public void setVideoStatus(String videoStatus) {
        this.videoStatus = videoStatus;
    }

    public String getVideoDocId() {
        return videoDocId;
    }

    public void setVideoDocId(String videoDocId) {
        this.videoDocId = videoDocId;
    }

    public String getVideoHandleTime() {
        return videoHandleTime;
    }

    public void setVideoHandleTime(String videoHandleTime) {
        this.videoHandleTime = videoHandleTime;
    }

    /**
     * 获取知识ID+多档分组ID.
     * @return pDocId 知识ID+多档分组ID.
     */
    public String getpDocId() {
        return pDocId;
    }

    /**
     * 设置知识ID+多档分组ID.
     * @param pDocId 知识ID+多档分组ID.
     */
    public void setpDocId(String pDocId) {
        this.pDocId = pDocId;
    }

    /**
     * 获取知识项名称.
     * @return knowledgeName 知识项名称.
     */
    public String getKnowledgeName() {
        return knowledgeName;
    }

    /**
     * 设置知识项名称.
     * @param knowledgeName 知识项名称.
     */
    public void setKnowledgeName(String knowledgeName) {
        this.knowledgeName = knowledgeName;
    }

    /**
     * 获取知识项简介.
     * @return knowledgeDesc 知识项简介.
     */
    public String getKnowledgeDesc() {
        return knowledgeDesc;
    }

    /**
     * 设置知识项简介.
     * @param knowledgeDesc 知识项简介.
     */
    public void setKnowledgeDesc(String knowledgeDesc) {
        this.knowledgeDesc = knowledgeDesc;
    }

    /**
     * 获取创建时间.
     * @return createtime 创建时间.
     */
    public String getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间.
     * @param createtime 创建时间.
     */
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取知识模版ID.
     * @return knowledgetypeId 知识模版ID.
     */
    public String getKnowledgetypeId() {
        return knowledgetypeId;
    }

    /**
     * 设置知识模版ID.
     * @param knowledgetypeId 知识模版ID.
     */
    public void setKnowledgetypeId(String knowledgetypeId) {
        this.knowledgetypeId = knowledgetypeId;
    }

    /**
     * 获取知识模版名称.
     * @return knowledgetypeName 知识模版名称.
     */
    public String getKnowledgetypeName() {
        return knowledgetypeName;
    }

    /**
     * 设置知识模版名称.
     * @param knowledgetypeName 知识模版名称.
     */
    public void setKnowledgetypeName(String knowledgetypeName) {
        this.knowledgetypeName = knowledgetypeName;
    }

    /**
     * 获取知识版本.
     * @return version 知识版本.
     */
    public String getVersion() {
        return version;
    }

    /**
     * 设置知识版本.
     * @param version 知识版本.
     */
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 获取知识库知识ID+多档分组ID.
     * @return docId 知识库知识ID+多档分组ID.
     */
    public String getDocId() {
        return docId;
    }

    /**
     * 设置知识库知识ID+多档分组ID.
     * @param docId 知识库知识ID+多档分组ID.
     */
    public void setDocId(String docId) {
        this.docId = docId;
    }

    /**
     * 获取报文文件名.
     * @return fileName 报文文件名.
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * 设置报文文件名.
     * @param fileName 报文文件名.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 获取更新时间.
     * @return updatetime 更新时间.
     */
    public String getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间.
     * @param updatetime 更新时间.
     */
    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取是否被删除（1：使用，0，删除）
     * @return deleteflag 是否被删除（1：使用，0，删除）
     */
    public String getDeleteflag() {
        return deleteflag;
    }

    /**
     * 设置是否被删除（1：使用，0，删除）
     * @param deleteflag 是否被删除（1：使用，0，删除）
     */
    public void setDeleteflag(String deleteflag) {
        this.deleteflag = deleteflag;
    }

  

    /**
     * 获取报文文档内容.
     * @return xmlContent 报文文档内容.
     */
    public String getXmlContent() {
        return xmlContent;
    }

    /**
     * 设置报文文档内容.
     * @param xmlContent 报文文档内容.
     */
    public void setXmlContent(String xmlContent) {
        this.xmlContent = xmlContent;
    }
    
    /**
     * 获取知识浏览地址.
     * @return viewUrl 知识浏览地址.
     */
    public String getViewUrl() {
        return viewUrl;
    }

    /**
     * 设置知识浏览地址.
     * @param viewUrl 知识浏览地址.
     */
    public void setViewUrl(String viewUrl) {
        this.viewUrl = viewUrl;
    }

    /**
     * 获取集团知识id.
     * @return jtDocId 集团知识id.
     */
    public String getJtDocId() {
        return jtDocId;
    }

    /**
     * 设置集团知识id.
     * @param jtDocId 集团知识id.
     */
    public void setJtDocId(String jtDocId) {
        this.jtDocId = jtDocId;
    }

    /**
     * 获取所属地市.
     * @return cities 所属地市.
     */
    public String getCities() {
        return cities;
    }

    /**
     * 设置所属地市.
     * @param cities 所属地市.
     */
    public void setCities(String cities) {
        this.cities = cities;
    }

    /**
     * 获取是否创建索引.
     * @return isCreateIndex 是否创建索引.
     */
    public String getIsCreateIndex() {
        return isCreateIndex;
    }

    /**
     * 设置是否创建索引.
     * @param isCreateIndex 是否创建索引.
     */
    public void setIsCreateIndex(String isCreateIndex) {
        this.isCreateIndex = isCreateIndex;
    }

    /**
     * 获取知识渠道id.
     * @return wtChannelId 知识渠道id.
     */
    public String getWtChannelId() {
        return wtChannelId;
    }

    /**
     * 设置知识渠道id.
     * @param wtChannelId 知识渠道id.
     */
    public void setWtChannelId(String wtChannelId) {
        this.wtChannelId = wtChannelId;
    }

    /**
     * 获取知道名称.
     * @return zhidaoChannelid 知道名称.
     */
    public String getZhidaoChannelid() {
        return zhidaoChannelid;
    }

    /**
     * 设置知道名称.
     * @param zhidaoChannelid 知道名称.
     */
    public void setZhidaoChannelid(String zhidaoChannelid) {
        this.zhidaoChannelid = zhidaoChannelid;
    }

    /**
     * 获取channelId
     * @return channelId channelId
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * 设置channelId
     * @param channelId channelId
     */
    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
    
    
    
}
