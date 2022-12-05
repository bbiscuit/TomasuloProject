package tomasulogui;

public class BranchUnit
        extends FunctionalUnit {

    public static final int EXEC_CYCLES = 1;

    public BranchUnit(PipelineSimulator sim) {
        super(sim);
    }

    public int calculateResult(int station) {
        // todo fill in
        ReservationStation resStat=stations[station];
        //updateBranchResultFeild() from ReorderBuffer
        
        switch(station){
          case 30:
                //return "BEQ";
              if(resStat.data1 == resStat.data2){
                  //return Lable address+4
              }
              
          case 31:
             // return "BNE";
              if(resStat.data1 != resStat.data2){
                  //return Lable address+4
              }
          case 32:
              //return "BEQ";
              if(resStat.data1 == resStat.data2){
                  //return Lable address+4
              }
          case 33:
              //return "BNE";
              if(resStat.data1 != resStat.data2){
                  //return Lable address+4
              }
          case 34:
              //return "BLTZ";
              if(resStat.data1 < 0){
                  //return Lable address+4
              }
          case 35:
             // return "BLEZ";
              if(resStat.data1 <= 0){
                  //return Lable address+4
              }
          case 36:
              //return "BGTZ";
              if(resStat.data1 > 0){
                  //return Lable address+4
              }
          case 37:
              //return "BGEZ";
              if(resStat.data1 >= 0){
                  //return Lable address+4
              }
          case 38:
             // return "BC1T";
          case 39:
             // return "BC1F";
          case 40:
             // return "J";
              //return Lable address+4
          case 41:
              //return "JR";
              //return Lable address+4
              //And save data in R31
          case 42:
             // return "JAL";
              return resStat.data1;
              
          case 43:
            //  return "JALR";
            return resStat.data1;
            //And save data in R31
          default:
            return -2147483647;
        }
        
    }

    public int getExecCycles() {
        return EXEC_CYCLES;
    }
}
