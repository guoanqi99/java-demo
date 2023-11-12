package finaltext2;

import java.util.*;
import java.util.stream.Collectors;

public class tour {
    Map<String,Integer>  de=new HashMap<>();//存储投票结果
    ArrayList<user> list=new ArrayList<>();//存贮投票信息

    String fd="";//最终地点

    //初始化地点名单
    public tour() {
        de.put("农家乐",0);
        de.put("轰趴",0);
        de.put("野外拓展",0);
        de.put("健身房",0);
    }
    //投票
    public void vote(){
        //学生投票
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入你的名字");
        String name= sc.next();
        //选择地点
        ArrayList<String> de=new ArrayList<>();
        while (true) {
            System.out.println("请输入您选择的地点，按#退出");
            String des = sc.next();
            if (des.equals("#"))
                break;
            else if(des.equals("农家乐")||des.equals("轰趴")||des.equals("野外拓展")||des.equals("健身房"))
                de.add(des);
            else
                System.out.println("您输入的选择有误，请重新输入");
        }
        user u=new user(name,de);//一个学生投票完毕
        list.add(u);//结果添加进投票信息
    }
    //统计投票结果
    public void statistics(){
        for (user user : list) {
            for (String s : user.getDestination()) {
                if(s.equals("农家乐")) {
                    int a=de.get("农家乐");
                    de.put("农家乐",a+1);

                }
                if(s.equals("轰趴")) {
                    int a=de.get("轰趴");
                    de.put("轰趴",a+1);
                }
                if(s.equals("野外拓展")) {
                    int a=de.get("野外拓展");
                    de.put("野外拓展",a+1);
                }
                if(s.equals("健身房")) {
                    int a=de.get("健身房");
                    de.put("健身房",a+1);
                }
            }
        }
        //获取所有键
        Set<String> keys=de.keySet();
        Integer a=0;
        for (String key : keys) {
            Integer b=de.get(key);
            if (b>a){
                a=b;
            fd=key;
            }
            System.out.println("地点" + key + "人数" + b);
        }
        System.out.println("投票最多的地点是"+fd);
    }
    //找出谁没有选择最终地点
    public void names(){
        ArrayList<user> a=new ArrayList<>();
        for (user user : list) {
            boolean t=false;
            for (String s : user.getDestination()) {
                if(s.equals(fd)){
                    t=true;
                    break;}
            }
            if (t==false){
             a.add(user);
            }
        }
        a.forEach(s->System.out.println(s.name));
    }
}
