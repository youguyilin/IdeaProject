package algorithm;

/**
 * PackageName: algorithm
 * ClassName: SingleInstance
 * Author: CYP2017
 * Date: 2018/11/12 11:09
 * Description:
 */
class SingleInstance {
}

/**
 * 饿汉模式
 */
class Singleton_EHan{
    //类加载时就初始化
    private static final Singleton_EHan INSTANCE = new Singleton_EHan();
    private Singleton_EHan(){};
    public static Singleton_EHan getInstance(){
        return INSTANCE;
    }
}

/**
 * 懒汉模式（线程不安全）
 */
class Singleton_LanHan{
    private static Singleton_LanHan INSTANCE;
    private Singleton_LanHan(){};
    public static Singleton_LanHan getInstance(){
        if (INSTANCE == null){
            return new Singleton_LanHan();
        }
        return INSTANCE;
    }
    //懒汉式，线程安全模式
//    public static synchronized Singleton_LanHan getInstance(){
//        if (INSTANCE == null){
//            return new Singleton_LanHan();
//        }
//        return INSTANCE;
//    }

}

class Singleton_DooubleCheck{
    //volatile可以使用instance扁郎不会在多线程中存在副本，直接从内存中读取
    //volatile的复制操作后面会有个“内存屏障”，放置读操作被JVM重排到内存屏障之前
    private volatile static Singleton_DooubleCheck INSTANCE;

    private Singleton_DooubleCheck(){}

    public static Singleton_DooubleCheck getInstance(){
        if (INSTANCE == null){
            synchronized (Singleton_DooubleCheck.class){
                if (INSTANCE == null){
                    return new Singleton_DooubleCheck();
                }
            }
        }
        return INSTANCE;
    }
}


/**
 * 静态内部类的形式
 */
class Singleton_StaticInnerClass{
    private static class SingleHolder{
        private static final Singleton_StaticInnerClass INSTANCE = new Singleton_StaticInnerClass();
    }
    private Singleton_StaticInnerClass(){}
    private static Singleton_StaticInnerClass getInstance(){
        return SingleHolder.INSTANCE;
    }
}


enum Singleton{
    INSTACE;
    public static Singleton getInstance(){
        return INSTACE;
    }
}










