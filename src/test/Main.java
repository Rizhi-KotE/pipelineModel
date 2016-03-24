package test;

import java.util.LinkedList;

import pipelineModel.model.Pipeline;
import pipelineModel.model.Triple;

public class Main {
	public static void main(String[] args) {
		LinkedList<Triple> inFail = new LinkedList<>();
		LinkedList<Triple> outFail = new LinkedList<>();
		int ErrorCount = 0;
		while (ErrorCount < 5) {
			Pipeline line = new Pipeline(1, 1, 4);
			Triple in = null;
			for (Triple trip : line.getInput()) {
				in = trip;
			}
			line.run();
			Triple out = null;
			for (Triple trip : line.getResult()) {
				out = trip;
			}
			if ((int) (in.getDivident() / in.getDivision()) != (out.getQuotient())) {
				inFail.add(in);
				outFail.add(out);
				ErrorCount++;
			}
		}
		for (

		Triple trip1 : inFail)

		{
			System.out.println(trip1);
		}
		System.out.println("-------------");
		for (

		Triple trip1 : outFail)

		{
			System.out.println(trip1);
		}
	}
}
