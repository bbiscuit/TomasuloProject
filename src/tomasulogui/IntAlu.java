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
            // some other operation that I did think of if any
        // update CDB with result of data (possibly tag)    
        
        // return result of calculation
        
        // just placeholder code
        int result = 0;
        return result;
    }

    public int getExecCycles() {
        return EXEC_CYCLES;
    }
}
