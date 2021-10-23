
public class MinhaThread extends Thread {
    
    private boolean sleep;
    private boolean wait;
    private long    time;

    private int qtd;
    private int fibNum;
    
    public boolean isSleep() {
        return sleep;
    }

    public void setSleep(boolean sleep) {
        this.sleep = sleep;
    }

    public boolean isWait() {
        return wait;
    }

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }    
    
    public MinhaThread(String name, qtd,) {
        this.setName(name);
    }
    
    @Override
    public synchronized void run() {
    	Fibonacci fb = new Fibonacci();
    	fb.fibonacci(MIN_PRIORITY);
        for (int i = 0; i < 2000000; i++) {
            if (this.isSleep()) {
                try {
                    Thread.currentThread().getName();
                    Thread.sleep(this.getTime());
                } catch (InterruptedException ex) { }
            }
            if (this.isWait()) {
                try {     
                    this.wait();
                } catch (InterruptedException ex) { }
            }            
            System.out.println(i + " Thread " + this.getName());
        }
    }    
    
}
