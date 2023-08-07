package consignment_master_mgmt.model.dto;

import java.io.Serializable;

public class ConsignmentMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3209787825230110673L;
	private Long consignmentSeqNo;
	private Character doneflag;
	private Long fromLocationSeqNo;
	private Long fromPartySeqNo;
	private Character inflag;
	private Character okflag;
	private Long parConsignmentSeqNo;
	private String remark;
	private String toLocationSeqNo;
	private Long toPartySeqNo;

	public Long getConsignmentSeqNo() {
		return consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Long getFromLocationSeqNo() {
		return fromLocationSeqNo;
	}

	public void setFromLocationSeqNo(Long fromLocationSeqNo) {
		this.fromLocationSeqNo = fromLocationSeqNo;
	}

	public Long getFromPartySeqNo() {
		return fromPartySeqNo;
	}

	public void setFromPartySeqNo(Long fromPartySeqNo) {
		this.fromPartySeqNo = fromPartySeqNo;
	}

	public Character getInflag() {
		return inflag;
	}

	public void setInflag(Character inflag) {
		this.inflag = inflag;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Long getParConsignmentSeqNo() {
		return parConsignmentSeqNo;
	}

	public void setParConsignmentSeqNo(Long parConsignmentSeqNo) {
		this.parConsignmentSeqNo = parConsignmentSeqNo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getToLocationSeqNo() {
		return toLocationSeqNo;
	}

	public void setToLocationSeqNo(String toLocationSeqNo) {
		this.toLocationSeqNo = toLocationSeqNo;
	}

	public Long getToPartySeqNo() {
		return toPartySeqNo;
	}

	public void setToPartySeqNo(Long toPartySeqNo) {
		this.toPartySeqNo = toPartySeqNo;
	}
	
	

	public ConsignmentMaster_DTO(Long consignmentSeqNo, Character doneflag, Long fromLocationSeqNo, Long fromPartySeqNo,
			Character inflag, Character okflag, Long parConsignmentSeqNo, String remark, String toLocationSeqNo, Long toPartySeqNo) {
		super();
		this.consignmentSeqNo = consignmentSeqNo;
		this.doneflag = doneflag;
		this.fromLocationSeqNo = fromLocationSeqNo;
		this.fromPartySeqNo = fromPartySeqNo;
		this.inflag = inflag;
		this.okflag = okflag;
		this.parConsignmentSeqNo = parConsignmentSeqNo;
		this.remark = remark;	
		this.toLocationSeqNo = toLocationSeqNo;
		this.toPartySeqNo = toPartySeqNo;
	}

	public ConsignmentMaster_DTO() {
		super();
	}

}