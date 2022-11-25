package tomasulogui;

/**
 * An entry in the reorder buffer queue.
 * 
 * From slide 68 of the Chapter 3 Slideshow, an ALU instruction requires 6
 * fields in the reorder buffer (note, that these are for ALU instructions.
 * While this covers most of what is necessary for loads, stores, and branches,
 * it is not exhaustive):
 * 1. Busy
 *    - I'm not sure what this means
 * 2. Instruction Type
 *    - This refers to whether this is a register instruction, store, or branch.
 * 3. State
 *    - Currently complete
 *    - Currently executing
 * 4. Destination
 *    - Register number, for ALU operations and loads
 *       - Loads fall into this category, of course, because they write to
 *       register.
 *    - Address, for stores
 * 5. Value
 *    - The result of an operation or memory read
 * 6. Tag
 *    - The virtual register to snoop for on the CDB
 *    - This, then, refers to operands (60% confident).
 */
public class ROBEntry {
  ReorderBuffer rob;

  // TODO - add many more fields into entry
  // I deleted most, and only kept those necessary to compile GUI
  boolean complete = false;
  boolean predictTaken = false;
  boolean mispredicted = false;
  int instPC = -1;
  int writeReg = -1;
  int writeValue = -1;

  IssuedInst.INST_TYPE opcode;

  public ROBEntry(ReorderBuffer buffer) {
    rob = buffer;
  }

  public boolean isComplete() {
    return complete;
  }

  public boolean branchMispredicted() {
    return mispredicted;
  }

  public boolean getPredictTaken() {
    return predictTaken;
  }

  public int getInstPC() {
    return instPC;
  }

  public IssuedInst.INST_TYPE getOpcode () {
    return opcode;
  }


  public boolean isHaltOpcode() {
    return (opcode == IssuedInst.INST_TYPE.HALT);
  }

  public void setBranchTaken(boolean result) {
  // TODO - maybe more than simple set
  }

  public int getWriteReg() {
    return writeReg;
  }

  public int getWriteValue() {
    return writeValue;
  }

  public void setWriteValue(int value) {
    writeValue = value;
  }

  public void copyInstData(IssuedInst inst, int frontQ) {
    instPC = inst.getPC();
    inst.setRegDestTag(frontQ);

    // TODO - This is a long and complicated method, probably the most complex
    // of the project.  It does 2 things:
    // 1. update the instruction, as shown in 2nd line of code above
    // 2. update the fields of the ROBEntry, as shown in the 1st line of code above

  }

}
