import java.io.*;
import java.util.*;

/**
 * PackageName com.bj58.bm.web.business.Test
 * Created by wangkang on 2017/6/7.
 */
public class Operation2Txt {
    public static void main(String[] args) {
//        List<String> s = CategoryDeleteUtil.getResult();
//        String file = "C:\\Users\\lenovo\\Desktop\\log\\condition.txt";
//        writeCollection2Txt(s,file);
        System.exit(0);
    }

    public static void safeWrite2Txt(RandomAccessFile file, String content){
        synchronized (file){
            try{
                long fileLength = file.length();
                file.seek(fileLength);
                file.write(content.getBytes());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static List<String> readFromTxt(String txtpath) throws Exception{
        List<String> result = new ArrayList<String>();
        File file = new File(txtpath);
        if(!file.exists()){
            System.out.println("file not exists!");
            return Collections.EMPTY_LIST;
        }
        BufferedReader bf = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = bf.readLine()) != null){
            result.add(line);
        }
        return result;
    }
    public static<E> void writeCollection2Txt(Collection<E> collection,String txtpath){
        try {
            File file = new File(txtpath);
            if(file.exists()){
                file.delete();
            }else{
                file.createNewFile();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            for (E data : collection){
                System.out.println(data);
                output.write(data.toString());
                output.newLine();
            }
            output.flush();
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void writeMap2Txt(Map<Object,Object> map, String txtpath){
        try{
            File file = new File(txtpath);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            BufferedWriter output = new BufferedWriter(new FileWriter(file));
            String content = "";
            for(Map.Entry<Object,Object> entry : map.entrySet()){
                content = entry.getKey() + " | " + entry.getValue();
                System.out.println(content);
                output.write(content);
                output.newLine();
            }
            output.flush();
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
