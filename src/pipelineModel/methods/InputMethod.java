package pipelineModel.methods;

import pipelineModel.model.Pipeline;
import pipelineModel.model.Triple;
import pipelineModel.proc.InputProc;

public class InputMethod implements AbstractMethod {

	Pipeline line;
	InputProc proc;

	public InputMethod(Pipeline p, InputProc proc) {
		line = p;
		this.proc = proc;
	}

	@Override
	public void perfom() {
		
	}

}
