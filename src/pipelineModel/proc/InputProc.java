package pipelineModel.proc;

import pipelineModel.model.Pipeline;
import pipelineModel.model.Triple;

public class InputProc extends Proc {
	Pipeline line;

	public InputProc(Pipeline line, Proc p) {
		super(null, p);
		this.line = line;
	}

	@Override
	public void perfom() {
		Triple triple = line.getTriple();
		if (isEmpty()) {
			if (!line.isLineFull())
				if (triple != null) {
					addNumbers(triple.getDivident(), triple.getDivision(), triple.getQuotient(), 0);
					line.IncrementCurrentNumber();
				}
		} else {
			sendForward();
		}
	}
}
