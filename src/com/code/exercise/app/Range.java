package com.code.exercise.app;

public class Range {
	private int lowerLimit;
	private int upperLimit;
	public Range(int lowerLimit, int upperLimit) {
		if(lowerLimit <= upperLimit) {
			this.lowerLimit = lowerLimit;
			this.upperLimit = upperLimit;
		} else {
			this.lowerLimit = upperLimit;
			this.upperLimit = lowerLimit;	
		}
	}
	/**
	 * @return the lowerLimit
	 */
	public int getLowerLimit() {
		return lowerLimit;
	}
	/**
	 * @param lowerLimit the lowerLimit to set
	 */
	public void setLowerLimit(int lowerLimit) {
		this.lowerLimit = lowerLimit;
	}
	/**
	 * @return the upperLimit
	 */
	public int getUpperLimit() {
		return upperLimit;
	}
	/**
	 * @param upperLimit the upperLimit to set
	 */
	public void setUpperLimit(int upperLimit) {
		this.upperLimit = upperLimit;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + lowerLimit + ", " + upperLimit + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lowerLimit;
		result = prime * result + upperLimit;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Range other = (Range) obj;
		if (lowerLimit != other.lowerLimit)
			return false;
		if (upperLimit != other.upperLimit)
			return false;
		return true;
	}
	
}
