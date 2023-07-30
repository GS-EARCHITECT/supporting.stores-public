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
import job_consignment_master_mgmt.model.dto.JobConsignmentMaster_DTO;
import job_consignment_master_mgmt.model.master.JobConsignmentMaster;
import job_consignment_master_mgmt.model.repo.cud.JobConsignmentMasterCUD_Repo;

@Service("jobConsignmentMasterCUDServ")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED)
public class JobConsignmentMasterCUD_Service implements I_JobConsignmentMasterCUD_Service {

	// private static final Logger logger =
	// LoggerFactory.getLogger(JobConsignmentMasterService.class);

	@Autowired
	private JobConsignmentMasterCUD_Repo jobConsignmentMasterCUDRepo;

	@Autowired
	private Executor asyncExecutor;

	@Override
	public CompletableFuture<JobConsignmentMaster_DTO> newJobConsignmentMaster(
			JobConsignmentMaster_DTO jobConsignmentMaster_DTO) {
		CompletableFuture<JobConsignmentMaster_DTO> future = CompletableFuture.supplyAsync(() -> 
		{
			JobConsignmentMaster_DTO jcmDTO = null;
			if (!jobConsignmentMasterCUDRepo.existsById(jobConsignmentMaster_DTO.getConsignmentSeqNo())) 
			{
				jcmDTO = this.getJobConsignmentMaster_DTO(
						jobConsignmentMasterCUDRepo.save(this.setJobConsignmentMaster_DTO(jobConsignmentMaster_DTO)));
				}
			return jcmDTO;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> updJobConsignmentMaster(JobConsignmentMaster_DTO jobConsignmentMaster_DTO) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			
			if (jobConsignmentMasterCUDRepo.existsById(jobConsignmentMaster_DTO.getConsignmentSeqNo())) 
			{
				jobConsignmentMasterCUDRepo.save(this.setJobConsignmentMaster_DTO(jobConsignmentMaster_DTO));
			}
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentMasters(CopyOnWriteArrayList<Long> jcmSeqNos) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentMasterCUDRepo.delSelectJobConsignmentMasters(jcmSeqNos);
			return;
		}, asyncExecutor);
		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentMastersByRequests(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentMasterCUDRepo.delSelectJobConsignmentMastersByRequests(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentMastersByParents(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentMasterCUDRepo.delSelectJobConsignmentMastersByParents(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentMastersForParties(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentMasterCUDRepo.delSelectJobConsignmentMastersForParties(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delSelectJobConsignmentMastersToParties(CopyOnWriteArrayList<Long> pids) {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentMasterCUDRepo.delSelectJobConsignmentMastersToParties(pids);
			return;
		}, asyncExecutor);

		return future;
	}

	@Override
	public CompletableFuture<Void> delAllConsignmentMasters() {
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			jobConsignmentMasterCUDRepo.deleteAll();
			return;
		}, asyncExecutor);
		return future;
	}

	private synchronized CopyOnWriteArrayList<JobConsignmentMaster_DTO> getJobConsignmentMaster_DTOs(
			CopyOnWriteArrayList<JobConsignmentMaster> jobMasters) {
		JobConsignmentMaster_DTO jobDTO = null;
		CopyOnWriteArrayList<JobConsignmentMaster_DTO> jobDTOs = new CopyOnWriteArrayList<JobConsignmentMaster_DTO>();

		for (int i = 0; i < jobMasters.size(); i++) {
			jobDTO = getJobConsignmentMaster_DTO(jobMasters.get(i));
			jobDTOs.add(jobDTO);
		}
		return jobDTOs;
	}

	private synchronized JobConsignmentMaster_DTO getJobConsignmentMaster_DTO(JobConsignmentMaster jobMaster2) {
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

	private synchronized JobConsignmentMaster setJobConsignmentMaster_DTO(JobConsignmentMaster_DTO jobMasterDTO) {
		JobConsignmentMaster jobMaster = new JobConsignmentMaster();
		jobMaster.setFromLocationSeqNo(jobMasterDTO.getFromLocationSeqNo());
		jobMaster.setFromPartySeqNo(jobMasterDTO.getFromPartySeqNo());
		jobMaster.setParConsignmentSeqNo(jobMasterDTO.getParConsignmentSeqNo());
		jobMaster.setStoreRequestSeqNo(jobMasterDTO.getStoreRequestSeqNo());
		jobMaster.setToLocationSeqNo(jobMasterDTO.getToLocationSeqNo());
		jobMaster.setToPartySeqNo(jobMasterDTO.getToPartySeqNo());
		jobMaster.setRemark(jobMasterDTO.getRemark());
		jobMaster.setStatus(jobMasterDTO.getStatus());
		return jobMaster;
	}

}