/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author wbcod
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
        
        SolarPanels ms = new SolarPanels();
        int foundNum = 0;
        List<Integer> list = new ArrayList<>();
        while(input != 0){
            foundNum = ms.findAreaIterativeBool(input);
            list.add(foundNum);
            input-=foundNum;
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }

    
    private int findAreaIterativeBool(int input){
        boolean hasSquareRoot = false;
        int divisor = 1;
        int searchedFor = 1;
        
        while(!hasSquareRoot){
            divisor = 1;

            while((double)input / divisor != divisor){
                searchedFor = divisor;
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
