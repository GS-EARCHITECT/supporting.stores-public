package store_order_resource_outwards_mgmt.model.dto;

import java.io.Serializable;

public class StoreOrderResourceOutward_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -327473594055096301L;
	private Long storeRequestSeqNo;
	private Character doneflag;
	private String fromDttm;
	private Character isBooked;
	private Long jobWorkSeqNo;
	private Long locationSeqNo;
	private Long modeTxn;
	private Float movedQty;
	private Character okflag;
	private Float qtyAllocated;
	private Float qtyBooked;
	private Float qtyRequested;
	private Long qtyUnitSeqNo;
	private Long requestedToPartySeqNo;
	private Long requestorSeqNo;
	private Long resourceSeqNo;
	private String toDttm;
	private Long targetWorkSeqNo;
	private Long toLocationSeqNo;
	private Long frLocationSeqNo;

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

	public String getFromDttm() {
		return fromDttm;
	}

	public void setFromDttm(String fromDttm) {
		this.fromDttm = fromDttm;
	}

	public Character getIsBooked() {
		return isBooked;
	}

	public void setIsBooked(Character isBooked) {
		this.isBooked = isBooked;
	}

	public Long getJobWorkSeqNo() {
		return jobWorkSeqNo;
	}

	public void setJobWorkSeqNo(Long jobWorkSeqNo) {
		this.jobWorkSeqNo = jobWorkSeqNo;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Long getModeTxn() {
		return modeTxn;
	}

	public void setModeTxn(Long modeTxn) {
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

	public Long getRequestedToPartySeqNo() {
		return requestedToPartySeqNo;
	}

	public void setRequestedToPartySeqNo(Long requestedToPartySeqNo) {
		this.requestedToPartySeqNo = requestedToPartySeqNo;
	}

	public Long getRequestorSeqNo() {
		return requestorSeqNo;
	}

	public void setRequestorSeqNo(Long requestorSeqNo) {
		this.requestorSeqNo = requestorSeqNo;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public StoreOrderResourceOutward_DTO(Long storeRequestSeqNo, Character doneflag, String fromDttm,
			Character isBooked, Long jobWorkSeqNo, Long locationSeqNo, Long modeTxn, Float movedQty, Character okflag,
			Float qtyAllocated, Float qtyBooked, Float qtyRequested, Long qtyUnitSeqNo, Long requestedToPartySeqNo,
			Long requestorSeqNo, Long resourceSeqNo, String toDttm, Long targetWorkSeqNo, Long toLocationSeqNo,
			Long frLocationSeqNo) {
		super();
		this.storeRequestSeqNo = storeRequestSeqNo;
		this.doneflag = doneflag;
		this.fromDttm = fromDttm;
		this.isBooked = isBooked;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.modeTxn = modeTxn;
		this.movedQty = movedQty;
		this.okflag = okflag;
		this.qtyAllocated = qtyAllocated;
		this.qtyBooked = qtyBooked;
		this.qtyRequested = qtyRequested;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.requestedToPartySeqNo = requestedToPartySeqNo;
		this.requestorSeqNo = requestorSeqNo;
		this.resourceSeqNo = resourceSeqNo;
		this.toDttm = toDttm;
		this.targetWorkSeqNo = targetWorkSeqNo;
		this.toLocationSeqNo = toLocationSeqNo;
		this.frLocationSeqNo = frLocationSeqNo;
	}

	public Long getTargetWorkSeqNo() {
		return targetWorkSeqNo;
	}

	public void setTargetWorkSeqNo(Long targetWorkSeqNo) {
		this.targetWorkSeqNo = targetWorkSeqNo;
	}

	public Long getToLocationSeqNo() {
		return toLocationSeqNo;
	}

	public void setToLocationSeqNo(Long toLocationSeqNo) {
		this.toLocationSeqNo = toLocationSeqNo;
	}

	public Long getFrLocationSeqNo() {
		return frLocationSeqNo;
	}

	public void setFrLocationSeqNo(Long frLocationSeqNo) {
		this.frLocationSeqNo = frLocationSeqNo;
	}

	public StoreOrderResourceOutward_DTO() {
		super();
	}

}