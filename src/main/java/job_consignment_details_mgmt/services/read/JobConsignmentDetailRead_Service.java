package job_consignment_details_mgmt.services.read;

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
import job_consignment_details_mgmt.model.repo.read.JobConsignmentDetailsRead_Repo;

@Service("jobConsignmentDetailsReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobConsignmentDetailRead_Service implements I_JobConsignmentDetailsRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobConsignmentDetailService.class);

	@Autowired
	private JobConsignmentDetailsRead_Repo jobConsignmentDetailsReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getAllJobConsignmentDetails()  
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentDetail> jobList = (CopyOnWriteArrayList<JobConsignmentDetail>) jobConsignmentDetailsReadRepo.findAll();
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetails(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentDetail> jobList = (CopyOnWriteArrayList<JobConsignmentDetail>) jobConsignmentDetailsReadRepo.getSelectJobConsignmentDetails(jcmSeqNos);
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetailsByResources(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentDetail> jobList = (CopyOnWriteArrayList<JobConsignmentDetail>) jobConsignmentDetailsReadRepo.getSelectJobConsignmentDetailsByResources(pids);
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> getSelectJobConsignmentDetailsByAssets(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentDetail_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentDetail> jobList = (CopyOnWriteArrayList<JobConsignmentDetail>) jobConsignmentDetailsReadRepo.getSelectJobConsignmentDetailsByAssets(pids);
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentDetail_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentDetail_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	private synchronized CopyOnWriteArrayList<JobConsignmentDetail_DTO> getJobConsignmentDetail_DTOs(CopyOnWriteArrayList<JobConsignmentDetail> jobDetailss) {
		JobConsignmentDetail_DTO jobDTO = null;
		CopyOnWriteArrayList<JobConsignmentDetail_DTO> jobDTOs = new CopyOnWriteArrayList<JobConsignmentDetail_DTO>();

		for (int i = 0; i < jobDetailss.size(); i++) {
			jobDTO = getJobConsignmentDetail_DTO(jobDetailss.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobConsignmentDetail_DTO getJobConsignmentDetail_DTO(JobConsignmentDetail jobDetails2) 
	{
		JobConsignmentDetail_DTO jobDetailsDTO = new JobConsignmentDetail_DTO();
		jobDetailsDTO = new JobConsignmentDetail_DTO();
		jobDetailsDTO.setConsignmentSeqNo(jobDetails2.getId().getConsignmentSeqNo());
		jobDetailsDTO.setAssetSeqNo(jobDetails2.getId().getAssetSeqNo());
		jobDetailsDTO.setQty(jobDetails2.getQty());		
		jobDetailsDTO.setQtyUnitSeqNo(jobDetails2.getQtyUnitSeqNo());
		jobDetailsDTO.setResourceSeqNo(jobDetails2.getId().getResourceSeqNo());
		jobDetailsDTO.setRemark(jobDetails2.getRemark());
		jobDetailsDTO.setStatus(jobDetails2.getStatus());
		return jobDetailsDTO;
	}

}