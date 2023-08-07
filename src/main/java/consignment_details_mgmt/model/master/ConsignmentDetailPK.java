package consignment_details_mgmt.model.master;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the JOB_CONSIGNMENT_DETAILS database table.
 * 
 */
@Embeddable
public class ConsignmentDetailPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "CONSIGNMENT_SEQ_NO")
	private Long consignmentSeqNo;

	@Column(name = "STORE_MOVEMENT_SEQ_NO")
	private Long storeMovementSeqNo;

	public ConsignmentDetailPK() {
	}

	public Long getConsignmentSeqNo() {
		return consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Long getStoreMovementSeqNo() {
		return storeMovementSeqNo;
	}

	public void setStoreMovementSeqNo(Long storeMovementSeqNo) {
		this.storeMovementSeqNo = storeMovementSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((consignmentSeqNo == null) ? 0 : consignmentSeqNo.hashCode());
		result = prime * result + ((storeMovementSeqNo == null) ? 0 : storeMovementSeqNo.hashCode());
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
		ConsignmentDetailPK other = (ConsignmentDetailPK) obj;
		if (consignmentSeqNo == null) {
			if (other.consignmentSeqNo != null)
				return false;
		} else if (!consignmentSeqNo.equals(other.consignmentSeqNo))
			return false;
		if (storeMovementSeqNo == null) {
			if (other.storeMovementSeqNo != null)
				return false;
		} else if (!storeMovementSeqNo.equals(other.storeMovementSeqNo))
			return false;
		return true;
	}

	public ConsignmentDetailPK(Long consignmentSeqNo, Long storeMovementSeqNo) {
		super();
		this.consignmentSeqNo = consignmentSeqNo;
		this.storeMovementSeqNo = storeMovementSeqNo;
	}

}