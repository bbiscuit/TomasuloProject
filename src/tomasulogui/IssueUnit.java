package tomasulogui;

public class IssueUnit {

    private enum EXEC_TYPE {
        NONE, LOAD, ALU, MULT, DIV, BRANCH
    };

    PipelineSimulator simulator;
    IssuedInst issuee;
    Object fu;

    Instruction instr;
    int opcode;
    String name;
    
    public IssueUnit(PipelineSimulator sim) {
        simulator = sim;
    }

    public void execCycle() {
        // Dr. G's comments
        // an execution cycle involves:
        // 1. checking if ROB and Reservation Station avail
        if (!(simulator.reorder.isFull()) /*&& simulator.*/) { // do we need to consider hault?
            // 2. issuing to reservation station, if no structural hazard
            // to issue, we make an IssuedInst, filling in what we know
            instr = simulator.memory.getInstAtAddr(simulator.getPC());
            opcode = instr.getOpcode();
            name = Instruction.getNameFromOpcode(opcode);
            issuee = IssuedInst.createIssuedInst(instr);
            // We check the BTB, and put prediction if branch, updating PC
            //     if pred taken, incr PC otherwise
            // Should be good up to here
            // NEED TO FINISH
//            if () {
//                simulator.btb.predictBranch(issuee);
//                if (/*if branch taken*/) {
//                    // update PC
//                    // simulator.setPC();
//                }
//                else {
//                    simulator.pc.incrPC();
//                }
//            }

            // We then send this to the ROB, which fills in the data fields
            // We then check the CDB, and see if it is broadcasting data we need,
            //    so that we can forward during issue
            // We then send this to the FU, who stores in reservation station
        }
        // what do we do if everything is unavailable?
        // halt = true
        // or just return?
    }
}
