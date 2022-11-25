package tomasulogui;

/**
 * The reoder buffer is the "retire queue" of Tomasulo's algorithm. The ROB,
 * therefore, is Tomasulo's answer to precise exceptions and control hazards.
 * 
 * Retirement in Tomasulo's algorithm is an in-order process; it is the
 * ROB's job to ensure that retirement happens in-order, that way there is no
 * dependency issues when writing to the register file.
 * 
 * This is how the reorder buffer operates with Tomasulo's, per slide 69 of
 * the Chapter 3 Slideshow:
 * 1. Issue / Dispatch
 *    - Issue conditions
 *       - Must be a slot in the the reservation station AND the ROB
 *    - Operand Read
 *       Either...
 *       1. From ROB itself
 *       2. From reg file
 *       3. If the data isn't available at the moment of issue, then read
 *       "ROB #" (60% confident that this refers to setting up a tag to
 *       snoop for, since the data is, in this scenario, being calculated
 *       and written to a tag).
 * 2. Exec
 *    - ROB doesn't do anything here
 * 3. Writeback
 *    - Whenever something is written back, the ROB will snoop on the CDB
 *    to see if it was waiting for that value's tag
 * 4. Commit
 *    - Update register file if the result is a register.
 *    - Execute memory operation if the operation was a store.
 *    - Flush the ROB if the operation is a mispredicted branch.
 *    - Flush the ROB if an exception (not something we need to worry about
 *    for this project)
 * 
 * From slide 68 of the Chapter 3 Slideshow, an ALU instruction requires 6
 * fields in the reorder buffer (note, that these are for ALU instructions.
 * While this covers most of what is necessary for loads, stores, and branches,
 * it is not exhaustive). These will not be implemented in this class (rather,
 * they will be handled in the ROBEntry class), but they are crucial to
 * understanding ROB operation, so the comments are likewise included here:
 * 1. Busy
 *    - Whether the instruction has been issued or not (50% confident --
 *    why would an instruction be in the ROB if it hasn't issued?)
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
public class ReorderBuffer {
  public static final int size = 30;
  int frontQ = 0;
  int rearQ = 0;
  ROBEntry[] buff = new ROBEntry[size];
  int numRetirees = 0;

  PipelineSimulator simulator;
  RegisterFile regs;
  boolean halted = false;

  public ReorderBuffer(PipelineSimulator sim, RegisterFile registers) {
    simulator = sim;
    regs = registers;
  }

  public ROBEntry getEntryByTag(int tag) {
    return buff[tag];
  }

  public int getInstPC(int tag) {
    return buff[tag].getInstPC();
  }

  public boolean isHalted() {
    return halted;
  }

  public boolean isFull() {
    return (frontQ == rearQ && buff[frontQ] != null);
  }

  public int getNumRetirees() {
    return numRetirees;
  }

  public boolean retireInst() {
    // 3 cases
    // 1. regular reg dest inst
    // 2. isBranch w/ mispredict
    // 3. isStore
    ROBEntry retiree = buff[frontQ];

    if (retiree == null) {
      return false;
    }

    if (retiree.isHaltOpcode()) {
      halted = true;
      return true;
    }

    boolean shouldAdvance = true;

    // TODO - this is where you look at the type of instruction and
    // figure out how to retire it properly

      // if mispredict branch, won't do normal advance
      if (shouldAdvance) {
        numRetirees++;
        buff[frontQ] = null;
        frontQ = (frontQ + 1) % size;
      }

    return false;
  }

  public void readCDB(CDB cdb) {
    // check entire CDB for someone waiting on this data
    // could be destination reg
    // could be store address source

    // TODO body of method
  }

  public void updateInstForIssue(IssuedInst inst) {
    // the task is to simply annotate the register fields
    // the dest reg will be assigned a tag, which is just our slot#
    // all src regs will either be assigned a tag, read from reg, or forwarded from ROB

    // TODO - possibly nothing if you use my model
    // I use the call to copyInstData below to do 2 things:
    // 1. update the Issued Inst
    // 2. fill in the ROB entry

    // first get a ROB slot
    if (buff[rearQ] != null) {
      throw new MIPSException("updateInstForIssue: no ROB slot avail");
    }
    ROBEntry newEntry = new ROBEntry(this);
    buff[rearQ] = newEntry;
    newEntry.copyInstData(inst, rearQ);

    rearQ = (rearQ + 1) % size;
  }

  public int getTagForReg(int regNum) {
    return (regs.getSlotForReg(regNum));
  }

  public int getDataForReg(int regNum) {
    return (regs.getReg(regNum));
  }

  public void setTagForReg(int regNum, int tag) {
    regs.setSlotForReg(regNum, tag);
  }

}
