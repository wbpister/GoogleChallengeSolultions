
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author Ben Pister
 */
public class SolarPanels {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SolarPanels panels = new SolarPanels();
        
        int[] answerArray = panels.answer(Integer.parseInt(args[0]));
        System.out.print("[");
        for(int i = 0; i < answerArray.length; i++){
            if(i > 0){
                System.out.print(", ");
            }
            System.out.print(answerArray[i] + "");
        }
        System.out.print("]\n");
    }

    private int[] answer(int input){
        //LocalParams
        SolarPanels ms = new SolarPanels();
        int foundNum = 0;
        List<Integer> list = new ArrayList<>();
        
        //Execution Code
        while(input != 0){
            foundNum = ms.findAreaIterativeBool(input);
            list.add(foundNum);
            input-=foundNum;
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    
    private int findAreaIterativeBool(int input){
        //LocalParams
        boolean hasSquareRoot = false;
        int divisor = 1;
        
        //Execution Code
        while(!hasSquareRoot){
            divisor = 1;

            while((double)input / divisor != divisor){
                if((double)input / divisor < divisor){
                    break;
                }
                divisor+=1;
            }
            if((double)input / divisor == divisor){
                hasSquareRoot = true;
                break;
            }
            input-=1;
        }
        return input;
    }
}
