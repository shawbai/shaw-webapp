package com.shaw.blog.utils.qiniu;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.BatchStatus;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.util.Auth;


public class QiNiuUtil {
	
    private static QiNiuUtil instance = new QiNiuUtil();
    private UploadManager uploadManager;
    private Auth auth;
    private static Configuration cfg;

    public static QiNiuUtil getInstance() {
        return instance;
    }

	
	private QiNiuUtil() {
        String aliyun_accessId = "olaOYXT8B9rI3g0ipzIxYptYOaG2yEsCwPD-uB4y";//QiNiuPropertiesUtil.readStringValue(QiNiuPropKey.qiniu_accessKey);
        String aliyun_accessKey = "cB3RW55BPaLWV2tPV__3tJZafxj0pjO4chRZTxUR";//QiNiuPropertiesUtil.readStringValue(QiNiuPropKey.qiniu_secretKey);
		auth = Auth.create(aliyun_accessId, aliyun_accessKey);
		cfg = new Configuration(Zone.zone0());
		uploadManager = new UploadManager(cfg);
    }
	
	/**
	 * 
	 * @param localFilePath  本地路径
	 * @param key 上传文件保存的文件名
	 * @param bucket 上传凭证 存储空间名
	 * @return 
	 */
    public String uploadLocalFile(String localFilePath,String key,String bucket) {
    	
    	String upToken = auth.uploadToken(bucket);
    	try {
    	    Response response = uploadManager.put(localFilePath, key, upToken);
    	    //解析上传成功的结果
    	    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
    	    System.out.println(putRet.key);
    	    System.out.println(putRet.hash);
    	    return putRet.key;
    	} catch (QiniuException ex) {
    	    Response r = ex.response;
    	    System.err.println(r.toString());
    	    try {
    	        System.err.println(r.bodyString());
    	    } catch (QiniuException ex2) {
    	        //ignore
    	    }
    	}
        return "";
    }
    
    
    /**
	 * @param content  文件流
	 * @param key 上传文件保存的文件名
	 * @param bucket 上传凭证 存储空间名
     */
    public String uploadFile(InputStream content,String key,String bucket) {
    	 String upToken = auth.uploadToken(bucket);
		try {
		    Response response = uploadManager.put(content,key,upToken,null, null);
		    //解析上传成功的结果
		    DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		    return putRet.key;
		} catch (QiniuException ex) {
		    Response r = ex.response;
		    System.err.println(r.toString());
		    try {
		        System.err.println(r.bodyString());
		    } catch (QiniuException ex2) {
		        //ignore
		    }
		}
    	return "";
    }
    
   
    /**
     *  上传整个资源目录
     * @param tmpPath  临时路径 
     * @param absolutePath  本地绝对路径 入参时与临时路径相同
     * @param bucket
     */
    public void uploadRecursively(String tmpPath,String absolutePath,String bucket) {
    	File[] files = new File(tmpPath).listFiles();
        if (files != null) {
            for (File file : files)
                if (file.isDirectory()) {
                    if (file.isHidden()) continue;
                    uploadRecursively(file.toString(),absolutePath,bucket);
                } else {
                    String replace = file
                            .toString()
                            .substring(absolutePath.length(),
                                    file.toString().length())
                            .replace("\\", "/");
                    String key = replace.substring(1, replace.length());    // 去掉路径前的一个/
                    uploadLocalFile(file.toString(),key,bucket);
//                    System.out.println(file.getName().toString()+" "+key);
                }
        }
    }
    public void delAllFile(String bucket,String[] keyList){
    
    BucketManager bucketManager = new BucketManager(auth, cfg);
    try {
        //单次批量请求的文件数量不得超过1000
        BucketManager.Batch batchOperations = new BucketManager.Batch();
        batchOperations.delete(bucket, keyList);
        Response response = bucketManager.batch(batchOperations);
        BatchStatus[] batchStatusList = response.jsonToObject(BatchStatus[].class);
        for (int i = 0; i < keyList.length; i++) {
            BatchStatus status = batchStatusList[i];
            String key = keyList[i];
            System.out.print(key + "\t");
            if (status.code == 200) {
                System.out.println("delete success");
            } else {
                System.out.println(status);
            }
        }
    } catch (QiniuException ex) {
        System.err.println(ex.response.toString());
    }
    
    }
    /**
     * 获取空间文件
     * @param prefix 文件名前缀
     * @param bucket 空间名
     * @param delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
     */
    public String[] getAllFile(String prefix,String delimiter,String bucket){
    	ArrayList<String> keyList = new ArrayList<String>();
    	BucketManager bucketManager = new BucketManager(auth, cfg);
    	//每次迭代的长度限制，最大1000，推荐值 1000
    	int limit = 1000;
    	//列举空间文件列表
    	BucketManager.FileListIterator fileListIterator = bucketManager.createFileListIterator(bucket, prefix, limit, delimiter);
    	while (fileListIterator.hasNext()) {
    	    //处理获取的file list结果
    	    FileInfo[] items = fileListIterator.next();
    	    for (FileInfo item : items) {
//    	        System.out.println("item.key:"+item.key);
    	        keyList.add(item.key);
    	        
    	    }
    	}
    	keyList.add("index.html");
    	String[] keyStr =new String[keyList.size()];
    	return keyList.toArray(keyStr);
    }
    
	public static void main(String[] args) throws FileNotFoundException {
//		System.out.println(QiNiuUtil.getInstance().uploadLocalFile("D:\\用户目录\\下载\\ftpm_112_bwx\\media\\image\\bg\\2.jpg","imges/2.jpg","myblog"));
//		File f = new File("D:\\用户目录\\下载\\ftpm_112_bwx\\media\\image\\bg\\2.jpg");
//		System.out.println(f.toString());
//		InputStream in = new FileInputStream(f);
//		QiNiuUtil.getInstance().uploadFile(in,null,"myblog");
		String[] keyList = QiNiuUtil.getInstance().getAllFile("static","\\","myblog");
		for (String str : keyList) {
		System.out.println(str);
	}
	QiNiuUtil.getInstance().delAllFile("myblog", keyList);
		String path = "E:\\workspace\\shaw-webapp\\src\\main\\webapp\\dist";
		QiNiuUtil.getInstance().uploadRecursively(path,path,"myblog");

	}
}
