package experiment;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @description: 原子更新引用类型
 * @author: han
 * @create: 2018-06-26 09:32
 **/
public class AtomicReferenceTest {
    static class User{
        private String name;
        private int old;

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
    public static AtomicReference<User> atomicUserRef=new AtomicReference<User>();

    public static void main(String[] args) {
        User user=new User("conan",15);
        atomicUserRef.set(user);
        User updateUser=new User("shinichi",17);
        atomicUserRef.compareAndSet(user,updateUser);
        System.out.println(atomicUserRef.get().getName());
        System.out.println(atomicUserRef.get().getOld());
    }
}
