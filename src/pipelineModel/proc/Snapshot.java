package pipelineModel.proc;

import pipelineModel.model.Pipeline;

public class Snapshot {
	Pipeline line;
	public Snapshot(Pipeline line) {
		this.line = line;
	}
	
	@Override
	public String toString() {
		String s = new String();
		for(Proc proc :line.getLine()){
			s +=proc.getNumbers().toString() + '\n';
		}
		return s;
	}
}
