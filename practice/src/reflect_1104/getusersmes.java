package reflect_1104;

import java.lang.reflect.Field;

public class getusersmes<E> {
    E user;

    public getusersmes(E user) {
        Class c=user.getClass();//获取输入的对象的类
        Field[] f=c.getDeclaredFields();//获取该类下所有成员变量

        for (Field field : f) {
            try {
                field.setAccessible(true);
                System.out.println(field.getName() + "--->" + field.getType()+"--->"+field.get(user));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
