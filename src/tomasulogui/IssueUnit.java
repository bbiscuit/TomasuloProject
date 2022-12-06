package tomasulogui;

public class IssueUnit {
  private enum EXEC_TYPE {
    NONE, LOAD, ALU, MULT, DIV, BRANCH} ;

    PipelineSimulator simulator;
    IssuedInst issuee;
    Object fu;

    public IssueUnit(PipelineSimulator sim) {
      simulator = sim;
    }

    public void execCycle() {
      // an execution cycle involves:
      // 1. checking if ROB and Reservation Station avail
      // 2. issuing to reservation station, if no structural hazard

      // to issue, we make an IssuedInst, filling in what we know
      // We check the BTB, and put prediction if branch, updating PC
      //     if pred taken, incr PC otherwise
      // We then send this to the ROB, which fills in the data fields
      // We then check the CDB, and see if it is broadcasting data we need,
      //    so that we can forward during issue

      // We then send this to the FU, who stores in reservation station
      
      // ALGORITHM:
      // 1. Check the conditions for issue.
      // 2. If the conditions have been met, send the instruction to issue
      // to the reorder buffer and the reservation station.
      
      
      // 1. Check the conditions for issue.
      
      boolean mustHalt = simulator.reorder.isFull() || false;
      
      // 2. If the conditions have been met, send the instruction to issue
      // to the reorder buffer and the reservation station.
    }
    
    /**
     * Whether or not the destination to which this instruction should go is
     * full.
     * @param i The instruction.
     * @return True if the destination is full, false if there's space.
     */
    private ReservationStation[] getDestination(Instruction i) {
        // ALGORITH:
        // 1. If this is an ALU instruction, check if the ALU is full.
        // 2. If this is a memory instruction, check if the loader is full.
        // 3. If this is a multiply, check the multiplier.
        // 4. If this is a branch, check the branch unit.
        
        int opc = i.getOpcode();
        
        // 1. If this is an ALU instruction, check if the ALU is full.
        
        boolean isALU =
                opc == Instruction.INST_ADD ||
                opc == Instruction.INST_ADDI ||
                opc == Instruction.INST_SUB ||
                opc == Instruction.INST_AND ||
                opc == Instruction.INST_ANDI ||
                opc == Instruction.INST_OR ||
                opc == Instruction.INST_ORI ||
                opc == Instruction.INST_XOR ||
                opc == Instruction.INST_XORI ||
                opc == Instruction.INST_SLL ||
                opc == Instruction.INST_SRL ||
                opc == Instruction.INST_SRA;
        
        if (isALU) {
            return simulator.alu.stations;
        }
        
        // 2. If this is a memory instruction, check if the loader is full.
        
        boolean isMemory =
                opc == Instruction.INST_LW ||
                opc == Instruction.INST_SW;
        
        if (isMemory) {
            return simulator.loader
        }
        // 3. If this is a multiply, check the multiplier.
        
        boolean 
        
        // 4. If this is a branch, check the branch unit.
    }

  }
