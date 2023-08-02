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

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "CONSIGNMENT_SEQ_NO")
	private Long consignmentSeqNo;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	public ConsignmentDetailPK() {
	}

	public Long getResourceSeqNo() {
		return this.resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getConsignmentSeqNo() {
		return this.consignmentSeqNo;
	}

	public void setConsignmentSeqNo(Long consignmentSeqNo) {
		this.consignmentSeqNo = consignmentSeqNo;
	}

	public Long getAssetSeqNo() {
		return this.assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConsignmentDetailPK)) {
			return false;
		}
		ConsignmentDetailPK castOther = (ConsignmentDetailPK) other;
		return (this.resourceSeqNo == castOther.resourceSeqNo) && (this.consignmentSeqNo == castOther.consignmentSeqNo)
				&& (this.assetSeqNo == castOther.assetSeqNo);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.resourceSeqNo ^ (this.resourceSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.consignmentSeqNo ^ (this.consignmentSeqNo >>> 32)));
		hash = hash * prime + ((int) (this.assetSeqNo ^ (this.assetSeqNo >>> 32)));

		return hash;
	}

	public ConsignmentDetailPK(Long resourceSeqNo, Long consignmentSeqNo, Long assetSeqNo) {
		super();
		this.resourceSeqNo = resourceSeqNo;
		this.consignmentSeqNo = consignmentSeqNo;
		this.assetSeqNo = assetSeqNo;
	}

}