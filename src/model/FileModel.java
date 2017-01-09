package model;

/**
 * Created by Krzysztof on 2017-01-07.
 */
public class FileModel {
    private String path;
    private String name;
    private String fileContent;
    private String fileContentBeforeSave;
    private Boolean isSaved;
    private String fileOperation;

    private static FileModel fileModel;

    private FileModel(){
        this.path = "Default path";
        this.name = "Untitled";
        this.fileContent = "";
        this.fileContentBeforeSave = "";
        this.isSaved = false;
        this.fileOperation = "Undefined";
    }

    private FileModel(String path,String name, String fileContent, String fileContentBeforeSave, Boolean isSaved){
        this.path = path;
        this.name = name;
        this.fileContent = fileContent;
        this.fileContent = fileContentBeforeSave;
        this.isSaved = isSaved;
    }

    public static FileModel getInstace(){
        if (fileModel == null){
            fileModel = new FileModel();
        }
        return  fileModel;
    }

    public void setFileOperation(String fileOperation) {
        this.fileOperation = fileOperation;
    }

    public void setAllFields(String path,String name, String fileContentBeforeSave, Boolean isSaved){
        this.path = path;
        this.name = name;
        this.fileContent = fileContentBeforeSave;
        this.isSaved = isSaved;
    }

    public void isSaved(){
        if (fileContent.equals(fileContentBeforeSave)){
            this.isSaved = true;
        }
        else{
            this.isSaved = false;
        }
    }

    public void setDefaultSettings(){
        this.name = "Untitled";
        this.path = "Default path";
        this.fileContent = "";
        this.fileContentBeforeSave = "";
        this.isSaved = false;
    }


    //-------------SETTERS--------------

    public void setName(String name) {
        this.name = name;
    }

    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }

    public void setFileContentBeforeSave(String fileContentBeforeSave) {
        this.fileContentBeforeSave = fileContentBeforeSave;
    }

    public void setPath(String path) {
        this.path = path;
    }



    //--------------GETTERS-----------------

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public String getFileContent() {
        return fileContent;
    }

    public String getFileContentBeforeSave() {
        return fileContentBeforeSave;
    }

    public Boolean getIsSaved() {
        return isSaved;
    }

    public static FileModel getFileModel() {
        return fileModel;
    }

    public String getOperation() {
        return fileOperation;
    }

    public void setIsSaved() {
        isSaved = true;
    }
}
