package pipelineModel.proc;

import pipelineModel.methods.AbstractMethod;
import pipelineModel.model.Triple;

public abstract class Proc {
	protected int order;

	protected int divident;
	protected int division;
	protected int quotient;
	protected boolean full;
	private AbstractMethod method;
	protected Proc nextProc;

	public Proc(AbstractMethod m, Proc p) {
		method = m;
		nextProc = p;
	}

	public void perfom() {
		if (full) {
			method.perfom();
			if (nextProc != null)
				sendForward();
		}
	}

	public void addNumbers(Integer a, Integer b, Integer z, int o) {
		divident = a;
		division = b;
		quotient = z;
		order = o;
		full = true;
	}

	public Triple getNumbers() {
		return new Triple(divident, division, quotient);
	}

	public void sendForward() {
		if (nextProc != null) {
			if (!isEmpty())
				if (nextProc.isEmpty()) {
					nextProc.addNumbers(divident, division, quotient, order);
					full = false;
				}
		}
	}

	public boolean isEmpty() {
		return !full;
	}

	protected void setMethod(AbstractMethod m) {
		method = m;
	}
}
