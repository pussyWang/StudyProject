import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by wangkang on 2016/9/3.
 */
public class Operation2Excel {
    public static String outputWithExcel(String outputfile, Map<String,List<List<String>>> data) throws IOException {
        HSSFWorkbook wb = new HSSFWorkbook();
        List<String> sheets = new ArrayList<String>(data.keySet());
        for(String sheetName : sheets) {
            List<List<String>> content = data.get(sheetName);
            HSSFSheet sheet = wb.createSheet(sheetName);
            for (int r_index = 0;r_index < content.size();r_index++) {
                HSSFRow row = sheet.createRow(r_index);
                HSSFCellStyle cellstyle = wb.createCellStyle();
                cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
                cellstyle.setWrapText(true);
                List<String> col = content.get(r_index);
                for(int c_index = 0;c_index < col.size();c_index++){
                    //用户id
                    row.createCell(c_index).setCellStyle(cellstyle);
                    row.createCell(c_index).setCellValue(col.get(c_index));
                }
                sheet.autoSizeColumn(r_index);
            }
        }


        FileOutputStream fileOutputStream = new FileOutputStream(outputfile);
        wb.write(fileOutputStream);
        fileOutputStream.close();
        return outputfile;
    }

    public static void main(String[] args) throws Exception{
        String path = "C:\\Users\\lenovo\\Desktop\\sharelog\\exl\\test.xlsx";
        List<String> sheets = new ArrayList<String>();
        sheets.add("sheets1");
        sheets.add("sheets2");
        sheets.add("sheets3");
       Map<String,List<List<String>>> data = new TreeMap<String, List<List<String>>>();
       for(String sheet : sheets){
           List<List<String>> con = new ArrayList<List<String>>();
           for(int i = 0 ; i < 3;i++){
               List<String> row = new ArrayList<String>();
               for(int j = 0; j < 3 ;j++){
                   row.add(sheet + " " +  (i + i*j));
               }
               con.add(row);
           }
           data.put(sheet,con);
       }
       outputWithExcel(path,data);
       System.exit(0);
    }
}


