package demo15.demo16;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

//习题集序列化成JSON格式
public class ToJson {
    public static void toJson() {

        ObjectMapper mapper = new ObjectMapper();
        //从文件中获取等式
        List<Equation> equations = ArrayListSerialized.deserialize();

        try {
            //将等式序列化成JSON格式
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(equations);
            //输出
            System.out.println(jsonString);
            //把上述json字符串反序列化为List
            List<Equation> equationList = (List<Equation>) mapper.readValue(jsonString, List.class);
            System.out.println(equationList);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
