package pipelineModel.model;

public class Triple {
	private int divident;
	private int division;
	private int quotient;

	public Triple(int x, int y, int z) {
		divident = x;
		division = y;
		quotient = z;
	}

	/**
	 * @return the divident
	 */
	public int getDivident() {
		return divident;
	}

	/**
	 * @return the division
	 */
	public int getDivision() {
		return division;
	}

	/**
	 * @return the quotient
	 */
	public int getQuotient() {
		return quotient;
	}

	@Override
	public String toString() {
		return Integer.toString(divident) + " " + Integer.toString(division) + " " + Integer.toString(quotient);
	}
}