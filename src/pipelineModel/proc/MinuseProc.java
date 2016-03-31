package pipelineModel.proc;

import pipelineModel.methods.AbstractMethod;

public class MinuseProc extends Proc {

	public MinuseProc(Proc p) {
		super(null, p);
		AbstractMethod method = () -> {
			int result = ((quotient & 1) != 0) ? divident - division : divident + division;
			quotient = order != 0 ? (quotient << 1) | (result < 0 ? 0 : 1) : quotient;
			divident = order != 0 ? result < 0 ? -(Math.abs(result) << 1) : (Math.abs(result) << 1) : divident;
			order = order != 0 ? --order : order;
		};
		setMethod(method);
	}
}
