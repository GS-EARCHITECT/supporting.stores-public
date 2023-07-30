package job_consignment_master_mgmt.services.read;

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
import job_consignment_master_mgmt.model.dto.JobConsignmentMaster_DTO;
import job_consignment_master_mgmt.model.master.JobConsignmentMaster;
import job_consignment_master_mgmt.model.repo.read.JobConsignmentMasterRead_Repo;

@Service("jobConsignmentMasterReadServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobConsignmentMasterRead_Service implements I_JobConsignmentMasterRead_Service 
{

//	private static final Logger logger = LoggerFactory.getLogger(JobConsignmentMasterService.class);

	@Autowired
	private JobConsignmentMasterRead_Repo jobConsignmentMasterReadRepo;
	
	@Autowired
	private Executor asyncExecutor;
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getAllJobConsignmentMasters()  
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentMaster> jobList = (CopyOnWriteArrayList<JobConsignmentMaster>) jobConsignmentMasterReadRepo.findAll();
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;

	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMasters(CopyOnWriteArrayList<Long> jcmSeqNos)  
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentMaster> jobList = (CopyOnWriteArrayList<JobConsignmentMaster>) jobConsignmentMasterReadRepo.getSelectJobConsignmentMasters(jcmSeqNos);
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentMaster> jobList = (CopyOnWriteArrayList<JobConsignmentMaster>) jobConsignmentMasterReadRepo.getSelectJobConsignmentMastersByRequests(pids);
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentMaster> jobList = (CopyOnWriteArrayList<JobConsignmentMaster>) jobConsignmentMasterReadRepo.getSelectJobConsignmentMastersByParents(pids);
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentMaster> jobList = (CopyOnWriteArrayList<JobConsignmentMaster>) jobConsignmentMasterReadRepo.getSelectJobConsignmentMastersForParties(pids);
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}

	@Override
	public CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> getSelectJobConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids) 
	{
		CompletableFuture<CopyOnWriteArrayList<JobConsignmentMaster_DTO>> future = CompletableFuture.supplyAsync(() -> 
		{
		CopyOnWriteArrayList<JobConsignmentMaster> jobList = (CopyOnWriteArrayList<JobConsignmentMaster>) jobConsignmentMasterReadRepo.getSelectJobConsignmentMastersToParties(pids);
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jcmDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();
		jcmDTOs = jobList != null ? this.getJobConsignmentMaster_DTOs(jobList) : null;
		return jcmDTOs;
		},asyncExecutor);

	return future;
	}
	
	private synchronized CopyOnWriteArrayList<JobConsignmentMaster_DTO> getJobConsignmentMaster_DTOs(CopyOnWriteArrayList<JobConsignmentMaster> jobMasters) {
		JobConsignmentMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobConsignmentMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobConsignmentMaster_DTO getJobConsignmentMaster_DTO(JobConsignmentMaster jobMaster2) 
	{
		JobConsignmentMaster_DTO jobMasterDTO = new JobConsignmentMaster_DTO();
		jobMasterDTO = new JobConsignmentMaster_DTO();
		jobMasterDTO.setConsignmentSeqNo(jobMaster2.getConsignmentSeqNo());
		jobMasterDTO.setFromLocationSeqNo(jobMaster2.getFromLocationSeqNo());
		jobMasterDTO.setFromPartySeqNo(jobMaster2.getFromPartySeqNo());		
		jobMasterDTO.setParConsignmentSeqNo(jobMaster2.getParConsignmentSeqNo());
		jobMasterDTO.setStoreRequestSeqNo(jobMaster2.getStoreRequestSeqNo());
		jobMasterDTO.setToLocationSeqNo(jobMaster2.getToLocationSeqNo());
		jobMasterDTO.setToPartySeqNo(jobMaster2.getToPartySeqNo());		
		jobMasterDTO.setRemark(jobMaster2.getRemark());
		jobMasterDTO.setStatus(jobMaster2.getStatus());
		return jobMasterDTO;
	}

}