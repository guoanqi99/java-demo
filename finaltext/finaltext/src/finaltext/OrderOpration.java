package finaltext;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class OrderOpration {
    //存储订单信息的集合
    static ArrayList<Order> orders=new ArrayList<>();

    //提取订单信息，并封装进集合
    public static void extract() throws Exception {
        //创建一个Dom4j框架提供的解析器对象
        SAXReader saxReader=new SAXReader();
        //读取xml文件
        Document document=saxReader.read("C://Users//91618//Desktop//text//orders.xml");
        //获取根元素
        Element date=document.getRootElement();
        //获取根元素下所有子元素
        List<Element> child=date.elements();
        //遍历元素得到属性
        try {
            for (Element element : child) {
                //提取出4个元素
                int id=Integer.parseInt(element.attributeValue("id"));
                String name=element.elementText("name");
                String time1=element.elementText("time");
                Double price=Double.parseDouble(element.elementText("double"));
                //将String类型时间转化为Localdatetime
                DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//格式器
                LocalDateTime time = LocalDateTime.parse(time1, formatter);
                Order order=new Order(id,name,time,price);
                orders.add(order);
                System.out.println(order.toString());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    //用stream查找今天之前的订单，并遍历输出
    public static void search() {
        LocalDateTime now = LocalDateTime.now();//获取今日时间
        orders.stream().filter(s->s.getTime().isBefore(now)).forEach(s->System.out.println(s));
    }

    //用stream查找价格最贵的订单，并打印出来
   public static void expensive(){

       orders.stream().sorted(new Comparator<Order>() {
           @Override
           public int compare(Order o1, Order o2) {
               return Double.compare(o1.getPrice(),o2.getPrice());
           }
       }).skip(orders.size()-1).forEach(s->System.out.println(s.toString()));
   }
   //按照价格降序输出订单详情
    public static void jiangxu(){

        orders.stream().sorted((o1,o2)->Double.compare(o2.getPrice(),o1.getPrice())
        ).forEach(System.out::println);
    }
}

