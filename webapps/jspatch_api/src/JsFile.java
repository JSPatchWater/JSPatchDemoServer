import java.io.*;

public class JsFile {
    private String fileName;
    private String body;
    private String md5;
    public JsFile() { }
    public JsFile(String fileName, String body) {
        this.fileName = fileName;
        this.body = body;
        if (this.getBody() != null) {
            this.md5 = ParseMD5.parseStrToMd5L32(this.getBody());
        }
    }
    
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public String getBody() {
        return body;
    }
    public void setBody(String body) {
        this.body = body;
    }
    public String getMd5() {
        if (this.md5 == null) {
            if (this.getBody() != null) {
                this.md5 = ParseMD5.parseStrToMd5L32(this.getBody());
            }
        }
        return md5;
    }
    public void setMd5(String md5) {
        this.md5 = md5;
    }

}
	
