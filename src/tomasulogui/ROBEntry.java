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

  /**
   * Constructor.
   * @param buffer The reorder buffer which this is an entry of.
   */
  public ROBEntry(ReorderBuffer buffer) {
    rob = buffer;
  }

  /**
   * @return True if the instruction in this entry is complete.
   */
  public boolean isComplete() {
    return complete;
  }

  /**
   * Whether or not the instruction is a mispredicted branch, so that the
   * ROB can be flushed.
   * @return True if the branch is a mispredicted branch.
   */
  public boolean branchMispredicted() {
    return mispredicted;
  }

  /**
   * @return True if this is both a branching instructino and is being predicted
   * as taken.
   */
  public boolean getPredictTaken() {
    return predictTaken;
  }

  /**
   * 
   * @return Gets the program counter of the current instruction.
   */
  public int getInstPC() {
    return instPC;
  }

  /**
   * 
   * @return what operation this instruction is (ADD, MUL, LD, etc.)
   */
  public IssuedInst.INST_TYPE getOpcode () {
    return opcode;
  }

  /**
   * 
   * @return True if the instruction loaded is a halt.
   */
  public boolean isHaltOpcode() {
    return (opcode == IssuedInst.INST_TYPE.HALT);
  }

  /**
   * Sets the branch as either taken or not taken, while also updating whether
   * the current prediction was correct.
   * @param result Whther the branch was taken or not.
   */
  public void setBranchTaken(boolean result) {
  // TODO - maybe more than simple set
  }

  /**
   * @return The register being written to by the instruction.
   */
  public int getWriteReg() {
    return writeReg;
  }

  /**
   * @return The value being written by the instruction
   */
  public int getWriteValue() {
    return writeValue;
  }

  /**
   * Sets the value which the instruction is writing.
   * @param value The value to be written by the instruction.
   */
  public void setWriteValue(int value) {
    writeValue = value;
  }

  /**
   * Inserts an instruction into the ROB while updating the fields of the entry.
   * @param inst The instruction to insert into the ROB.
   * @param frontQ The place in the queue the instruction is being inserted
   * (used also as the destination virtual register tag)
   */
  public void copyInstData(IssuedInst inst, int frontQ) {
    instPC = inst.getPC();
    inst.setRegDestTag(frontQ);

    // TODO - This is a long and complicated method, probably the most complex
    // of the project.  It does 2 things:
    // 1. update the instruction, as shown in 2nd line of code above
    // 2. update the fields of the ROBEntry, as shown in the 1st line of code above

  }

}
