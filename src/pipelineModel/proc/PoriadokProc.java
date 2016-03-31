package pipelineModel.proc;

import pipelineModel.methods.AbstractMethod;

public class PoriadokProc extends Proc {
	int g;

	public PoriadokProc(Proc p){
		super(null, p);
		AbstractMethod method = () -> {
			int lastOneDivident = (int) ( Math.log(Integer.highestOneBit(divident))/Math.log(2d));
			int lastOneDivision = (int) (Math.log(Integer.highestOneBit(division)) /Math.log(2d));
			order = lastOneDivident < lastOneDivision ? 0 : lastOneDivident - lastOneDivision;
			division <<= order;
			System.out.println(order);
		};
		setMethod(method);
	}

}
