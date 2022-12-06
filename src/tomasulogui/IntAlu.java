package tomasulogui;

public class IntAlu extends FunctionalUnit {

    public static final int EXEC_CYCLES = 1;

    public IntAlu(PipelineSimulator sim) {
        super(sim);
    }

    public int calculateResult(int station) {
        // assumption that the reservation stations have all data needed
        
        // get contents at specific station
        // if operation is +
            // add two operands in reservation station
        // else if operatoin is -
            // subtract two operands in reservation station
        // else
            // throw an exception
        // update CDB with result of valid data from the reorder buffer and tag
        // may have race condition like IntMult and may need to update reorder buf
        // and regs file (not sure if this is the same thing as updating the CDB)
        
        // return result of calculation
        
        // just placeholder code
        int result = 0;
        return result;
    }

    public int getExecCycles() {
        // not sure if this is the only thing for this function
        return EXEC_CYCLES;
    }
}
