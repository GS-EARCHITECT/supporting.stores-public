package storeMovementManager.model;

import java.io.Serializable;


public class ResourceCategoryDTO implements Serializable 
{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -5311972246720456412L;
		private Integer resourceCategorySeqNo;
		private String description;		
		private Integer parResourceCategorySeqNo;
		private String remark;
		private String resourceCategory;
		private String resourceCategoryId;
		private String resourceTypeId;
		private Integer specificationSeqNo;
		private Integer statusSeqNo;

		public Integer getResourceCategorySeqNo() {
			return this.resourceCategorySeqNo;
		}

		public void setResourceCategorySeqNo(Integer resourceCategorySeqNo) {
			this.resourceCategorySeqNo = resourceCategorySeqNo;
		}

		public String getDescription() {
			return this.description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getParResourceCategorySeqNo() {
			return this.parResourceCategorySeqNo;
		}

		public void setParResourceCategorySeqNo(Integer parResourceCategorySeqNo) {
			this.parResourceCategorySeqNo = parResourceCategorySeqNo;
		}

		public String getRemark() {
			return this.remark;
		}

		public void setRemark(String remark) {
			this.remark = remark;
		}

		public String getResourceCategory() {
			return this.resourceCategory;
		}

		public void setResourceCategory(String resourceCategory) {
			this.resourceCategory = resourceCategory;
		}

		public String getResourceCategoryId() {
			return this.resourceCategoryId;
		}

		public void setResourceCategoryId(String resourceCategoryId) {
			this.resourceCategoryId = resourceCategoryId;
		}

		public String getResourceTypeId() {
			return this.resourceTypeId;
		}

		public void setResourceTypeId(String resourceTypeId) {
			this.resourceTypeId = resourceTypeId;
		}

		public Integer getSpecificationSeqNo() {
			return this.specificationSeqNo;
		}

		public void setSpecificationSeqNo(Integer specificationSeqNo) {
			this.specificationSeqNo = specificationSeqNo;
		}

		public Integer getStatusSeqNo() {
			return this.statusSeqNo;
		}

		public void setStatusSeqNo(Integer statusSeqNo) {
			this.statusSeqNo = statusSeqNo;
		}

}
