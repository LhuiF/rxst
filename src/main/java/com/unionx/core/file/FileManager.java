package com.unionx.core.file;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;
import com.unionx.core.util.DateUtils;
import com.unionx.core.util.Identities;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Date;

/**
 * 文件管理
 *
 * @author songjunjie
 */
@Service("fileManager")
public class FileManager {
    private Log log = LogFactory.getLog(FileManager.class);
    //默认存储文件的集合名字
    private static final String COLLECTION_NAME = "uploadFile";
    @Resource
    private MongoTemplate mongoTemplate;

    /**
     * 保存图片。保存的时候生成别名(aliases).别名格式是:yyyy/MMdd/shortid.扩展名
     *
     * @param fileMeta
     * @return
     */
    public FileMeta save(FileMeta fileMeta) {
        try {
            DB db = mongoTemplate.getDb();
            // 存储fs的根节点
            GridFS gridFS = new GridFS(db, COLLECTION_NAME);
            GridFSInputFile gfs = gridFS.createFile(fileMeta.getData());
            String id ;
            if (StringUtils.isBlank(fileMeta.getId())) {
                id = Identities.uuid19();
                fileMeta.setId(id);
            } else {
                id = fileMeta.getId();
            }
            gfs.setId(id);
            String ext = FilenameUtils.getExtension(fileMeta.getFilename());
            String path = DateUtils.format(new Date(), "yyyyMMdd");
            String aliases = path  + id + "." + ext;
            gfs.put("aliases", aliases);
            gfs.put("filename", fileMeta.getFilename());
            gfs.put("contentType", fileMeta.getContentType());
            gfs.put("catetory", fileMeta.getCatetory());
            gfs.save();
            fileMeta.setAliases(aliases);
            return fileMeta;
        } catch (Exception e) {
            log.error("保存文件错误", e);
            throw new RuntimeException(e);
        }
    }

    public FileMeta getFile(String id) {
        try {
            DB db = this.mongoTemplate.getDb();
            // 获取fs的根节点
            GridFS gridFS = new GridFS(db, COLLECTION_NAME);
            DBObject query = new BasicDBObject();
            query.put("_id", id);
            GridFSDBFile dbfile = gridFS.findOne(query);
            if (dbfile != null) {
                InputStream in = dbfile.getInputStream();
                String contentType = dbfile.getContentType();
                String filename = (String) dbfile.get("filename");
                String aliases = (String) dbfile.get("aliases");
                byte[] data = IOUtils.toByteArray(in);
                FileMeta fileMeta = new FileMeta();
                fileMeta.setData(data);
                fileMeta.setContentType(contentType);
                fileMeta.setFilename(filename);
                fileMeta.setAliases(aliases);
                return fileMeta;
            }
        } catch (Exception e) {
            log.error("根据id获取文件时出错", e);
            throw new RuntimeException(e);
        }
        return null;
    }

    public FileMeta getFileByAliases(String aliases) {
        try {
            DB db = this.mongoTemplate.getDb();
            // 获取fs的根节点
            GridFS gridFS = new GridFS(db, COLLECTION_NAME);
            DBObject query = new BasicDBObject();
            query.put("aliases", aliases);
            GridFSDBFile dbfile = gridFS.findOne(query);
            if (dbfile != null) {
                InputStream in = dbfile.getInputStream();
                String contentType = dbfile.getContentType();
                byte[] data = IOUtils.toByteArray(in);
                FileMeta fileMeta = new FileMeta();
                fileMeta.setData(data);
                fileMeta.setContentType(contentType);
                return fileMeta;
            }
        } catch (Exception e) {
            log.error("根据别名获取文件时出错", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
