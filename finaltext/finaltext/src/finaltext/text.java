package finaltext;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public  class text {
    @BeforeClass
     //测试类 无参 无返回值  公共
    public static  void  extractText() throws Exception {
        OrderOpration.extract();
        //OrderOpration.search();
        //OrderOpration.expensive();
    }
    @Test
    public void  searchText() {
        OrderOpration.search();
    }

    @Test
    public void  expensiveText() {
        OrderOpration.expensive();
    }
    @Test
    public void  jiangxuText() {
        OrderOpration.jiangxu();
    }
}
