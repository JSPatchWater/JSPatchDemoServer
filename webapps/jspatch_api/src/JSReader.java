
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class JSReader {
	public static String DOC_ROOT = null;
	public static String getDocRoot4Config() throws FileNotFoundException, IOException {
		if (DOC_ROOT != null) {
			if (DOC_ROOT.equals("")) {
				return null;
			} else {
				return DOC_ROOT;
			}
		}
		Properties prop = new Properties();
		prop.load(new FileInputStream(JSReader.class.getResource("/config.properties").getPath())); 
		String docRoot = prop.getProperty("doc-root");
		if (docRoot == null || docRoot.trim().length() == 0) {
			DOC_ROOT = "";
			return null;
		}
		DOC_ROOT = docRoot;
		return DOC_ROOT;
	}
	
	
	public static JsFile getJsPatch(String uri) throws MDFileNotExists, FileNotFoundException, IOException {
		String rootPath = JSReader.getDocRoot4Config();
		String file = null;
		if (rootPath == null) {
			URL url = JSReader.class.getResource(uri);
			if (url == null) {
				throw new MDFileNotExists();
			}
			file = url.getFile();
		} else {
			file = rootPath + uri;
		}
		try {
			return ReadFromFile.readFile(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new MDFileNotExists();
		}
	}
    
	/**
	 * 文件不存在
	 */
	public static class MDFileNotExists extends Exception {

		/**
		 * 
		 */
		private static final long serialVersionUID = -7701467538454493465L;
		
		public MDFileNotExists() { }
	}
}
