import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by aloneboy on 2017/12/9.
 */
public class InvokeHelper {
    public static <T> T invokeEntity(Class<T> clazz, Map<String,Object> fieldsMap) throws Exception{
        T entity = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length > 0){
            for (Field f : fields){
                f.setAccessible(true);
                String fieldsName = f.getName();
                Object value = fieldsMap.get(fieldsName);
                if (value.getClass() == f.getGenericType()||
                        value.getClass().toString().toLowerCase().contains(f.getGenericType().toString())){
                    f.set(entity,value);
                }else{
                    throw new Exception("value type:" + value.getClass() + " and need type:" + f.getGenericType());
                }
            }
        }
        return entity;
    }

    private static <T> void showEntity(T t) throws Exception{
        Field[] fields = t.getClass().getDeclaredFields();
        if (fields.length > 0){
            for (Field f : fields){
                f.setAccessible(true);
                System.out.println(f.getName() + ":" + f.get(t));
            }
        }
    }
    public static void main(String[] args)  throws Exception{
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("id",3131241341341l);
        map.put("infoid",3131);
        map.put("businessid",(short)2);
        map.put("money",23423.45f);
        map.put("salary",2432.555545);
        map.put("title","this is test");
        map.put("date",new Date());

        CollectEntity entity = invokeEntity(CollectEntity.class,map);
        showEntity(entity);
        System.exit(0);
    }
}
