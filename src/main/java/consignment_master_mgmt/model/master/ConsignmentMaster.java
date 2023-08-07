package consignment_master_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the STORE_CONSIGNMENT_MASTER database table.
 * 
 */
@Entity
@Table(name = "STORE_CONSIGNMENT_MASTER")
public class ConsignmentMaster implements Serializable 
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONSIGNMENT_SEQUENCE")
	@SequenceGenerator(name = "CONSIGNMENT_SEQUENCE", sequenceName = "CONSIGNMENT_SEQUENCE", allocationSize = 1)
	@Column(name = "CONSIGNMENT_SEQ_NO")
	private Long consignmentSeqNo;

	@Column(name = "DONEFLAG")
	private Character doneflag;

	@Column(name = "FROM_LOCATION_SEQ_NO")
	private Long fromLocationSeqNo;

	@Column(name = "FROM_PARTY_SEQ_NO")
	private Long fromPartySeqNo;

	@Column(name = "INFLAG")
	private Character inflag;

	@Column(name = "OKFLAG")
	private Character okflag;

	@Column(name = "PAR_CONSIGNMENT_SEQ_NO")
	private Long parConsignmentSeqNo;

	@Column(name = "REMARK")
	private String remark;

	@Column(name = "TO_LOCATION_SEQ_NO")
	private String toLocationSeqNo;

	@Column(name = "TO_PARTY_SEQ_NO")
	private Long toPartySeqNo;

	public ConsignmentMaster() {
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consignmentSeqNo == null) ? 0 : consignmentSeqNo.hashCode());
		result = prime * result + ((fromLocationSeqNo == null) ? 0 : fromLocationSeqNo.hashCode());
		result = prime * result + ((fromPartySeqNo == null) ? 0 : fromPartySeqNo.hashCode());
		result = prime * result + ((toLocationSeqNo == null) ? 0 : toLocationSeqNo.hashCode());
		result = prime * result + ((toPartySeqNo == null) ? 0 : toPartySeqNo.hashCode());
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
		ConsignmentMaster other = (ConsignmentMaster) obj;
		if (consignmentSeqNo == null) {
			if (other.consignmentSeqNo != null)
				return false;
		} else if (!consignmentSeqNo.equals(other.consignmentSeqNo))
			return false;
		if (fromLocationSeqNo == null) {
			if (other.fromLocationSeqNo != null)
				return false;
		} else if (!fromLocationSeqNo.equals(other.fromLocationSeqNo))
			return false;
		if (fromPartySeqNo == null) {
			if (other.fromPartySeqNo != null)
				return false;
		} else if (!fromPartySeqNo.equals(other.fromPartySeqNo))
			return false;
		if (toLocationSeqNo == null) {
			if (other.toLocationSeqNo != null)
				return false;
		} else if (!toLocationSeqNo.equals(other.toLocationSeqNo))
			return false;
		if (toPartySeqNo == null) {
			if (other.toPartySeqNo != null)
				return false;
		} else if (!toPartySeqNo.equals(other.toPartySeqNo))
			return false;
		return true;
	}

	public ConsignmentMaster(Long consignmentSeqNo, Character doneflag, Long fromLocationSeqNo,
			Long fromPartySeqNo, Character inflag, Character okflag, Long parConsignmentSeqNo, String remark,
			String toLocationSeqNo, Long toPartySeqNo) {
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

}