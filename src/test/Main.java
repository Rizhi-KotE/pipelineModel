package test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import pipelineModel.model.Pipeline;
import pipelineModel.model.Pipeline.Vector;
import pipelineModel.model.Triple;

public class Main {
	public static void main(String[] args) {
		LinkedList<Triple> inFail = new LinkedList<>();
		LinkedList<Triple> outFail = new LinkedList<>();
		int ErrorCount = 0;
		while (ErrorCount < 5) {
			Pipeline line = new Pipeline(5, 2, 4);
			List<Triple> in = line.getInput();
			line.run();
			List<Triple> out = line.getResult();
			ListIterator<Triple> it = in.listIterator();
			while(it.hasNext()){
				int index = it.nextIndex();
				if((in.get(index).getDivident()/in.get(index).getDivision()==in.get(index).getQuotient())){
					ErrorCount++;
				}
				it.next();
			}
		}
	}
}
