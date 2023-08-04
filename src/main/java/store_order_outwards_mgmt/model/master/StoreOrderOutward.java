package store_order_outwards_mgmt.model.master;

import java.io.Serializable;
import java.security.Timestamp;
import javax.persistence.*;

/**
 * The persistent class for the STORE_ORDER_OUTWARDS database table.
 * 
 */
@Entity
@Table(name = "STORE_ORDER_OUTWARDS")
public class StoreOrderOutward implements Serializable 
{


	/**
	 * 
	 */
	private static final long serialVersionUID = 7970305884587235630L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_REQUEST_SEQUENCE")
	@SequenceGenerator(name = "STORE_REQUEST_SEQUENCE", sequenceName = "STORE_REQUEST_SEQUENCE", allocationSize = 1)
	@Column(name = "STORE_REQUEST_SEQ_NO")
	private Long storeRequestSeqNo;

	@Column(name = "DONEFLAG")
	private Character doneflag;

	@Column(name = "IS_BOOKED")
	private Character isBooked;

	@Column(name = "ITEM_SEQ_NO")
	private Long itemSeqNo;

	@Column(name = "JOB_WORK_SEQ_NO")
	private Long jobWorkSeqNo;

	@Column(name = "MODE_TXN")
	private Short modeTxn;

	@Column(name = "MOVED_QTY")
	private Float movedQty;

	@Column(name = "OKFLAG")
	private Character okflag;

	@Column(name = "QTY_ALLOCATED")
	private Float qtyAllocated;

	@Column(name = "QTY_BOOKED")
	private Float qtyBooked;

	@Column(name = "QTY_REQUESTED")
	private Float qtyRequested;

	@Column(name = "QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	@Column(name = "REQUESTOR_SEQ_NO")
	private Long requestorSeqNo;

	@Column(name = "FROM_DTTM")
	private Timestamp fromDtTm;

	@Column(name = "TO_DTTM")
	private Timestamp toDtTm;

	public StoreOrderOutward() {
	}

	public Long getStoreRequestSeqNo() {
		return storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Character getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Character isBooked) {
		this.isBooked = isBooked;
	}

	public Long getItemSeqNo() {
		return itemSeqNo;
	}

	public void setItemSeqNo(Long itemSeqNo) {
		this.itemSeqNo = itemSeqNo;
	}

	public Long getJobWorkSeqNo() {
		return jobWorkSeqNo;
	}

	public void setJobWorkSeqNo(Long jobWorkSeqNo) {
		this.jobWorkSeqNo = jobWorkSeqNo;
	}

	public Short getModeTxn() {
		return modeTxn;
	}

	public void setModeTxn(Short modeTxn) {
		this.modeTxn = modeTxn;
	}

	public Float getMovedQty() {
		return movedQty;
	}

	public void setMovedQty(Float movedQty) {
		this.movedQty = movedQty;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Float getQtyAllocated() {
		return qtyAllocated;
	}

	public void setQtyAllocated(Float qtyAllocated) {
		this.qtyAllocated = qtyAllocated;
	}

	public Float getQtyBooked() {
		return qtyBooked;
	}

	public void setQtyBooked(Float qtyBooked) {
		this.qtyBooked = qtyBooked;
	}

	public Float getQtyRequested() {
		return qtyRequested;
	}

	public void setQtyRequested(Float qtyRequested) {
		this.qtyRequested = qtyRequested;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Long getRequestorSeqNo() {
		return requestorSeqNo;
	}

	public void setRequestorSeqNo(Long requestorSeqNo) {
		this.requestorSeqNo = requestorSeqNo;
	}

	public Timestamp getFromDtTm() {
		return fromDtTm;
	}

	public void setFromDtTm(Timestamp fromDtTm) {
		this.fromDtTm = fromDtTm;
	}

	public Timestamp getToDtTm() {
		return toDtTm;
	}

	public void setToDtTm(Timestamp toDtTm) {
		this.toDtTm = toDtTm;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemSeqNo == null) ? 0 : itemSeqNo.hashCode());
		result = prime * result + ((jobWorkSeqNo == null) ? 0 : jobWorkSeqNo.hashCode());
		result = prime * result + ((storeRequestSeqNo == null) ? 0 : storeRequestSeqNo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StoreOrderOutward other = (StoreOrderOutward) obj;
		if (itemSeqNo == null) {
			if (other.itemSeqNo != null)
				return false;
		} else if (!itemSeqNo.equals(other.itemSeqNo))
			return false;
		if (jobWorkSeqNo == null) {
			if (other.jobWorkSeqNo != null)
				return false;
		} else if (!jobWorkSeqNo.equals(other.jobWorkSeqNo))
			return false;
		if (storeRequestSeqNo == null) {
			if (other.storeRequestSeqNo != null)
				return false;
		} else if (!storeRequestSeqNo.equals(other.storeRequestSeqNo))
			return false;
		return true;
	}

	public StoreOrderOutward(Long storeRequestSeqNo, Character doneflag, Character isBooked, Long itemSeqNo,
			Long jobWorkSeqNo, Short modeTxn, Float movedQty, Character okflag, Float qtyAllocated, Float qtyBooked,
			Float qtyRequested, Long qtyUnitSeqNo, Long requestorSeqNo, Timestamp fromDtTm, Timestamp toDtTm) {
		super();
		this.storeRequestSeqNo = storeRequestSeqNo;
		this.doneflag = doneflag;
		this.isBooked = isBooked;
		this.itemSeqNo = itemSeqNo;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.modeTxn = modeTxn;
		this.movedQty = movedQty;
		this.okflag = okflag;
		this.qtyAllocated = qtyAllocated;
		this.qtyBooked = qtyBooked;
		this.qtyRequested = qtyRequested;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.requestorSeqNo = requestorSeqNo;
		this.fromDtTm = fromDtTm;
		this.toDtTm = toDtTm;
	}

}