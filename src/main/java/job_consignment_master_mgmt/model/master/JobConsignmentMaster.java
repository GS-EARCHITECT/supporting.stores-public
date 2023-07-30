package job_consignment_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the JOB_CONSIGNMENT_MASTER database table.
 * 
 */
@Entity
@Table(name = "JOB_CONSIGNMENT_MASTER")
public class JobConsignmentMaster implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSIGNMENT_SEQUENCE")
	@SequenceGenerator(name = "CONSIGNMENT_SEQUENCE", sequenceName = "CONSIGNMENT_SEQUENCE", allocationSize = 1)
	@Column(name = "CONSIGNMENT_SEQ_NO")
	private Long consignmentSeqNo;

	@Column(name = "FROM_LOCATION_SEQ_NO")
	private Long fromLocationSeqNo;

	@Column(name = "FROM_PARTY_SEQ_NO")
	private Long fromPartySeqNo;

	@Column(name = "PAR_CONSIGNMENT_SEQ_NO")
	private Long parConsignmentSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "STORE_REQUEST_SEQ_NO")
	private Long storeRequestSeqNo;

	@Column(name = "TO_LOCATION_SEQ_NO")
	private String toLocationSeqNo;

	@Column(name = "TO_PARTY_SEQ_NO")
	private Long toPartySeqNo;

	public JobConsignmentMaster() {
	}

	public Long getConsignmentSeqNo() {
		return this.consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Long getFromLocationSeqNo() {
		return this.fromLocationSeqNo;
	}

	public void setFromLocationSeqNo(Long fromLocationSeqNo) {
		this.fromLocationSeqNo = fromLocationSeqNo;
	}

	public Long getFromPartySeqNo() {
		return this.fromPartySeqNo;
	}

	public void setFromPartySeqNo(Long fromPartySeqNo) {
		this.fromPartySeqNo = fromPartySeqNo;
	}

	public Long getParConsignmentSeqNo() {
		return this.parConsignmentSeqNo;
	}

	public void setParConsignmentSeqNo(Long parConsignmentSeqNo) {
		this.parConsignmentSeqNo = parConsignmentSeqNo;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getStoreRequestSeqNo() {
		return this.storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	public String getToLocationSeqNo() {
		return this.toLocationSeqNo;
	}

	public void setToLocationSeqNo(String toLocationSeqNo) {
		this.toLocationSeqNo = toLocationSeqNo;
	}

	public Long getToPartySeqNo() {
		return this.toPartySeqNo;
	}

	public void setToPartySeqNo(Long toPartySeqNo) {
		this.toPartySeqNo = toPartySeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consignmentSeqNo == null) ? 0 : consignmentSeqNo.hashCode());
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
		JobConsignmentMaster other = (JobConsignmentMaster) obj;
		if (consignmentSeqNo == null) {
			if (other.consignmentSeqNo != null)
				return false;
		} else if (!consignmentSeqNo.equals(other.consignmentSeqNo))
			return false;
		return true;
	}

	public JobConsignmentMaster(java.lang.Long consignmentSeqNo, java.lang.Long fromLocationSeqNo,
			java.lang.Long fromPartySeqNo, java.lang.Long parConsignmentSeqNo, String remark, String status,
			java.lang.Long storeRequestSeqNo, String toLocationSeqNo, java.lang.Long toPartySeqNo) {
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

}