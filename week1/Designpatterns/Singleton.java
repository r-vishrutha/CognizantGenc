class Logger{
    private static Logger instance;
    private Logger(){
        System.out.println("Instance created");
    }
    public static Logger getInstance(){
        if(instance==null){
            instance=new Logger();
        }
        return instance;
    }
    public void show(){
        System.out.println("Hello from Logger");
    }
}

public class Singleton{
    public static void main(String args[]){
        Logger log1=Logger.getInstance();
        Logger log2=Logger.getInstance();;
        log1.show();
        log2.show();
        if(log1==log2){
            System.out.println("Same logger instance is used");
        }
        else{
            System.out.println("Different logger instances are used");;
        }
    }
}