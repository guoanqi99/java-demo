package finaltext3;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class IO_Systemmanu {
    public static void main(String[] args) throws Exception {
        //创建一个文件字符输入流
        Reader fr=new FileReader("C:\\Users\\91618\\Desktop\\text\\Systemmanu.txt");
        //创建一个文件字符缓冲输入流
        BufferedReader bf=new BufferedReader(fr);
        //这里用打印流更好
        Writer writer=new FileWriter("C:\\Users\\91618\\Desktop\\text\\Systemmanu.txt1");

        BufferedWriter wf=new BufferedWriter(writer);

        String line;
        ArrayList<String> as=new ArrayList<>();
        while ((line=bf.readLine())!=null) {
            as.add(line);
        }
        String symbol="-";
        //对as中字符串排序
        List<String> bs=as.stream().sorted().collect(Collectors.toList());
        //控制台输出数据
        bs.forEach(s -> {
            int a=s.indexOf("-");
            String b=s.substring(a+1);
            System.out.println(b);
        });

        int i=0;
        String shu;
        while (i<bs.size()) {
            shu=bs.get(i);
            wf.write(shu);
            wf.newLine();
            i++;
            wf.flush();
        }

        writer.close();
        fr.close();
    }
}
