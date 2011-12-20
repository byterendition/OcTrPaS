package model;

public class Vect<E extends Number> {
	public E[]	vectArr;

	public Vect(E[] vectArr) {
		this.vectArr = vectArr;
	}

	@Override
	public Vect<E> clone() {
		return new Vect<E>(vectArr);
	}

	public int getDim() {
		return vectArr.length;
	}

	public boolean equals(Vect<E> compare_vect) {
		int size = getDim();
		if (compare_vect.getDim() != size) {
			return false;
		}

		for (int dim = 0; dim < size; dim++) {
			if (compare_vect.vectArr[dim] != vectArr[dim]) {
				return false;
			}
		}

		return true;
	}

	@SuppressWarnings("unchecked")
	public void setVal(int dim, Number val) {
		vectArr[dim] = (E) val;
	}

	public Vect<E> add(Double val) {
		Vect<E> result = clone();
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, (vectArr[dim].doubleValue() + val));
		}
		return result;
	}

	public Vect<E> subtract(Double val) {
		Vect<E> result = clone();
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, (vectArr[dim].doubleValue() - val));
		}
		return result;
	}

	public Vect<E> multiply(Double val) {
		Vect<E> result = clone();
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, (vectArr[dim].doubleValue() * val));
		}
		return result;
	}

	public Vect<E> divide(Double val) {
		Vect<E> result = clone();
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, (vectArr[dim].doubleValue() / val));
		}
		return result;
	}

	public Vect<Short> toShort() {
		Vect<Short> result = new Vect<Short>(new Short[getDim()]);
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, vectArr[dim]);
		}
		return result;
	}

	public Vect<Long> toLong() {
		Vect<Long> result = new Vect<Long>(new Long[getDim()]);
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, vectArr[dim]);
		}
		return result;
	}

	public Vect<Integer> toInteger() {
		Vect<Integer> result = new Vect<Integer>(new Integer[getDim()]);
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, vectArr[dim]);
		}
		return result;
	}

	public Vect<Double> toDouble() {
		Vect<Double> result = new Vect<Double>(new Double[getDim()]);
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, vectArr[dim]);
		}
		return result;
	}

	public Vect<Float> toFloat() {
		Vect<Float> result = new Vect<Float>(new Float[getDim()]);
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, vectArr[dim]);
		}
		return result;
	}

	public Vect<Byte> toByte() {
		Vect<Byte> result = new Vect<Byte>(new Byte[getDim()]);
		for (int dim = 0; dim < getDim(); dim++) {
			result.setVal(dim, vectArr[dim]);
		}
		return result;
	}
}
