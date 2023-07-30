package job_consignment_details_mgmt.model.dto;

import java.io.Serializable;

public class JobConsignmentMaster_DTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2793349008458763803L;
	private Long consignmentSeqNo;
	private Long fromLocationSeqNo;
	private Long fromPartySeqNo;
	private Long parConsignmentSeqNo;
	private String remark;
	private String status;
	private Long storeRequestSeqNo;
	private String toLocationSeqNo;
	private Long toPartySeqNo;

	public Long getConsignmentSeqNo() {
		return consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getStoreRequestSeqNo() {
		return storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
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

	public JobConsignmentMaster_DTO(Long consignmentSeqNo, Long fromLocationSeqNo, Long fromPartySeqNo,
			Long parConsignmentSeqNo, String remark, String status, Long storeRequestSeqNo, String toLocationSeqNo,
			Long toPartySeqNo) {
		super();
		this.consignmentSeqNo = consignmentSeqNo;
		this.fromLocationSeqNo = fromLocationSeqNo;
		this.fromPartySeqNo = fromPartySeqNo;
		this.parConsignmentSeqNo = parConsignmentSeqNo;
		this.remark = remark;
		this.status = status;
		this.storeRequestSeqNo = storeRequestSeqNo;
		this.toLocationSeqNo = toLocationSeqNo;
		this.toPartySeqNo = toPartySeqNo;
	}

	public JobConsignmentMaster_DTO() {
		super();
	}

}