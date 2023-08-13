package store_order_asset_outwards_mgmt.model.dto;

import java.io.Serializable;

public class StoreOrderAssetOutward_DTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6011016281898258917L;
	private Long storeRequestSeqNo;
	private Long assetSeqNo;
	private Character doneflag;
	private Character flagAllocated;
	private Character flagBooked;
	private Character flagRequested;
	private String fromDttm;
	private Character isBooked;
	private Long jobWorkSeqNo;
	private Long locationSeqNo;
	private Long modeTxn;
	private Character movedFlag;
	private Character okflag;
	private Long requestedToPartySeqNo;
	private Long requestorSeqNo;
	private String toDttm;

	public Long getStoreRequestSeqNo() {
		return storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Character getFlagAllocated() {
		return flagAllocated;
	}

	public void setFlagAllocated(Character flagAllocated) {
		this.flagAllocated = flagAllocated;
	}

	public Character getFlagBooked() {
		return flagBooked;
	}

	public void setFlagBooked(Character flagBooked) {
		this.flagBooked = flagBooked;
	}

	public Character getFlagRequested() {
		return flagRequested;
	}

	public void setFlagRequested(Character flagRequested) {
		this.flagRequested = flagRequested;
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

	public Character getMovedFlag() {
		return movedFlag;
	}

	public void setMovedFlag(Character movedFlag) {
		this.movedFlag = movedFlag;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
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

	public String getToDttm() {
		return toDttm;
	}

	public void setToDttm(String toDttm) {
		this.toDttm = toDttm;
	}

	public StoreOrderAssetOutward_DTO(Long storeRequestSeqNo, Long assetSeqNo, Character doneflag,
			Character flagAllocated, Character flagBooked, Character flagRequested, String fromDttm, Character isBooked,
			Long jobWorkSeqNo, Long locationSeqNo, Long modeTxn, Character movedFlag, Character okflag,
			Long requestedToPartySeqNo, Long requestorSeqNo, String toDttm) {
		super();
		this.storeRequestSeqNo = storeRequestSeqNo;
		this.assetSeqNo = assetSeqNo;
		this.doneflag = doneflag;
		this.flagAllocated = flagAllocated;
		this.flagBooked = flagBooked;
		this.flagRequested = flagRequested;
		this.fromDttm = fromDttm;
		this.isBooked = isBooked;
		this.jobWorkSeqNo = jobWorkSeqNo;
		this.locationSeqNo = locationSeqNo;
		this.modeTxn = modeTxn;
		this.movedFlag = movedFlag;
		this.okflag = okflag;
		this.requestedToPartySeqNo = requestedToPartySeqNo;
		this.requestorSeqNo = requestorSeqNo;
		this.toDttm = toDttm;
	}

	public StoreOrderAssetOutward_DTO() {
		super();
	}

}