package test.demo16; 

import demo16.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* ArrayListSerialized Tester. 
* 
* @author 202018123钟勇成
* @since <pre>11/21/2022</pre> 
* @version 1.0 
*/ 
public class ArrayListSerializedTest {
    EquationRangeChecker checker = null;
    List<Equation> deserialize = null;

    @Before
    public void before() throws Exception {
        checker = new EquationRangeChecker(0, 100);
        //生成等式
        EquationGenerator.generate(10,checker);
    }

    /**
    *
    * Method: serialize(List<Equation> equations)
    * 测试序列化
    */
    @Test
    public void testSerialize() throws Exception {
    //TODO: Test goes here...
        //测试序列化
        ArrayListSerialized.serialize(EquationGenerator.equations);
    }

    /**
    *
    * Method: deserialize()
    * 测试反序列化
    */
    @Test
    public void testDeserialize() throws Exception {
    //TODO: Test goes here...
        deserialize = ArrayListSerialized.deserialize();
        for (var x : deserialize) {
            Assert.assertTrue(checker.check(x));
            System.out.println(x);
        }
    }


} 
