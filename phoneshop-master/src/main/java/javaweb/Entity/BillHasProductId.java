package javaweb.Entity;
// Generated Apr 11, 2021, 1:55:39 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * BillHasProductId generated by hbm2java
 */
@Embeddable
public class BillHasProductId implements java.io.Serializable {

	private int billId;
	private int productId;

	public BillHasProductId() {
	}

	public BillHasProductId(int billId, int productId) {
		this.billId = billId;
		this.productId = productId;
	}

	@Column(name = "BILL_ID", nullable = false)
	public int getBillId() {
		return this.billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	@Column(name = "PRODUCT_ID", nullable = false)
	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof BillHasProductId))
			return false;
		BillHasProductId castOther = (BillHasProductId) other;

		return (this.getBillId() == castOther.getBillId()) && (this.getProductId() == castOther.getProductId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getBillId();
		result = 37 * result + this.getProductId();
		return result;
	}

}
