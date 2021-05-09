public class StackOfDoubles {
    //Implementation based on Sedgewick slide set
    private Double[] data;
    private int N;

    public StackOfDoubles(){
        data = new Double[10];
        N = 0;
    }

   public void push (Double data){
    if(N >= this.data.length){
        resize(this.data.length * 2);
    }
    this.data[N]= data;
    N += 1;
   }

   public void resize(int factor){
       Double[] dup = new Double[factor];
       for(int i=0; i<N; i++){
           dup[i] = data[i];
       }
       data = dup;
   }

   public Double pop(){
       if(N>0) {
           Double data = this.data[N - 1];
           this.data[N - 1] = null;
           N -= 1;

           if (N == (this.data.length) / 4) {
               resize((this.data.length) / 2);
           }

           return data;
       }else{
           System.out.println("Stack under flow");
           return null;
       }

   }

    public boolean isEmpty(){

        return N == 0;
    }

    public int getSize(){

        return this.N;
    }
}
