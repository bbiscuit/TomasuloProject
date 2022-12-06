package tomasulogui;

public class IntMult extends FunctionalUnit {

    public static final int EXEC_CYCLES = 4;

    public IntMult(PipelineSimulator sim) {
        super(sim);
    }

    public int calculateResult(int station) {
        // assumption that the reservation stations have all data needed
        
        // get contents at specific station
        // if operation is *
            // mult two operands in reservation station
        // else
            // through an exception
        // update CDB (possible reorder buffer/regs individually?) with result 
        // of valid data from the reorder buffer and tag
        
        // (may have race condition on who should write to the CDB if mult and 
        // int units finish at the same time)    
        
        // return result of calculation 
        
        // place holder code
        int result = 0;
        return result;

    }

    public int getExecCycles() {
        return EXEC_CYCLES;
    }
}
