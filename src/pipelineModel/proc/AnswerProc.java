package pipelineModel.proc;

import pipelineModel.methods.AbstractMethod;
import pipelineModel.model.Pipeline;

public class AnswerProc extends Proc{

	Pipeline line;
	public AnswerProc(Pipeline line, Proc p){
		super(null, p);
		this.line = line;
		AbstractMethod method = () -> {
			System.out.println(new Snapshot(line));
		};
		setMethod(method);
	}

}
