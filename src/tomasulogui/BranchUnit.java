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
        
        //station is 0 or 1
        // make sure it is not busy before calculating
        //Is Redy function from reservation station
        //MAKE SURE the value is valid.
        // contact reorder buffer directly  and say this is what happend
        //BranchPredictor has lable address info but this function returns as bool taken or not taken
        // 
        // execute cycle will call this function
        // execute cycle  will call function to make sure reservation station is ready
        // and it will also put data in CDB.
        
        //return 1 is true
        //retrun 0 is false
        switch(resStat.function){
          case BEQ:
                //return "BEQ";
              if(resStat.data1 == resStat.data2){
                  return 1;
              }
              return 0;
          case BNE:
             // return "BNE";
              if(resStat.data1 != resStat.data2){
                  return 1;
              }
              return 0;
          //case 32:
              //return "BEQ";
             // if(resStat.data1 == resStat.data2){
                  //return Lable address+4
             // }
          //case 33:
              //return "BNE";
             // if(resStat.data1 != resStat.data2){
                  //return Lable address+4
            //  }
          case BLTZ:
              //return "BLTZ";
              if(resStat.data1 < 0){
                  return 1;
              }
             return 0;
          case BLEZ:
             // return "BLEZ";
              if(resStat.data1 <= 0){
                 return 1;
              }
              return 0;
          case BGTZ:
              //return "BGTZ";
              if(resStat.data1 > 0){
                  return 1;
              }
             return 0;
          case BGEZ:
              //return "BGEZ";
              if(resStat.data1 >= 0){
                  return 1;
              }
              return 0;
         // case 38:
             // return "BC1T";
         // case 39:
             // return "BC1F";
          case J:
             // return "J";
              //return Lable address+4
              return 1;
              
          case JR:
              //return "JR";
              //return Lable address+4
              //And save data in R31
              return 1;
              
          case JAL:
             // return "JAL";
              return 1;
              
              
          case JALR:
            //  return "JALR";
            return resStat.data1;
            //And save data in R31
            
          default:
              //Error statement 
            return -2;
        }
        
    }

    public int getExecCycles() {
        return EXEC_CYCLES;
    }
}
