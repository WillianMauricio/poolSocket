
public class ComandoNew extends Comando {

	private int quantidade;
	private int n;
	
    public ComandoNew(String comando) {
        super(comando);
    }

    @Override
    protected boolean valida() {
        String[] array = this.comando.split(" ");

        if (array.length == 4) {
            try {
                Integer.parseInt(array[2]);
                Integer.parseInt(array[3]);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        }
        return false;
    }
    
    public void init() {    
        if (this.valida()) {
            MinhaThread thread = new MinhaThread(this.comando.split(" ")[1],quantidade, n);
            this.threads.add(thread);
            thread.start();
        } else {
            System.out.println("Comando errado");
        }
    }

}
