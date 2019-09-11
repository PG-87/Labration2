package array;


public class StringList {

    private String [] array;
    private int count;

    public void add(String s){
        if (count > array.length -1){
            //om full, skapa en ny array som är 50% större
            String[] newArray = new String[array.length + (int)(array.length * 0.5) + 1 ];
            //kopiera över den gamla till den nya
            System.arraycopy(array, 0, newArray, 0, array.length);
            //Ta bort den gamla arrayen / hänvisar newArray till den gamla adressen.
            array = newArray;
        }
            array[count] = s;
            count++;
    }

    public StringList(int userSize) {
        array = new String[userSize];
    }

    public StringList() {
        array = new String[10];
    }

    public String getElementAt(int index){
        if (index >= 0)
            return array[index];
        else
            return "Number not in range!";
    }

    public int size(){
        return count;

    }
}
