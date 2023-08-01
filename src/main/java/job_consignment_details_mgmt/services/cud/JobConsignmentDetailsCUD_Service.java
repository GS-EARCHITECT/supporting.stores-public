package job_consignment_details_mgmt.services.cud;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import job_consignment_details_mgmt.model.dto.JobConsignmentDetail_DTO;
import job_consignment_details_mgmt.model.master.JobConsignmentDetail;
import job_consignment_details_mgmt.model.master.JobConsignmentDetailPK;
import job_consignment_details_mgmt.model.repo.cud.JobConsignmentDetailsCUD_Repo;

@Service("jobConsignmentDetailCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobConsignmentDetailsCUD_Service implements I_JobConsignmentDetailsCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobConsignmentDetailService.class);

	@Autowired
	private JobConsignmentDetailsCUD_Repo jobConsignmentDetailsCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<JobConsignmentDetail_DTO> newJobConsignmentDetail(
			JobConsignmentDetail_DTO jobConsignmentDetail_DTO) {
		CompletableFuture<JobConsignmentDetail_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			JobConsignmentDetailPK jobConsignmentDetailPK = new JobConsignmentDetailPK();
			jobConsignmentDetailPK.setAssetSeqNo(jobConsignmentDetail_DTO.getAssetSeqNo());
			jobConsignmentDetailPK.setConsignmentSeqNo(jobConsignmentDetail_DTO.getConsignmentSeqNo());
			jobConsignmentDetailPK.setResourceSeqNo(jobConsignmentDetail_DTO.getResourceSeqNo());
			JobConsignmentDetail_DTO jcmDTO = null;
			if (!jobConsignmentDetailsCUDRepo.existsById(jobConsignmentDetailPK)) 
			{
				jcmDTO = this.getJobConsignmentDetail_DTO(
						jobConsignmentDetailsCUDRepo.save(this.setJobConsignmentDetail_DTO(jobConsignmentDetail_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updJobConsignmentDetail(JobConsignmentDetail_DTO jobConsignmentDetail_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			JobConsignmentDetailPK jobConsignmentDetailPK = new JobConsignmentDetailPK();
			jobConsignmentDetailPK.setAssetSeqNo(jobConsignmentDetail_DTO.getAssetSeqNo());
			jobConsignmentDetailPK.setConsignmentSeqNo(jobConsignmentDetail_DTO.getConsignmentSeqNo());
			jobConsignmentDetailPK.setResourceSeqNo(jobConsignmentDetail_DTO.getResourceSeqNo());
			JobConsignmentDetail_DTO jcmDTO = null;

			if (jobConsignmentDetailsCUDRepo.existsById(jobConsignmentDetailPK)) 
			{
				jobConsignmentDetailsCUDRepo.save(this.setJobConsignmentDetail_DTO(jobConsignmentDetail_DTO));
				
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentDetails(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentDetailsCUDRepo.delSelectJobConsignmentDetails(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentDetailsByResources(CopyOnWriteArrayList<Long> rids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentDetailsCUDRepo.delSelectJobConsignmentDetailsByResources(rids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> aids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentDetailsCUDRepo.delSelectJobConsignmentDetailsByAssets(aids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllConsignmentDetails() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentDetailsCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}


	private synchronized JobConsignmentDetail_DTO getJobConsignmentDetail_DTO(JobConsignmentDetail jobDetail2) {
		JobConsignmentDetail_DTO jobDetailDTO = new JobConsignmentDetail_DTO();
		jobDetailDTO = new JobConsignmentDetail_DTO();
		jobDetailDTO.setConsignmentSeqNo(jobDetail2.getId().getConsignmentSeqNo());
		jobDetailDTO.setAssetSeqNo(jobDetail2.getId().getAssetSeqNo());
		jobDetailDTO.setResourceSeqNo(jobDetail2.getId().getResourceSeqNo());
		jobDetailDTO.setQty(jobDetail2.getQty());
		jobDetailDTO.setQtyUnitSeqNo(jobDetail2.getQtyUnitSeqNo());
		jobDetailDTO.setRemark(jobDetail2.getRemark());
		jobDetailDTO.setStatus(jobDetail2.getStatus());
		return jobDetailDTO;
	}

	private synchronized JobConsignmentDetail setJobConsignmentDetail_DTO(JobConsignmentDetail_DTO jobDetailDTO) {
		JobConsignmentDetail jobDetail = new JobConsignmentDetail();
		JobConsignmentDetailPK jobConsignmentDetailPK = new JobConsignmentDetailPK();
		jobConsignmentDetailPK.setAssetSeqNo(jobDetailDTO.getAssetSeqNo());
		jobConsignmentDetailPK.setConsignmentSeqNo(jobDetailDTO.getConsignmentSeqNo());
		jobConsignmentDetailPK.setResourceSeqNo(jobDetailDTO.getResourceSeqNo());
		jobDetail.setId(jobConsignmentDetailPK);
		jobDetail.setQty(jobDetailDTO.getQty());
		jobDetail.setQtyUnitSeqNo(jobDetailDTO.getQtyUnitSeqNo());
		jobDetail.setRemark(jobDetailDTO.getRemark());
		jobDetail.setStatus(jobDetailDTO.getStatus());
		return jobDetail;
	}

}