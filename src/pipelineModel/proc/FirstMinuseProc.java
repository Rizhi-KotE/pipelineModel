package pipelineModel.proc;

import pipelineModel.methods.AbstractMethod;

public class FirstMinuseProc extends Proc {
	public FirstMinuseProc(Proc proc) {
		super(null, proc);
		AbstractMethod method = () -> {
			int result = divident - division;
			quotient = (quotient << 1) | (result < 0 ? 0 : 1);
			divident = result < 0 ? -(Math.abs(result) << 1) : (Math.abs(result) << 1);
		};
		setMethod(method);
	}
}
