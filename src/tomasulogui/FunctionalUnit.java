package tomasulogui;

public abstract class FunctionalUnit {

    PipelineSimulator simulator;
    ReservationStation[] stations = new ReservationStation[2];

    public FunctionalUnit(PipelineSimulator sim) {
        simulator = sim;
    }

    public void squashAll() {
        // todo fill in
        
        // empty all reservation stations of contents b/c of miss predict
            // empty every operand
            // and all operation field of all reservation stations
    }

    public abstract int calculateResult(int station);

    public abstract int getExecCycles();

    public void execCycle(CDB cdb) {
        //todo - start executing, ask for CDB, etc.
        
        // not sure what this does in here
        
    }

    public void acceptIssue(IssuedInst inst) {
        // todo - fill in reservation station (if available) with data from inst

        // working with/inputs:
            // CDB
            // virtual regs (FP Registers) sources tags or values (operands)
            // operation from inst beign issued
            
        // if execution in ALUs int or mult are complete
            // clear reservation stations of last executed inst and mark as open
                
        // if the reservation station is avaliable load data from the FP registers    
            // load into open adder reservation stations if int
                // update:
                // update/mark current reservation station in use
                // check the source operand fields 
                // if virtual register at tag = busy, wait until oper are avaliable 
                    // assign the reservation station with tag of virutal reg 
                    // that it is waiting on
                // else 
                    // get operand from virtual registers at tag from inst
                    //      OR from (check) CDB if virtual reg at tag is what we need
                    //      instead of getting it from the virtual reg
            // load into open mult reservation stations if mult
                // working with (same as above just for mult reservation stations):
                // update (same as above just for mult reservation stations):
        // else no space
            // stall inst b/c no room in specific reservation station
        
        // NOTES:
            //      if both the int and mult reservation stations are needing
            //          the same value, does it come from CDB or is it first come
            //          first serve with regards to the tag?? (up to the designers?)
            //      Example:
            //          SUB F5 F1 F2    
            //          MUL F3 F2 F4
        // DECIDE: does this functional unit update which virtual regs are busy?
        //         who updates who?
        
        // good video resource https://www.youtube.com/watch?v=jyjE6NHtkiA
    }
}
