package tomasulogui;

public class IntAlu extends FunctionalUnit{
  public static final int EXEC_CYCLES = 1;

  public IntAlu(PipelineSimulator sim) {
    super(sim);
  }


  public int calculateResult(int station) {
     // just placeholder code
    switch(stations[station].function){
          case ADD:
             // return "ADD";
          case ADDI:
              int result = stations[station].data1+stations[station].data2;
              return result;
             // return "ADDI";
          case SUB:
             // return "SUB";
          case MUL:
             // return "MUL";
          case DIV:
             // return "DIV";
          case AND:
              //return "AND";
          case ANDI:
             // return "ANDI";
          case OR:
              //return "OR";
          case ORI:
              //return "ORI";
          case XOR:
              //return "XOR";
          case XORI:
              //return "XORI";
          case SLL:
              //return "SLL";
          case SRL:
              //return "SRL";
    }
            
            
    int result=0;
    return result;
  }

  public int getExecCycles() {
      //check the register is valid.
      // call isValid() from ROBEntry
      // call isBusy() from ReservationStation
      if(stations[0].isBusy()){
          calculateResult(0);
      } else if(stations[1].isBusy()){
          calculateResult(1);
      }
    return EXEC_CYCLES;
  }
}
