package cn.v5cn.v5cms.entity.wrapper;

import java.io.Serializable;

/**
 * Created by ZXF-PC1 on 2015/7/2.
 */
public class FileInfo implements Serializable {
    private String id;
    private String name;
    private String size;
    private String type;
    private String modifyDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
