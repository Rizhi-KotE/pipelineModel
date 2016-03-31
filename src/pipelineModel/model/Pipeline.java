package pipelineModel.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import pipelineModel.proc.AnswerProc;
import pipelineModel.proc.FirstMinuseProc;
import pipelineModel.proc.InputProc;
import pipelineModel.proc.MinuseProc;
import pipelineModel.proc.OutputProc;
import pipelineModel.proc.PoriadokProc;
import pipelineModel.proc.Proc;

public class Pipeline {

	static Random rand = new Random(System.currentTimeMillis());

	public static Random getRand() {
		return rand;
	}

	private LinkedList<Proc> line;
	private Vector in;
	private Vector out;

	private int rang = 1;
	private int currentNumberAmount;
	private int razriadnost;
	int timeCounter;

	public Pipeline(int m, int r, int p) {
		in = new Vector();
		out = new Vector();
		rang = r;
		razriadnost = p;
		initInVectors(m, p);
		initLine(p);
	}
	
	public Pipeline(int m, int r, int p, Vector array) {
		in = array;
		out = new Vector();
		rang = r;
		razriadnost = p;
		initLine(p);
	}

	public Pipeline(int m, int r, int p, int n, int[] ti) {
		this(m, r, p);
	}

	public void addTriple(Triple tr) {
		out.addTriple(tr.getDivident(), tr.getDivision(), tr.getQuotient());
	}

	public int getRazr() {
		return razriadnost;
	}

	public Triple getTriple() {
		return in.getTriple();
	}

	private void initInVectors(int m, int p) {
		int maxNumber = (int) Math.pow(2, p);
		for (int counter = 0; counter < m; counter++) {
			int divident = rand.nextInt(maxNumber - 1) + 1;
			int division = rand.nextInt(maxNumber - 1) + 1;
			int quotient = 0;
			in.addTriple(divident, division, quotient);
		}
	}

	private void initLine(int p) {
		line = new LinkedList<>();
		// output
		line.addFirst(new OutputProc(this));
		line.addFirst(new AnswerProc(this, line.getFirst()));
		for (int i = 0; i < razriadnost; i++) {
			line.addFirst(new MinuseProc(line.getFirst()));
		}
		line.addFirst(new FirstMinuseProc(line.getFirst()));
		line.addFirst(new PoriadokProc(line.getFirst()));
		// input
		line.addFirst(new InputProc(this, line.getFirst()));
	}

	public static class Vector extends LinkedList<Triple> {
		/**
		 * 
		 */
		private static final long serialVersionUID = -4543669865469593921L;

		public void addTriple(int x, int y, int z) {
			addFirst(new Triple(x, y, z));
		}

		public Triple getTriple() {
			if (isEmpty())
				return null;
			return pop();
		}
		
		public Vector() {
			super();
		}
	}

	public void run() {
		while (!(in.isEmpty() && isLineEmpty())) {
			for (int i = line.size() - 1; i >= 0; i--)
				line.get(i).perfom();
			timeCounter++;
		}
	}

	public void DecrementCurrentNumber() {
		currentNumberAmount--;
	}

	public void IncrementCurrentNumber() {
		currentNumberAmount++;
	}

	public List<Triple> getInput() {
		return in;
	}

	public List<Triple> getResult() {
		return out;
	}

	public boolean isLineEmpty() {
		return currentNumberAmount == 0;
	}

	public boolean isLineFull() {
		return currentNumberAmount < 0;
	}

	public List<Proc> getLine() {
		return line;
	}
}
