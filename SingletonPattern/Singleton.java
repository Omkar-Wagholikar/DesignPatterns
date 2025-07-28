class SingletonLogger {
    static int total = 0;
    static SingletonLogger obj; // This is the lazy implementation
    // This is the eager implementation: 
    // static Singleton obj = new Singleton();
    private SingletonLogger() {
        System.out.println("Object created");
        SingletonLogger.total += 1;
        if (obj != null) {
            // This protects against serialization and reflection based attacks.
            throw new RuntimeException("Use getInstance()");
        }
    }

    public static SingletonLogger getInstance() {
        if(obj == null) {
            synchronized (SingletonLogger.class) {
                if(obj == null) obj = new SingletonLogger();
            }
        }
        return obj;
    }

    public static void totalObjects() {
        System.out.println("Total object: " + SingletonLogger.total);
    }
}
public class Singleton {
    public static void main(String[] args) {
        SingletonLogger obj = SingletonLogger.getInstance();
        SingletonLogger.totalObjects();

        SingletonLogger obj1 = SingletonLogger.getInstance();
        SingletonLogger.totalObjects();
        
    }
}