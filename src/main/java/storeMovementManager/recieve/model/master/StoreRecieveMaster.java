package storeMovementManager.recieve.model.master;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * The persistent class for the STORE_RECIEVE_MASTER database table.
 * 
 */
@Entity
@Table(name = "STORE_RECIEVE_MASTER")
public class StoreRecieveMaster implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_MOVEMENT_SEQUENCE")
	@SequenceGenerator(name = "STORE_MOVEMENT_SEQUENCE", sequenceName = "STORE_MOVEMENT_SEQUENCE", allocationSize = 1)
	@Column(name = "STORE_MOVEMENT_SEQ_NO")
	private Long storeMovementSeqNo;

	@Column(name = "APPLIED_ON")
	private Timestamp appliedOn;

	@Column(name = "ASSET_SEQ_NO")
	private Long assetSeqNo;

	@Column(name = "CONSIGN_QTY")
	private Float consignQty;

	@Column(name = "CONSIGNED_ON")
	private Timestamp consignedOn;

	@Column(name = "DONEFLAG")
	private Character doneflag;

	@Column(name = "LOCATION_SEQ_NO")
	private Long locationSeqNo;

	@Column(name = "OKFLAG")
	private Character okflag;

	@Column(name = "PROCESSED_ON")
	private Timestamp processedOn;

	@Column(name = "PROCESSED_QTY")
	private Float processedQty;

	@Column(name = "QTY_UNIT_SEQ_NO")
	private Long qtyUnitSeqNo;

	@Column(name = "QUALITY_QTY")
	private Float qualityQty;

	@Column(name = "RECIEVED_QTY")
	private Float recievedQty;

	@Column(name = "RESOURCE_SEQ_NO")
	private Long resourceSeqNo;

	@Column(name = "STORE_REQUEST_SEQ_NO")
	private Long storeRequestSeqNo;

	public StoreRecieveMaster() {
	}

	public Long getStoreMovementSeqNo() {
		return storeMovementSeqNo;
	}

	public void setStoreMovementSeqNo(Long storeMovementSeqNo) {
		this.storeMovementSeqNo = storeMovementSeqNo;
	}

	public Timestamp getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(Timestamp appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Long getAssetSeqNo() {
		return assetSeqNo;
	}

	public void setAssetSeqNo(Long assetSeqNo) {
		this.assetSeqNo = assetSeqNo;
	}

	public Float getConsignQty() {
		return consignQty;
	}

	public void setConsignQty(Float consignQty) {
		this.consignQty = consignQty;
	}

	public Timestamp getConsignedOn() {
		return consignedOn;
	}

	public void setConsignedOn(Timestamp consignedOn) {
		this.consignedOn = consignedOn;
	}

	public Character getDoneflag() {
		return doneflag;
	}

	public void setDoneflag(Character doneflag) {
		this.doneflag = doneflag;
	}

	public Long getLocationSeqNo() {
		return locationSeqNo;
	}

	public void setLocationSeqNo(Long locationSeqNo) {
		this.locationSeqNo = locationSeqNo;
	}

	public Character getOkflag() {
		return okflag;
	}

	public void setOkflag(Character okflag) {
		this.okflag = okflag;
	}

	public Timestamp getProcessedOn() {
		return processedOn;
	}

	public void setProcessedOn(Timestamp processedOn) {
		this.processedOn = processedOn;
	}

	public Float getProcessedQty() {
		return processedQty;
	}

	public void setProcessedQty(Float processedQty) {
		this.processedQty = processedQty;
	}

	public Long getQtyUnitSeqNo() {
		return qtyUnitSeqNo;
	}

	public void setQtyUnitSeqNo(Long qtyUnitSeqNo) {
		this.qtyUnitSeqNo = qtyUnitSeqNo;
	}

	public Float getQualityQty() {
		return qualityQty;
	}

	public void setQualityQty(Float qualityQty) {
		this.qualityQty = qualityQty;
	}

	public Float getRecievedQty() {
		return recievedQty;
	}

	public void setRecievedQty(Float recievedQty) {
		this.recievedQty = recievedQty;
	}

	public Long getResourceSeqNo() {
		return resourceSeqNo;
	}

	public void setResourceSeqNo(Long resourceSeqNo) {
		this.resourceSeqNo = resourceSeqNo;
	}

	public Long getStoreRequestSeqNo() {
		return storeRequestSeqNo;
	}

	public void setStoreRequestSeqNo(Long storeRequestSeqNo) {
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetSeqNo == null) ? 0 : assetSeqNo.hashCode());
		result = prime * result + ((locationSeqNo == null) ? 0 : locationSeqNo.hashCode());
		result = prime * result + ((resourceSeqNo == null) ? 0 : resourceSeqNo.hashCode());
		result = prime * result + ((storeMovementSeqNo == null) ? 0 : storeMovementSeqNo.hashCode());
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
		StoreRecieveMaster other = (StoreRecieveMaster) obj;
		if (assetSeqNo == null) {
			if (other.assetSeqNo != null)
				return false;
		} else if (!assetSeqNo.equals(other.assetSeqNo))
			return false;
		if (locationSeqNo == null) {
			if (other.locationSeqNo != null)
				return false;
		} else if (!locationSeqNo.equals(other.locationSeqNo))
			return false;
		if (resourceSeqNo == null) {
			if (other.resourceSeqNo != null)
				return false;
		} else if (!resourceSeqNo.equals(other.resourceSeqNo))
			return false;
		if (storeMovementSeqNo == null) {
			if (other.storeMovementSeqNo != null)
				return false;
		} else if (!storeMovementSeqNo.equals(other.storeMovementSeqNo))
			return false;
		if (storeRequestSeqNo == null) {
			if (other.storeRequestSeqNo != null)
				return false;
		} else if (!storeRequestSeqNo.equals(other.storeRequestSeqNo))
			return false;
		return true;
	}

	public StoreRecieveMaster(Long storeMovementSeqNo, Timestamp appliedOn, Long assetSeqNo, Float consignQty,
			Timestamp consignedOn, Character doneflag, Long locationSeqNo, Character okflag, Timestamp processedOn,
			Float processedQty, Long qtyUnitSeqNo, Float qualityQty, Float recievedQty, Long resourceSeqNo,
			Long storeRequestSeqNo) {
		super();
		this.storeMovementSeqNo = storeMovementSeqNo;
		this.appliedOn = appliedOn;
		this.assetSeqNo = assetSeqNo;
		this.consignQty = consignQty;
		this.consignedOn = consignedOn;
		this.doneflag = doneflag;
		this.locationSeqNo = locationSeqNo;
		this.okflag = okflag;
		this.processedOn = processedOn;
		this.processedQty = processedQty;
		this.qtyUnitSeqNo = qtyUnitSeqNo;
		this.qualityQty = qualityQty;
		this.recievedQty = recievedQty;
		this.resourceSeqNo = resourceSeqNo;
		this.storeRequestSeqNo = storeRequestSeqNo;
	}

}