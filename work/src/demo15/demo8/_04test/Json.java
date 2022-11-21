package demo15.demo8._04test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.ArrayList;

/*
*转为JOSN字符串
 */
public class Json {

    public void josnReverse(ArrayList<Equation> list) throws JsonProcessingException {


        ObjectMapper mapper=new ObjectMapper();
        System.out.println("转为的json字符串如下：");
        for (Equation equation : list) {
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(equation);
            System.out.println(jsonString);//输出转化成的json字符串

            /*
            * 注：json是操作字符串的，在转换为含有非字符串的属性实体类时会出错
            * ERROR:Exception in thread "main" com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException
            * */
            /*ArrayList<Object> arrayList=new ArrayList<>();//将转成的json实体类放到arrayList中
            try {
            JSONObject jsonObject=new JSONObject(jsonString);
            *//* 直接将一个json转换成实体类*//*
            //jsonObject.getString("operate"),用于获取json中的数据元素
            if (jsonObject.getString("operate").equals("+")){
                AddEquation.AddEquationBuilder deserializedEquation=mapper.readValue(jsonString,AddEquation.AddEquationBuilder.class);
                arrayList.add(deserializedEquation);
            }else {
                SubEquation.SubEquationBuilder deserializedEquation=mapper.readValue(jsonString,SubEquation.SubEquationBuilder.class);
                arrayList.add(deserializedEquation);
            }
            } catch (JSONException e) {
            throw new RuntimeException(e);
            }*/
        }

    }
}
