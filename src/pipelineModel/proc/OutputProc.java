package pipelineModel.proc;

import pipelineModel.model.Pipeline;

public class OutputProc extends Proc {

	Pipeline line;

	public OutputProc(Pipeline line) {
		super(null, null);
		this.line = line;
	}

	@Override
	public void perfom() {
		if (!isEmpty()) {
			line.addTriple(super.getNumbers());
			line.DecrementCurrentNumber();
			full = false;
		}
	}
}
