package cn.v5cn.v5cms.entity.wrapper;

/**
 * Created by ZXF-PC1 on 2015/7/2.
 */
public class ZTreeFileNode extends ZTreeNode {

    private String fileUri;
    private int order;
    private boolean open = false;

    public ZTreeFileNode(){
        super();
    }

    public ZTreeFileNode(String name,String fileUri){
        this.name = name;
        this.fileUri = fileUri;
    }
    public ZTreeFileNode(String name,String fileUri,boolean open){
        this(name,fileUri);
        this.open = open;
    }
    public ZTreeFileNode(String name,String fileUri,int order){
        this(name,fileUri);
        this.order = order;
    }

    public String getFileUri() {
        return fileUri;
    }

    public void setFileUri(String fileUri) {
        this.fileUri = fileUri;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
