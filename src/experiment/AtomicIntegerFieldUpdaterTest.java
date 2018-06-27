package experiment;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @description: 原子更新字段
 * @author: han
 * @create: 2018-06-26 09:41
 **/
public class AtomicIntegerFieldUpdaterTest {
    public static class User{
        private String name;
        public volatile int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }

    private static AtomicIntegerFieldUpdater<User> a=AtomicIntegerFieldUpdater.newUpdater(User.class,"old");

    public static void main(String[] args) {
        User conan=new User("conan",10);
        System.out.println(a.getAndIncrement(conan));
        System.out.println(a.get(conan));
    }
}
