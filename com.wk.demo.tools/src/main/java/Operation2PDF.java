import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.parser.PdfTextExtractor;

import java.io.IOException;

/**
 * PackageName PACKAGE_NAME
 * Created by wangkang on 2017/10/16.
 */
public class Operation2PDF {
    public static void main(String[] args) throws IOException {
        String pdfpath = "D:\\工具书\\算法\\哲学问题罗素.pdf";
        getPdfFileText(pdfpath);
        System.exit(0);
    }

    public static String getPdfFileText(String pdfPath) throws IOException {
        // 读取pdf所使用的输出流
        //PrintWriter writer = null;
        PdfReader reader = null;
        //writer = new PrintWriter(new FileOutputStream(txtfilePath));
        reader = new PdfReader(pdfPath);
        int num = reader.getNumberOfPages();// 获得页数
        System.out.println("Total Page: " + num);
        String content = ""; // 存放读取出的文档内容
        for (int i = 1; i <= num; i++) {
            // 读取第i页的文档内容
            content = (new  PdfTextExtractor(reader)).getTextFromPage(i);
            System.out.println("content: " + content);
        }
//        String[] arr = content.split("/n");
//        for(int i=0;i<arr.length;i++) {
//            System.out.println(arr[i]);
//            writer.write(content);// 写入文件内容
//            writer.flush();
//            writer.close();
//        }
        return "";
    }
}
